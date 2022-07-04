package com.aor.Leaderboard

import com.aor.Models.MenuModels.LeaderBoard
import spock.lang.Specification

class LeadComparatorTest extends Specification {
    private ArrayList<LeaderboardObject> leaderboard = new ArrayList<>()

    def "Compare"() {
        given:
            leaderboard.add(new LeaderboardObject("Ricardo1",10))
            leaderboard.add(new LeaderboardObject("Ricardo2",5))
            leaderboard.add(new LeaderboardObject("Ricardo3",15))
        when:
            leaderboard.sort(new LeadComparator())
        then:
            leaderboard.get(0).equals(new LeaderboardObject("Ricardo2",5))
            leaderboard.get(1).equals(new LeaderboardObject("Ricardo1",10))
            leaderboard.get(2).equals(new LeaderboardObject("Ricardo3",15))
    }
}
