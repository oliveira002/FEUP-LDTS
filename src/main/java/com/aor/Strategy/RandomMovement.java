package com.aor.Strategy;


import com.aor.Models.Element.Robot;
import com.aor.Models.Positions.Position;
import com.aor.States.PlayingState;

import java.util.Random;

public class RandomMovement implements Strategy {
    @Override
    public void moveRobot(PlayingState game) {
        for(Robot temp : game.getRobots()) {
            Random rand = new Random();
            int num = rand.nextInt(4)+1;
            if(num == 1 && game.canMove(new Position(temp.getPosition().getX() + 1, temp.getPosition().getY()))) {
                temp.moveRight();
            }
            else if(num == 2 && game.canMove(new Position(temp.getPosition().getX() - 1, temp.getPosition().getY()))) {
                temp.moveLeft();
            }
            else if(num == 3 && game.canMove(new Position(temp.getPosition().getX(), temp.getPosition().getY() - 1))) {
                temp.moveUp();
            }
            else if(num == 4 && game.canMove(new Position(temp.getPosition().getX(), temp.getPosition().getY() + 1))) {
                temp.moveDown();
            }
        }
    }
}
