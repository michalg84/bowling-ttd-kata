package com.galka.game;

import java.util.Optional;

class FrameScore {


    private Integer firstScore;
    private Integer secondScore;

    FrameScore() {
    }

    void add(int score) {
        if (firstScore == null) {
            firstScore = score;
        } else {
            secondScore = score;
        }
    }


    public Optional<Integer> getFirstScore() {
        return Optional.ofNullable(firstScore);
    }

    public Optional<Integer> getSecondScore() {
        return Optional.ofNullable(secondScore);
    }

    int getScoreTotal() {
        return getFirstScore().orElse(0)
                + getSecondScore().orElse(0);
    }

    boolean hasNextRoll() {
        return firstScore == null || secondScore == null && getScoreTotal() < 10;
    }
}
