package com.aor.Models.PowerUpModel

import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class ResumeGamePowerupTest extends Specification {
    def resume
    def setup(){
        resume = new ResumeGamePowerup()
    }
    def "GetPrice"() {
        when:
        def d = resume.getPrice()
        then:
        d == 0
    }


    def "SlowTime"() {
        expect:
        resume.slowTime() == false
    }

    def "ChangeSkin"() {
        expect:
        resume.changeSkin() == false
    }

    def "IncreaseSpeed"() {
        expect:
        resume.increaseSpeed() == false
    }

    def "Draw1"() {
        given:
        def graphics = Mock(TextGraphics.class)
        when:
        resume.draw(graphics)
        then:
        1 *graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
        1 *graphics.enableModifiers(SGR.BOLD);
        1 *graphics.putString(new TerminalPosition(20, 10), "RESUME");
    }
    def "IsSelected"() {
        expect:
        resume.isSelected() == false
    }

    def "SetSelected"() {
        when:
        resume.setSelected()
        then:
        resume.isSelected() == true
    }

    def "SetUnselected"() {
        when:
        resume.setSelected()
        resume.setUnselected()
        then:
        resume.isSelected() == false
    }


}
