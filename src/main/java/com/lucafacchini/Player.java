package com.lucafacchini;

import java.awt.*;

public class Player {

    // Coordinates
    public int x, y;
    public int timeBeforeNextMove = 5;
    public int currentTime = 0;

    WindowManager wm;

    public Player(WindowManager wm) {
        this.wm = wm;
        x = (wm.COLUMNS / 2) * wm.RESCALED_TILE - wm.RESCALED_TILE / 2;
        y = (wm.ROWS / 2) * wm.RESCALED_TILE - wm.RESCALED_TILE / 2;
    }

    public void update() {

        currentTime += 1;

        System.out.println(currentTime);


        if(currentTime >= timeBeforeNextMove) {
            switch(wm.kh.currentDirection) {
                case UP -> y -= wm.RESCALED_TILE;
                case DOWN -> y += wm.RESCALED_TILE ;
                case LEFT -> x -= wm.RESCALED_TILE;
                case RIGHT -> x += wm.RESCALED_TILE;
            }

            // Debugging
            if(x < 0 || x > wm.WINDOW_WIDTH) {
                System.out.println("Game Over");
            }

            if(y < 0 || y > wm.WINDOW_HEIGHT) {
                System.out.println("Game Over");
            }

            currentTime = 0;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, wm.RESCALED_TILE, wm.RESCALED_TILE);
    }
}
