package com.aor.Strategy;


import com.aor.Models.Element.Robot;
import com.aor.Models.Positions.Position;
import com.aor.States.PlayingState;

public class FollowHeroMovement implements Strategy {
    @Override
    public void moveRobot(PlayingState game) {
        for(Robot temp : game.getRobots()) {
            if (game.getHero().getPosition().getX() > temp.getPosition().getX() && game.canMove(new Position(temp.getPosition().getX() + 1, temp.getPosition().getY()))) {
                temp.moveRight();
            } if (game.getHero().getPosition().getX() < temp.getPosition().getX() && game.canMove(new Position(temp.getPosition().getX() - 1, temp.getPosition().getY()))) {
                temp.moveLeft();
            } if (game.getHero().getPosition().getY() > temp.getPosition().getY() && game.canMove(new Position(temp.getPosition().getX(), temp.getPosition().getY() + 1))) {
                temp.moveDown();
            } if (game.getHero().getPosition().getY() < temp.getPosition().getY() && game.canMove(new Position(temp.getPosition().getX(), temp.getPosition().getY() - 1))) {
                temp.moveUp();
            }
        }
    }
}
