package com.aor.Models.Element

import com.aor.Models.Positions.Position
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class RobotTest extends Specification {
    private robot;

    def setup(){
        robot = new Robot(1,1)
    }
    def "MoveUp"() {
        when:
            Thread.sleep(251)
            robot.moveUp()
        then:
            robot.getPosition() == new Position(1,0);
    }

    def "MoveDown"() {
        when:
            Thread.sleep(251)
            robot.moveDown();
        then:
            robot.getPosition() == new Position(1,2);
    }

    def "MoveLeft"() {
        when:
            Thread.sleep(251)
            robot.moveLeft();
        then:
            robot.getPosition() == new Position(0,1);
    }

    def "MoveRight"() {
        when:
            Thread.sleep(251)
            robot.moveRight();
        then:
            robot.getPosition() == new Position(2,1);
    }

    def "Draw"() {
        given:
            def graphics = Mock(TextGraphics.class)
        when:
            robot.draw(graphics)
        then:
            1 * graphics.putString(new TerminalPosition(1, 1), "g");
    }
}
