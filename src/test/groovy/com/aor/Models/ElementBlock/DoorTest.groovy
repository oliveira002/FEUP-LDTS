package com.aor.Models.ElementBlock

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class DoorTest extends Specification {
    private d;

    def setup(){
        d = new Door(1,1)
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        d.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "l");
    }

    def "IsDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == d.IsDestroyed();
    }

    def "SetDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == d.IsDestroyed();
    }
}
