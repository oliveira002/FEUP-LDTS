package com.aor.Models.PowerUpModel

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class IncreaseSpeedTest extends Specification {
    def speed
    def setup(){
        speed = new IncreaseSpeed()
    }
    def "GetPrice"() {
        when:
        def d = speed.getPrice()
        then:
        d == 5
    }


    def "SlowTime"() {
        expect:
        speed.slowTime() == false
    }

    def "ChangeSkin"() {
        expect:
        speed.changeSkin() == false
    }

    def "IncreaseSpeed"() {
        expect:
        speed.increaseSpeed() == true
    }

    def "Draw1"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        speed.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(20,6 ), "p (INCREASE SPEED) 5s")
    }
    def "IsSelected"() {
        expect:
        speed.isSelected() == false
    }

    def "SetSelected"() {
        when:
        speed.setSelected()
        then:
        speed.isSelected() == true
    }

    def "SetUnselected"() {
        when:
        speed.setSelected()
        speed.setUnselected()
        then:
        speed.isSelected() == false
    }


}
