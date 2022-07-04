package com.aor.InputHandler;

import com.aor.Music.MusicPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuController extends KeyAdapter {

    public boolean up, down,Enter;
    MusicPlayer music;
    public MenuController(){
        down = false;
        up = false;
        Enter = false;
        music = new MusicPlayer();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
            music.startScrollSound();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
            music.startScrollSound();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Enter = true;
            music.enterSoundEffect();
        }
    }
}
