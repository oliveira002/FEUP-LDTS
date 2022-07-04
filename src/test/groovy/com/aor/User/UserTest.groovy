package com.aor.User

import com.aor.Models.PowerUpModel.IncreaseSpeed
import com.aor.Models.PowerUpModel.SlowTime
import com.aor.States.PlayingState
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

import java.security.SecurityPermission

class UserTest extends Specification {
    def user
    def setup(){
        user = new User("DIOGO")
    }
    def "GetName"() {
        expect:
            user.getName() == "DIOGO"
    }
    def "SetName"() {
        when:
            user.setName("RICARDO")
        then:
            user.getName() == "RICARDO"
    }
    def "GetTime"() {
        expect:
            user.getTime() ==0
    }
    def "AddTime"() {
        when:
            user.addTime(2)
        then:
            user.getTime() == 2
    }

    def "SetTime"() {
        when:
        user.setTime(3)
        then:
        user.getTime() == 3
    }



    def "GetBalence"() {
        expect:
            user.getBalence() == 10
    }


    def "AddToBalence"() {
        when:
        user.addToBalence(3)
        then:
        user.getBalence() == 13

    }

    def "TakeFromBalence"() {
        when:
        user.takeFromBalence(3)
        then:
        user.getBalence() == 7
    }

    def "GetPowerUpList"() {
        expect:
            user.getPowerUpList().size() == 0
    }

    def "DeletePowerUp"() {
        given:
            def power1 = Mock(SlowTime.class)
            def power2 = Mock(IncreaseSpeed.class)
        when:
            user.addPowerUp(power1)
            user.addPowerUp(power2)
            user.deletePowerUp(power1)
        then:
            user.getPowerUpList().get(0) == power2
    }

    def "AddPowerUp"() {
        given:
            def power = Mock(SlowTime.class)
        when:
            user.addPowerUp(power)
        then:
            user.getPowerUpList().size() == 1

    }
    def "NotifyObserverBegin"() {
        given:
            def observer = Mock(PlayingState.class)
            def power = Mock(SlowTime.class)
        when:
            user.addPowerUp(power)
            user.ChangeObserver(observer)
            user.notifyObserverBegin()
        then:
            1 * observer.notifyObserverBeginPowerUp(power)
    }
    def "NotifyObserverEnd"(){
        given:
            def observer = Mock(PlayingState.class)
            def power = Mock(SlowTime.class)
        when:
            user.addPowerUp(power)
            user.ChangeObserver(observer)
            user.notifyObserverEnd()
        then:
            1 * observer.notifyObserverEndPowerUp(power)

    }
}
