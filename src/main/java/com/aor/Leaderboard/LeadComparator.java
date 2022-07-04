package com.aor.Leaderboard;

import java.util.Comparator;

class LeadComparator implements Comparator<LeaderboardObject> {

    public int compare(LeaderboardObject s1, LeaderboardObject s2)
    {
        if (s1.getName() == s2.getName() && s1.getTime() == s2.getTime())
            return 0;
        else if (s1.getTime() > s2.getTime())
            return 1;
        else if (s1.getTime() == s2.getTime())
            return 1;
        else
            return -1;
    }
}