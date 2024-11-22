package com.lucafacchini;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            System.out.println("W");
        } else if(key == KeyEvent.VK_A) {
            System.out.println("A");
        } else if(key == KeyEvent.VK_S) {
            System.out.println("S");
        } else if(key == KeyEvent.VK_D) {
            System.out.println("D");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
}
