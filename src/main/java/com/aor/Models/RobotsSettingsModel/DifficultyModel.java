package com.aor.Models.RobotsSettingsModel;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface DifficultyModel {
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();
}
