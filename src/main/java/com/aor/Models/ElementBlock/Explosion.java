package com.aor.Models.ElementBlock;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Explosion extends ElementBlock {
    long start;
    boolean vanished;
    public Explosion(int x, int y) {
        super(x,y);
        start = System.currentTimeMillis();
        vanished = false;
    }

    public void draw(TextGraphics graphics) {
        if(!vanished) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "m");
        }
    }

    @Override
    public boolean IsDestroyed() {
        return vanished;
    }

    @Override
    public boolean setDestroyed() {
        return false;
    }

    public long getTime(){
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        return timeElapsed;
    }

    public void setVanished() {
        vanished = true;
    }

    public boolean isVanished() {
        return vanished;
    }
}
