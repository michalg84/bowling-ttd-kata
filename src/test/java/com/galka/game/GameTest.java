package com.galka.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.galka.exceptions.NoPlayersException;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Player player1 = new Player("Adam");
    private Player player2 = new Player("Tom");
    private Game game = new Game(List.of(player1, player2));

    @Test
    void shouldNotAllowToCreateAGameWithNullListOfPlayers() {
        assertThrows(NullPointerException.class,
                () -> new Game(null));
    }

    @Test
    void shouldNotAllowToCreateGameWithEmptyListOfpLayers() {
        final List<Player> emptyList = Collections.emptyList();
        assertThrows(NoPlayersException.class,
                () -> new Game(emptyList),
                "Cannot create a game without players");
    }

    @Test
    void shouldReturnFirstPlayerWhenNextPlayerIsRequestedFirstTime() {
        assertThat(game.next()).isEqualTo(player1);
    }

    @Test
    void shouldReturnSecondPlayerWhenNextPlayerIsRequestedSecondTime() {
        assertThat(game.next()).isEqualTo(player1);
        assertThat(game.next()).isEqualTo(player2);
    }

    @Test
    void shouldReturnFirstPlayerWhenNextPlayerIsRequestedThirdTimeInTwoPlayerGame() {
        assertThat(game.next()).isEqualTo(player1);
        assertThat(game.next()).isEqualTo(player2);
        assertThat(game.next()).isEqualTo(player1);
    }

    @Test
    void shouldReturnSamePlayerWhenNextPlayerIsRequestedInOnePlayerGame() {
        final Game game = new Game(List.of(player1));
        assertThat(game.next()).isEqualTo(player1);
        assertThat(game.next()).isEqualTo(player1);
        assertThat(game.next()).isEqualTo(player1);
    }

    @Test
    void shouldAddPlayerScoreAfterPlayersRolls() {
        game.roll(7, player1);
        game.roll(2, player1);
        assertThat(player1.getScore()).isEqualTo(9);
    }


    @Test
    void shouldChangePlayerAfterTwoNonSpecialRolls() {
        game.roll(3, player1);
        game.roll(4, player1);
        assertThat(game.currentPlayer()).isEqualTo(player2);
    }


    @Test
    void shouldChangePlayerAfterFourNonSpecialRolls() {
        game.roll(3, player1);
        game.roll(4, player1);
        game.roll(4, player2);
        game.roll(4, player2);
        assertThat(game.currentPlayer()).isEqualTo(player1);
    }

    @Test
    void shouldNotChangePlayerAfterOneNonSpecialRolls() {
        game.roll(3, player1);
        assertThat(game.currentPlayer()).isEqualTo(player1);
    }

    @Test
    void shouldNotChangePlayerAfterThreeNonSpecialRolls() {
        game.roll(3, player1);
        game.roll(3, player1);
        game.roll(3, player2);
        assertThat(game.currentPlayer()).isEqualTo(player2);
    }

    @Test
    void shouldChangePlayerAfterStrike() {
        game.roll(10, player1);
        assertThat(game.currentPlayer()).isEqualTo(player2);
    }

//    @Test
//    void shouldReturnScoreAfterRoll() {
//        game.roll(5, player1);
//        player1.getLastScore()
//        assertThat(score).isEqualTo(FrameScore.valueOf(5));
//
//    }

}
