package com.aor.InputHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter {
    public char chare;
    public boolean  CharUpdated,delete,end,skip;
    public KeyboardController(){
        CharUpdated = false;
        delete = false;
        end = false;
        skip = false;
    }
    @Override
    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            end = true;
        }else if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
            skip = true;
        }
        else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            delete = true;
        }
        else if(e.isActionKey()){
            return;
        }
        else if(Character.isAlphabetic(e.getKeyChar())){
            chare =  Character.toUpperCase(e.getKeyChar());
            CharUpdated = true;
        }
        else{
            e.consume();
        }
    }
}
