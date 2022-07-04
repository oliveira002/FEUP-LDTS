package com.aor.Models.ElementBlock

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class ExplosionTest extends Specification {
    private Explosion exp;

    def setup(){
        exp = new Explosion(1,1)
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        exp.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "m");
    }

    def "IsDestroyed"() {
        expect:
        false == exp.IsDestroyed();
    }

    def "SetDestroyed"() {
        expect:
        false == exp.setDestroyed()
    }

    def "SetVanished"() {
        when:
        exp.setVanished()
        then:
        true == exp.isVanished();
    }

    def "IsVanished"() {
        expect:
        false == exp.isVanished();
    }
}
