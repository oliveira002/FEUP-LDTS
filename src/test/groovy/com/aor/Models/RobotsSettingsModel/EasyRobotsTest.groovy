package com.aor.Models.RobotsSettingsModel

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class EasyRobotsTest extends Specification {
    private temp;

    def setup() {
        temp = new EasyRobots();
    }
    def "Draw"() {
        given:
        temp.setSelected();
        def graphics = Mock(TextGraphics.class)
        when:
        temp.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(20, 6), "-> EASY MODE");
    }

    def "SetSelected"() {
        when:
        temp.setSelected();
        then:
        true == temp.isSelected();

    }

    def "IsSelected"() {
        when:
        temp.setSelected();
        then:
        true == temp.isSelected();

    }

    def "SetUnselected"() {
        when:
        temp.setUnselected();
        then:
        false == temp.isSelected();
    }
}
