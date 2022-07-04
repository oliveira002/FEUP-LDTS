package com.aor.Models.PauseModels;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface PauseModel {
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();
}
