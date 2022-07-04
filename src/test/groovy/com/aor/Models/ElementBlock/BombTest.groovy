package com.aor.Models.ElementBlock


import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class BombTest extends Specification {
    private bomb;
    private start

    def setup(){
        bomb = new Bomb(1,1)
        start = System.currentTimeMillis();
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        bomb.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "f");
    }

    def "IsDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == bomb.IsDestroyed();
    }

    def "SetDestroyed"() {
        when:
        def destroyed = false;

        then:
        destroyed == bomb.setDestroyed();
    }

    def "GetTime"() {
        when:
            def l = bomb.getTime()
            def timenow = System.currentTimeMillis()
        then:
            l == timenow - start

    }

    def "SetExploded"() {
        when:
        def exploded = true;

        then:
        bomb.setExploded();
        exploded == bomb.isExploded();
    }

    def "IsExploded"() {
        when:
        def exploded = false;

        then:
        exploded == bomb.isExploded();
    }
}
