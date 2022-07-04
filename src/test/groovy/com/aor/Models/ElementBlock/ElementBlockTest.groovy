package com.aor.Models.ElementBlock

import com.aor.Models.Positions.Position
import spock.lang.Specification

class ElementBlockTest extends Specification {

    def "GetPosition"() {
        given:
        def ConcreteBlock c = new ConcreteBlock(2,3);

        when:
        def pos = new Position(2,3);

        then:
        pos == c.getPosition();

    }

    def "SetPosition"() {
        given:
            def ConcreteBlock c = new ConcreteBlock(2,3);
            def pos = new Position(5,4);
            c.setPosition(pos);

        when:
            def posf = new Position(5,4);

        then:
        posf == c.getPosition();
    }
    def "IsBomb"() {
        given:
            def block = new Bomb(1,1);
            def block1 = new ConcreteBlock(1,1);
        expect:
            block.isBomb() == true
            block.isUndestructableBlock() == false
            block.isDestructableBlock() == false
            block1.isBomb() == false
    }

    def "IsDestructableBlock"() {
        given:
            def block = new ConcreteBlock(1,1);
        expect:
            block.isUndestructableBlock() == true
            block.isBomb() == false
            block.isDestructableBlock() == false
    }

    def "IsUndestructableBlock"() {
        given:
            def block = new DestructableBlock(1,1);
        expect:
            block.isDestructableBlock() == true
            block.isUndestructableBlock() == false
            block.isBomb() == false
    }
}
