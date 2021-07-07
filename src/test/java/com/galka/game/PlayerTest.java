package com.galka.game;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void shouldReturnNameForCreatedPlayer() {
        final Player player = new Player("Matt");
        assertThat(player.getName()).isEqualTo("Matt");
    }

    @Test
    void shouldConsiderTwoPlayersWithSameNameAsEqual() {
        final Player player1 = new Player("Matt");
        final Player player2 = new Player("Matt");
        assertThat(player1).isEqualTo(player2);
    }

    @Test
    void shouldConsiderTwoPlayersWithDifferentNamesAsNotEqual() {
        final Player player1 = new Player("Matt");
        final Player player2 = new Player("Cindy");
        assertThat(player1).isNotEqualTo(player2);
    }
}