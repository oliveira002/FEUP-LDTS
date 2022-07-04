package com.aor.Models.MenuModels;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface MenuModel {
    void draw(TextGraphics graphics);
    void setSelected();
    boolean isSelected();
    void setUnselected();

}
