package com.aor.Models.PauseModels

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class MenuPauseTest extends Specification {
    private temp;

    def setup() {
        temp = new MenuPause();
    }
    def "Draw"() {
        given:
        temp.setSelected();
        def graphics = Mock(TextGraphics.class)
        when:
        temp.draw(graphics)
        then:
        1 * graphics.putString(new TerminalPosition(20, 8), "-> MENU");
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
