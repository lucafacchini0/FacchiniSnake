package com.lucafacchini;

import java.awt.*;
import java.util.Random;

public class Apple extends Tile {

    // Validity of placement
    boolean valid = false;

    // Random number generator
    Random random = new Random();

    public Apple() {
        super(30, 30);
    }

    public void spawn(WindowManager wm) {
        while(!valid) {
            x = random.nextInt(wm.COLUMNS);
            y = random.nextInt(wm.ROWS);

            // TODO: Always valid. Will be changed in the future
            valid = true;
        }
        valid = false;
    }

    public void draw(WindowManager wm, Graphics2D g2d) {
        g2d.setColor(Color.red);
        g2d.fillRect(x * wm.TILE_SIZE, y * wm.TILE_SIZE, wm.TILE_SIZE, wm.TILE_SIZE);
    }
}
