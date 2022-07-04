package com.aor.Models.Element;

import com.aor.Models.Positions.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface GameCharacter {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    void draw(TextGraphics graphics);
    Position getPosition();
    void setPosition(Position position);
}
