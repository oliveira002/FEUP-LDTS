package com.aor.Leaderboard

import spock.lang.Specification

class LeaderboardFactoryTest extends Specification {
    private leaderboard

    def setup(){
        leaderboard = new LeaderboardFactory("src/main/resources/leaderboard/leaderboard.txt")
    }
    def "GetLeaderboardsList"() {
        when:
            def l = leaderboard.getLeaderboardsList()
        then:
            l.get(0).getName() == "DIOGO"
            l.get(0).getTime() == 10
            l.get(1).getName() == "USER"
            l.get(1).getTime() == 46
            l.get(2).getName() == "RICARDO"
            l.get(2).getTime() == 50

    }
}
