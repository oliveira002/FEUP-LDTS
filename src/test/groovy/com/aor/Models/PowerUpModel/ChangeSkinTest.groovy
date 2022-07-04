package com.aor.Models.PowerUpModel

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class ChangeSkinTest extends Specification {
    def skin
    def setup(){
        skin = new ChangeSkin()
    }
    def "GetPrice"() {
        when:
            def d = skin.getPrice()
        then:
            d == 5
    }


    def "SlowTime"() {
        expect:
            skin.slowTime() == false
    }

    def "ChangeSkin"() {
        expect:
        skin.changeSkin() == true
    }

    def "IncreaseSpeed"() {
        expect:
        skin.increaseSpeed() == false
    }

    def "Draw1"() {
        given:
            def graphics = Mock(TextGraphics.class)
        when:
            skin.draw(graphics)
        then:
            1 * graphics.putString(new TerminalPosition(20,4 ), "r (CHANGE SKIN) 5s")
    }
    def "IsSelected"() {
        expect:
            skin.isSelected() == false
    }

    def "SetSelected"() {
        when:
            skin.setSelected()
        then:
            skin.isSelected() == true
    }

    def "SetUnselected"() {
        when:
            skin.setSelected()
            skin.setUnselected()
        then:
            skin.isSelected() == false
    }

}
