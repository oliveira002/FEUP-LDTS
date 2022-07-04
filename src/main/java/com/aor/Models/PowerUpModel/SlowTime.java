package com.aor.Models.PowerUpModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SlowTime implements PowerUpModel {
    boolean selected,red;
    long timestarted;
    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public void startTimer() {
        timestarted = System.currentTimeMillis();
    }

    @Override
    public boolean isExpired() {
        return (System.currentTimeMillis()-timestarted>10000);
    }

    @Override
    public boolean slowTime() {
        return true;
    }

    @Override
    public boolean changeSkin() {
        return false;
    }

    @Override
    public boolean increaseSpeed() {
        return false;
    }

    @Override
    public void draw(TextGraphics graphics) {
        if(!selected && !red) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20,8 ), "q (SLOW TIME) 5s");
        }
        else if(selected && red) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20,8 ), "-> q (SLOW TIME) 5s");
        }
        else if(red) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20,8 ), "q (SLOW TIME) 5s");
        }
        else if(selected) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(20,8 ), "-> q (SLOW TIME) 5s");
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

    @Override
    public void setRed() {
        this.red = true;
    }
}
