package com.aor.Models.Element

import com.aor.Models.Positions.Position
import spock.lang.Specification

class ElementTest extends Specification {
    private h

    def setup(){
        h = new Hero(2,3)
    }

    def "GetPosition"() {
        when:
            def pos = new Position(2,3)

        then:
            pos == h.getPosition()

    }

    def "SetPosition"() {
        given:
            def pos = new Position(5,4)
            h.setPosition(pos)

        when:
            def posf = new Position(5,4)

        then:
            posf == h.getPosition()
    }

    def "moveUp"() {
        given:
            h.moveUp()
        when:
            def posf = new Position(2,2)

        then:
        posf == h.getPosition()
    }

    def "moveDown"() {
        given:
            h.moveDown()
        when:
            def posf = new Position(2,4)

        then:
            posf == h.getPosition()
    }

    def "moveLeft"() {
        given:
            h.moveLeft()
        when:
            def posf = new Position(1,3)

        then:
            posf == h.getPosition()
    }

    def "moveRight"() {
        given:
            h.moveRight()
        when:
            def posf = new Position(3,3)

        then:
            posf == h.getPosition()
    }
    def "isAlive"() {
        expect:
            h.isAlive() == true
    }
    def "setAsDeadHero"() {
        when:
            h.setAsDead()
        then:
            h.isAlive() == false
    }
}
