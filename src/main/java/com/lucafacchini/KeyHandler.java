package com.lucafacchini;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean isLeftPressed = false;
    public boolean isRightPressed = false;
    public boolean isUpPressed = false;
    public boolean isDownPressed = false;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    Direction currentDirection = Direction.UP;

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) { currentDirection = Direction.UP; }
        if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) { currentDirection = Direction.DOWN; }
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) { currentDirection = Direction.LEFT; }
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) { currentDirection = Direction.RIGHT; }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
