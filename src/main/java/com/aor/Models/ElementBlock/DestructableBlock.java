package com.aor.Models.ElementBlock;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DestructableBlock extends ElementBlock{

    public DestructableBlock(int x, int y) {
        super(x, y);
        IsDestroyed = false;
        destructableBlock = true;
    }
    public boolean IsDestroyed(){
        return IsDestroyed;
    }
    public boolean setDestroyed(){
        IsDestroyed = true;
        return true;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#808080"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "i");
    }
}