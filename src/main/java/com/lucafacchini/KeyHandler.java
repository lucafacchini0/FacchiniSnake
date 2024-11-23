package com.lucafacchini;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public int speedX;
    public int speedY;

    public KeyHandler() {
        this.speedX = 1;
        this.speedY = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && speedY != 1) { speedX = 0; speedY = -1; }
        if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && speedY != -1) { speedX = 0; speedY = 1; }
        if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && speedX != 1) { speedX = -1; speedY = 0; }
        if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && speedX != -1) { speedX = 1; speedY = 0; }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
