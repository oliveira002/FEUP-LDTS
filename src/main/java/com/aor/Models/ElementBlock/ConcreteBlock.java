package com.aor.Models.ElementBlock;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.SGR;

public class ConcreteBlock extends ElementBlock {
    public ConcreteBlock(int x, int y) {
        super(x,y);
        undestructableBlock = true;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#808080"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "j");
    }

    @Override
    public boolean IsDestroyed() {
        return IsDestroyed;
    }

    @Override
    public boolean setDestroyed() {
        return false;
    }
}