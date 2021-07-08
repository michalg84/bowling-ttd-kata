package com.galka.game;

import java.util.Objects;

public class Player {

    private final String name;
    private int score = 0;
    private int rollsCount = 0;

    public Player(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public void addScore(int score) {
        this.score += score;
        this.rollsCount++;
    }

    public String getName() {
        return name;
    }

    int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        var player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

//    public FrameScore getLastScore() {
//
//    }
}
