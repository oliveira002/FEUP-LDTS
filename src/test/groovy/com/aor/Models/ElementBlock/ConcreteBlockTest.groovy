package com.aor.Models.ElementBlock

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class ConcreteBlockTest extends Specification {
    private b;

    def setup(){
        b = new ConcreteBlock(3,3)
    }

    def "Draw"() {
        given:
            def graphics = Mock(TextGraphics.class)
        when:
            b.draw(graphics)
        then:
            1 * graphics.putString(new TerminalPosition(3, 3), "j")
    }

    def "IsDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == b.IsDestroyed();
    }

    def "SetDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == b.setDestroyed();
    }
}
