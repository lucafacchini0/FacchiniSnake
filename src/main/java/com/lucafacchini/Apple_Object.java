package com.lucafacchini;

import java.awt.*;
import java.util.Random;

public class Apple_Object {

    // Coordinates
    public int x, y;

    // Debug
    boolean printOneTime = true;

    Random random;
    WindowManager wm;

    public Apple_Object(WindowManager wm) {
        this.wm = wm;
        random = new Random();
    }

    public void spawn() {
        boolean valid = false;

        while(!valid && printOneTime) {
            x = random.nextInt(wm.COLUMNS) * wm.RESCALED_TILE;
            y = random.nextInt(wm.ROWS) * wm.RESCALED_TILE;

            if(wm.player.x != x && wm.player.y != y) { valid = true; }

            printOneTime = false;
        }

    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, wm.RESCALED_TILE, wm.RESCALED_TILE);
    }
}
