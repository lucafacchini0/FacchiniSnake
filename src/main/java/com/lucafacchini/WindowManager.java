package com.lucafacchini;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WindowManager extends JPanel implements Runnable {

    // Window settings
    public final int COLUMNS = 16, ROWS = 16;
    private final int TILE_SIZE = 16;
    private final int SCALE = 4;
    public final int RESCALED_TILE = TILE_SIZE * SCALE;

    Player player = new Player(this);
    KeyHandler kh = new KeyHandler();

    public WindowManager() {
        this.setPreferredSize(new Dimension(COLUMNS * RESCALED_TILE, ROWS * RESCALED_TILE));
        this.setBackground(Color.BLACK);
        this.addKeyListener(kh);

        // Window updater
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this, 0, 16, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, RESCALED_TILE, RESCALED_TILE);

        player.draw((Graphics2D) g);
    }
}
