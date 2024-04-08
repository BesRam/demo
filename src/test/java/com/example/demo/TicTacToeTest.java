package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    
    @Test
    void testInitialBoardIsEmpty() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.isBoardEmpty(), "The board should be empty at the beginning of the game.");
    }

    @Test
    void testPlayerXGoesFirst() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer(), "Player X should start the game.");
    }

    @Test
    void testPlayersAlternateTurns() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // Spieler 'X' macht den ersten Zug
        assertEquals('O', game.getCurrentPlayer(), "After player X, it should be player O's turn.");

        game.makeMove(0, 1); // Spieler 'O' macht den nächsten Zug
        assertEquals('X', game.getCurrentPlayer(), "Players should alternate turns, so it should be player X's turn again.");
    }

    @Test
    void testPlayerCannotTakeTakenField() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // Spieler 'X' besetzt das Feld (0, 0)

        char playerBeforeInvalidMove = game.getCurrentPlayer();
        game.makeMove(0, 0); // Versuch, das bereits besetzte Feld erneut zu besetzen
        char playerAfterInvalidMove = game.getCurrentPlayer();

        assertEquals(playerBeforeInvalidMove, playerAfterInvalidMove, "The player should not change after an invalid move.");
        assertEquals('X', game.getBoardValue(0, 0), "The field value should remain unchanged after an invalid move.");
    }
}
