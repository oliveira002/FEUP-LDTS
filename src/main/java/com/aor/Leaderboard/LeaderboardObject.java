package com.aor.Leaderboard;

public class LeaderboardObject {
    private String playerName;
    private Integer time;

    public LeaderboardObject(String p, Integer t){
        this.playerName = p;
        this.time = t;
    }

    public String getName() {
        return playerName;
    }

    public Integer getTime() {
        return time;
    }
    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) || (this.playerName == ((LeaderboardObject) o).playerName);
    }
}
