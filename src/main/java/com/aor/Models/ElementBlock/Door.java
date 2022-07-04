package com.aor.Models.ElementBlock;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Door extends ElementBlock{

    public Door(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "l");
    }

    @Override
    public boolean IsDestroyed() {
        return false;
    }

    @Override
    public boolean setDestroyed() {
        return false;
    }
}
