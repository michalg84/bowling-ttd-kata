package com.galka.creator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.galka.exceptions.NoPlayersException;
import com.galka.exceptions.PlayerExistsExcption;
import com.galka.exceptions.PlayerNotExistsException;
import com.galka.game.Game;
import com.galka.game.Player;
import org.junit.jupiter.api.Test;

class GameCreatorTest {


    private final GameCreator gameCreator = new GameCreator();
    private final Player player = new Player("John");


    @Test
    void shouldNotAllowToAddPlayer_afterGameStarts() {
        gameCreator.add(player);
        gameCreator.start();
        final Player newPlayer = new Player("Adam");
        assertThrows(UnsupportedOperationException.class, () -> gameCreator.add(newPlayer));
    }

    @Test
    void shouldNotAllowToAddSamePlayerTwice() {
        gameCreator.add(player);
        assertThrows(PlayerExistsExcption.class, () -> gameCreator.add(player), "Player already exists");
    }

    @Test
    void shouldAllowToRemoveExistingPlayer() {
        gameCreator.add(player);
        assertDoesNotThrow(() -> gameCreator.remove(player), "Player already exists");
    }

    @Test
    void shouldNotAllowToRemoveNotExistingPlayer() {
        gameCreator.add(player);
        final Player newPlayer = new Player("Adam");
        assertThrows(PlayerNotExistsException.class,() -> gameCreator.remove(newPlayer), "No such player");
    }

    @Test
    void shouldNotAllowToStartGameWithoutPlayers() {
        assertThrows(NoPlayersException.class, gameCreator::start, "Please first add some players");
    }

    @Test
    void shouldReturnAGameWhenStartedWithPlayers() {
        gameCreator.add(player);
        assertThat(gameCreator.start()).isOfAnyClassIn(Game.class);
    }


}