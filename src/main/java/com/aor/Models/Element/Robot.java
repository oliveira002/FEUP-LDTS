package com.aor.Models.Element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Robot extends Element{
    long timeTomMove;
    long wait;
    public Robot(int x, int y) {
        super(x, y);
        robot = true;
        timeTomMove = System.currentTimeMillis();
        wait = 250;
    }
    @Override
    public void moveUp() {
        if(System.currentTimeMillis()-timeTomMove>wait) {
            position.setY(position.getY() - 1);
            timeTomMove = System.currentTimeMillis() ;
        }
    }

    @Override
    public void moveDown() {
        if(System.currentTimeMillis()-timeTomMove>wait) {
            position.setY(position.getY() + 1);
            timeTomMove = System.currentTimeMillis() ;
        }
    }

    @Override
    public void moveLeft() {
        if(System.currentTimeMillis()-timeTomMove>wait) {
            position.setX(position.getX() - 1);
            timeTomMove = System.currentTimeMillis() ;
        }

    }

    @Override
    public void moveRight() {
        if(System.currentTimeMillis()-timeTomMove>wait) {
            position.setX(position.getX() + 1);
            timeTomMove = System.currentTimeMillis();
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ADD8E6"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "g");
    }
    public void notifyTimeBegin(){
        wait = 1000;
    }
    public void notifyTimeEnd(){
        wait = 250;
    }
}