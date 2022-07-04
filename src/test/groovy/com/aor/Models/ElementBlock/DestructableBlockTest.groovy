package com.aor.Models.ElementBlock

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class DestructableBlockTest extends Specification {
    private b;

    def setup(){
        b = new DestructableBlock(1,1)
    }

    def "IsDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == b.IsDestroyed();
    }

    def "SetDestroyed"() {
        when:
        def destroyed = true;

        then:
        destroyed == b.setDestroyed();
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        b.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "i");
    }
}
