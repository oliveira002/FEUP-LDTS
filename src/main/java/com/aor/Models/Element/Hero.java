package com.aor.Models.Element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    boolean flag = false;
    public Hero(int x, int y) {
        super(x, y);
        hero = true;
    }

    @Override
    public void moveUp() {
        position.setY(position.getY()-1);
    }

    @Override
    public void moveDown() {
        position.setY(position.getY()+1);
    }

    @Override
    public void moveLeft() {
        position.setX(position.getX()-1);
    }

    @Override
    public void moveRight() {
        position.setX(position.getX()+1);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.enableModifiers(SGR.BOLD);
        if(flag) {
            graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "r");
        }
        else {
            graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "h");
        }
    }
    public void notifySkin(){
        flag = true;
    }
}
