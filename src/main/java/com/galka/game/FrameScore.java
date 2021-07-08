package com.galka.game;

class FrameScore {


    private final int firstScore;
    private int secondScore;
    private TYPE type;

    private FrameScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public static FrameScore valueOf(int score) {
        return new FrameScore(score);
    }

    public void addSecondScore(int score) {
        this.secondScore = score;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public boolean hasNextRoll() {
        return type.nextRoll;
    }

    private enum TYPE {
        SPARE(false), STRIKE(false), NEXT_ROLL(true), OPEN_FRAME(false);
        private final boolean nextRoll;

        TYPE(boolean nextRoll) {
            this.nextRoll = nextRoll;
        }

    }
}
