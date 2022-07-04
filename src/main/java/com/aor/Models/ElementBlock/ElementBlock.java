package com.aor.Models.ElementBlock;

import com.aor.Models.Positions.Position;

public abstract class ElementBlock implements GameBlock {
    protected Position position;
    boolean bomb, destructableBlock, undestructableBlock, IsDestroyed;

    public ElementBlock(int x, int y){
        IsDestroyed = false;
        position = new Position(x,y);
        position.setX(x);
        position.setY(y);
    }
    public ElementBlock(Position position){
        IsDestroyed = false;
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isBomb(){
        return bomb;
    }
    public boolean isDestructableBlock(){
        return destructableBlock;
    }
    public boolean isUndestructableBlock(){
        return undestructableBlock;
    }
}