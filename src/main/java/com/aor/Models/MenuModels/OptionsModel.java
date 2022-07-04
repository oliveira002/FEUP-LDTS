package com.aor.Models.MenuModels;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class OptionsModel implements MenuModel {
    boolean selected;
    @Override
    public void draw(TextGraphics graphics) {
        if(selected) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(14, 8), "-> DIFFICULTY OPTIONS");
        }
        else {
            graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(14, 8), "DIFFICULTY OPTIONS");
        }
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected() {
        selected = true;
    }

    @Override
    public void setUnselected() {
        selected = false;
    }
}

