package com.galka.creator;

import com.galka.exceptions.NoPlayersException;
import com.galka.exceptions.PlayerExistsExcption;
import com.galka.exceptions.PlayerNotExistsException;
import com.galka.game.Game;
import com.galka.game.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameCreator {

    private List<Player> playerList = new ArrayList<>();

    public void add(Player player) {
        if (playerList.contains(player)) {
            throw new PlayerExistsExcption("Player already exists");
        }
        playerList.add(player);
    }

    public Game start() {
        if (playerList.isEmpty()) {
            throw new NoPlayersException("Please first add some players");
        }
        playerList = Collections.unmodifiableList(playerList);
        return new Game(playerList);
    }

    public void remove(Player player) {
        final boolean removed = playerList.remove(player);
        if (!removed) {
            throw new PlayerNotExistsException("No such player");
        }
    }
}
