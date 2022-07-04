package com.aor.Models.Positions

import spock.lang.Specification

class PositionTest extends Specification {
    private pos,pos2,pos3;

    def setup() {
        pos = new Position(2,2)
        pos2 = new Position(2,2)
        pos3 = new Position(5,1)
    }
    def "GetX"() {
        when:
        int x = 2;
        then:
        pos.getX() == 2;
    }

    def "SetX"() {
        when:
        int x = 5;
        pos.setX(x);
        then:
        pos.getX() == 5;
    }

    def "GetY"() {
        when:
        int y = 2;
        then:
        pos.getY() == 2;
    }

    def "SetY"() {
        when:
        int y = 5;
        pos.setY(y);
        then:
        pos.getY() == 5;
    }

    def "Equals"() {
        when:
        def equal = true;

        then:
        pos.equals(pos2) == equal;
        pos.equals(pos3) != equal;
    }
}
