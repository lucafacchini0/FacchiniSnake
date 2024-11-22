package com.lucafacchini;

import java.awt.*;

public class Player {
    WindowManager wm;
    int x, y;

    public Player(WindowManager wm) {
        this.wm = wm;
        x = (wm.COLUMNS / 2) * wm.RESCALED_TILE - wm.RESCALED_TILE / 2;
        y = (wm.ROWS / 2) * wm.RESCALED_TILE - wm.RESCALED_TILE / 2;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, wm.RESCALED_TILE, wm.RESCALED_TILE);
    }
}
