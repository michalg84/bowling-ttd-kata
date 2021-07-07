package com.galka.game;

import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Player> playerList;

    public Game(List<Player> playerList) {
        this.playerList = Collections.unmodifiableList(playerList);
    }
}
