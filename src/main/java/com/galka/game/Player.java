package com.galka.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Player {

    private final String name;
    private final List<FrameScore> scoresList = new LinkedList<>();

    public Player(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public void addScore(int score) {
        final int size = scoresList.size();
        final int lastFrame = size - 1;
        if (size <= 0 || scoresList.get(lastFrame).hasNextRoll()) {
            final var frameScore = new FrameScore();
            frameScore.add(score);
            scoresList.add(frameScore);
            return;
        }
        final var frameScore = scoresList.get(lastFrame);
        frameScore.add(score);
    }

    public String getName() {
        return name;
    }

    int getTotalScore() {
        return scoresList.stream()
                .mapToInt(FrameScore::getScoreTotal)
                .sum();
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
}
