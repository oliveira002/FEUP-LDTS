package com.aor.Models.EndGameModel;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface EndGameModel {
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();
}
