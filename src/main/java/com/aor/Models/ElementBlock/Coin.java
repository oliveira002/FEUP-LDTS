package com.aor.Models.ElementBlock;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends ElementBlock{
    boolean Collected = false;
    public Coin(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        if(Collected){
            return;
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFEA17"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "s");
    }

    @Override
    public boolean IsDestroyed() {
        return Collected;
    }

    @Override
    public boolean setDestroyed() {
        Collected = true;
        return true;
    }
}
