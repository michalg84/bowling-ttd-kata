package com.galka.game;

import com.galka.exceptions.NoPlayersException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    private final List<Player> playerList;
    private int turnCounter = 0;
    private int frameCounter = 0;

    public Game(List<Player> list) {
        final List<Player> players = Objects.requireNonNull(list);
        if (players.isEmpty()) {
            throw new NoPlayersException("Cannot create a game without players");
        }
        this.playerList = Collections.unmodifiableList(players);
    }

    Player next() {
        final var player = currentPlayer();
        turnCounter++;
        frameCounter = 0;
        return player;
    }

    public void roll(int score, Player player) {
        player.addScore(score);
        if (++frameCounter >= 2) {
            next();

        } else if (score == 10) {
            next();
        }
    }

    Player currentPlayer() {
        final int index = turnCounter % playerList.size();
        return playerList.get(index);
    }
}
