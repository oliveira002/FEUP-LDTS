package com.aor.Models.RobotsSettingsModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class EasyRobots implements DifficultyModel {

    boolean selected;

    @Override
    public void draw(TextGraphics graphics) {
        if(selected){
            graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20, 6), "-> EASY MODE");
        }
        else {
            graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20, 6), "EASY MODE");
        }
    }

    @Override
    public void setSelected() {
        selected = true;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setUnselected() {
        selected = false;
    }
}
