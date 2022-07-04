package com.aor.Models.ElementBlock

import com.aor.Models.Element.Robot
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class CoinTest extends Specification {
    private Coin coin;

    def setup(){
        coin = new Coin(1,1)
    }

    def "Draw"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        coin.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(1, 1), "s");
    }

    def "IsDestroyed"() {
        expect:
        false == coin.IsDestroyed();
    }

    def "SetDestroyed"() {
        when:
        coin.setDestroyed();
        then:
        true == coin.IsDestroyed();
    }
}
