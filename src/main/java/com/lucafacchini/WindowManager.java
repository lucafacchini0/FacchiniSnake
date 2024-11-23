package com.lucafacchini;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class WindowManager extends JPanel implements Runnable {

    // Game Window
    public final int COLUMNS = 48, ROWS = 48;
    public final int TILE_SIZE = 16;
    private final int TILE_SCALE = 1;
    public final int RESCALED_TILE = TILE_SIZE * TILE_SCALE;
    public final int WIDTH = COLUMNS * RESCALED_TILE;
    public final int HEIGHT = ROWS * RESCALED_TILE;

    // Speed control
    private int moveDelay = 5;
    private int moveCounter = 0;

    // Player & Apple
    Player player = new Player();
    Apple apple = new Apple();

    // Collision detection
    CollisionManager cm = new CollisionManager();

    // UI Content
    UI ui = new UI();

    // Key Handler
    KeyHandler kh = new KeyHandler();

    boolean gameOver = false;

    public WindowManager() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);

        // Key listener
        addKeyListener(kh);
        setFocusable(true);

        // Window updater
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this, 0, 16, TimeUnit.MILLISECONDS);

        // Spawn initial apple
        apple.spawn(this);
    }

    @Override
    public void run() {
        move();
        hasLost();
        repaint();
    }

    private void move() {
        moveCounter++;

        if(moveCounter >= moveDelay) {
            player.move(this);
            moveCounter = 0;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        player.draw(this, (Graphics2D) g);
        apple.draw(this, (Graphics2D) g);
        ui.draw(this, (Graphics2D) g);
    }

    private void hasLost() {
        for (Tile current : player.body) {
            if (cm.isColliding(player.head, current)) {
                gameOver = true;
            }
        }

        if (player.head.x < 0 || player.head.x >= COLUMNS || player.head.y < 0 || player.head.y >= ROWS) gameOver = true;

        if(gameOver) {
            System.out.println("GAME OVER -- POINTS: " + player.body.size());
            Thread.currentThread().interrupt();
        }
    }
}