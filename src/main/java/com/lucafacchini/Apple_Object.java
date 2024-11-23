package com.lucafacchini;

import java.awt.*;
import java.util.Random;

public class Apple_Object {

    // Coordinates
    public int x, y;

    // Valid
    boolean valid = false;

    Random random;
    WindowManager wm;

    public Apple_Object(WindowManager wm) {
        this.wm = wm;
        random = new Random();
    }

    /* TODO & Problems
        * 1. There is a chance that the apple spawns at the center of the screen at the game start, colliding with the player
     */
    public void spawn() {
        while(!valid) {
            x = random.nextInt(wm.COLUMNS) * wm.RESCALED_TILE;
            y = random.nextInt(wm.ROWS) * wm.RESCALED_TILE;

            valid = (x >= 0 && x <= wm.WINDOW_WIDTH) && (y >= 0 && y <= wm.WINDOW_HEIGHT);
        }

        valid = false;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, wm.RESCALED_TILE, wm.RESCALED_TILE);
    }
}
