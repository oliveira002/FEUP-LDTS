package com.aor.Models.PowerUpModel;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface PowerUpModel {
    int getPrice();
    void startTimer();
    boolean isExpired();
    boolean slowTime();
    boolean changeSkin();
    boolean increaseSpeed();
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();
    void setRed();
}
