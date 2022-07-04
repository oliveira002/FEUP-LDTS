package com.aor.Models.PowerUpModel

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class SlowTimeTest extends Specification {
    def slow
    def setup(){
        slow = new SlowTime()
    }
    def "GetPrice"() {
        when:
        def d = slow.getPrice()
        then:
        d == 5
    }


    def "SlowTime"() {
        expect:
        slow.slowTime() == true
    }

    def "ChangeSkin"() {
        expect:
        slow.changeSkin() == false
    }

    def "IncreaseSpeed"() {
        expect:
        slow.increaseSpeed() == false
    }

    def "Draw1"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        slow.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(20,8 ), "q (SLOW TIME) 5s")
    }
    def "IsSelected"() {
        expect:
        slow.isSelected() == false
    }

    def "SetSelected"() {
        when:
        slow.setSelected()
        then:
        slow.isSelected() == true
    }

    def "SetUnselected"() {
        when:
        slow.setSelected()
        slow.setUnselected()
        then:
        slow.isSelected() == false
    }

}