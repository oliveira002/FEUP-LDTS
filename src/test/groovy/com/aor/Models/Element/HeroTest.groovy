package com.aor.Models.Element

import com.aor.Models.Positions.Position
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class HeroTest extends Specification {
    private hero

    def setup() {
        hero = new Hero(1, 1)
    }

    def "MoveUp"() {
        when:
        hero.moveUp()
        then:
        hero.getPosition() == new Position(1,0)
    }

    def "MoveDown"() {
        when:
        hero.moveDown()
        then:
        hero.getPosition() == new Position(1,2)
    }

    def "MoveLeft"() {
        when:
        hero.moveLeft()
        then:
        hero.getPosition() == new Position(0,1)
    }

    def "MoveRight"() {
        when:
        hero.moveRight()
        then:
        hero.getPosition() == new Position(2,1)
    }

    def "GetPosition"() {
        when:
        def pos = new Position(1,1)

        then:
        pos == hero.getPosition()
    }

    def "SetPosition"() {
        when:
        def pos = new Position(2,2)

        then:
        hero.setPosition(pos);
        pos == hero.getPosition()

    }

    def "SetAsDead"() {
        when:
        def dead = true;

        then:
        hero.setAsDead();
        dead != hero.isAlive();
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        hero.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "h");
    }
}
