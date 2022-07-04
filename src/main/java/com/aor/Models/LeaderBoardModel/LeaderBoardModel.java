package com.aor.Models.LeaderBoardModel;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface LeaderBoardModel {
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();
}
