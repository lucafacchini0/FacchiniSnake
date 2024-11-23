package com.lucafacchini;

import java.awt.*;

public class UI {
    public void draw(WindowManager wm, Graphics2D g2d) {
        // TODO: Implement a better UI
        g2d.setFont(new Font("Verdana", Font.PLAIN, 20));
        g2d.drawString("Score: " + wm.player.body.size(), wm.WIDTH / 2 - 150, wm.TILE_SIZE);
    }
}
