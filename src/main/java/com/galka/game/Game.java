package com.galka.game;

import com.galka.exceptions.NoPlayersException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    private static final int FRAME_ROLLS_NUMBER = 2;
    private final List<Player> playerList;
    private int turnCounter = 0;
    private int frameCounter = 0;
    private static final int STRIKE = 10;

    public Game(List<Player> list) {
        final List<Player> players = Objects.requireNonNull(list);
        if (players.isEmpty()) {
            throw new NoPlayersException("Cannot create a game without players");
        }
        this.playerList = Collections.unmodifiableList(players);
    }

    public void roll(int score, Player player) {
        player.addScore(score);
        if (++frameCounter >= FRAME_ROLLS_NUMBER) {
            next();

        } else {
            if (score == STRIKE) {
                next();
            }
        }
    }

    Player next() {
        final var player = current();
        turnCounter++;
        frameCounter = 0;
        return player;
    }

    private Player current() {
        final int index = turnCounter % playerList.size();
        return playerList.get(index);
    }
}
