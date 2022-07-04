package com.aor.Models.Element;

import com.aor.Models.Positions.Position;

public abstract class Element implements GameCharacter {

    protected Position position;
    boolean robot, hero, alive;

    public Element(int x, int y){
        position = new Position(x,y);
        position.setX(x);
        position.setY(y);
        alive = true;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setAsDead(){
        alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
}
