package com.lucafacchini;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    public Tile head;
    public ArrayList<Tile> body;

    public Player() {
        head = new Tile(5, 5);
        body = new ArrayList<>();
    }

    public void move(WindowManager wm) {

        // Check collision with the apple
        if(wm.cm.isColliding(head, wm.apple)) {
            body.add(new Tile(wm.apple.x, wm.apple.y));
            wm.apple.spawn(wm);
        }

        for (int i = body.size() - 1; i >= 0; i--) {
            Tile current = body.get(i);

            if (i != 0) {
                Tile previous = body.get(i - 1);
                current.x = previous.x;
                current.y = previous.y;
            } else {
                current.x = head.x;
                current.y = head.y;
            }
        }

        head.x += wm.kh.speedX;
        head.y += wm.kh.speedY;
    }

    public void draw(WindowManager wm, Graphics2D g2d) {

        // Snake Head
        g2d.setColor(Color.green);
        g2d.fillRect(wm.player.head.x * wm.TILE_SIZE, wm.player.head.y * wm.TILE_SIZE, wm.TILE_SIZE, wm.TILE_SIZE);

        // Snake Body
        for (Tile snakePart : body) {
            g2d.fillRect(snakePart.x * wm.TILE_SIZE, snakePart.y * wm.TILE_SIZE, wm.TILE_SIZE, wm.TILE_SIZE);
        }
    }
}
