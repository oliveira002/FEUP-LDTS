package com.aor.InputHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameController extends KeyAdapter {
    public boolean moving;
    public boolean right, left, up, down,Menu,setBomb;
    public GameController(){
        moving = false;
        right = false;
        left = false;
        up = false;
        down = false;
        Menu = false;
        setBomb = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            setBomb = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Menu = true;
        }
    }
}
