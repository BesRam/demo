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

    @Test
    void testWinByRow() {
        TicTacToe game = new TicTacToe();
        
        // Spieler 'X' besetzt eine komplette Reihe
        game.makeMove(0, 0); // X's Zug
        game.makeMove(1, 0); // O's Zug
        game.makeMove(0, 1); // X's Zug
        game.makeMove(1, 1); // O's Zug
        game.makeMove(0, 2); // X's Zug, vervollständigt eine Reihe

        assertTrue(game.checkWin(), "There should be a win by row.");
    }

    @Test
    void testWinByColumn() {
        TicTacToe game = new TicTacToe();
        
        // Spieler 'X' besetzt eine komplette Spalte
        game.makeMove(0, 0); // X's Zug
        game.makeMove(0, 1); // O's Zug
        game.makeMove(1, 0); // X's Zug
        game.makeMove(1, 1); // O's Zug
        game.makeMove(2, 0); // X's Zug, vervollständigt eine Spalte

        assertTrue(game.checkWin(), "There should be a win by column.");
    }

    @Test
    void testWinByDiagonal() {
        TicTacToe game = new TicTacToe();
        
        // Spieler 'X' besetzt eine Diagonale
        game.makeMove(0, 0); // X's Zug
        game.makeMove(0, 1); // O's Zug
        game.makeMove(1, 1); // X's Zug
        game.makeMove(0, 2); // O's Zug
        game.makeMove(2, 2); // X's Zug, vervollständigt eine Diagonale

        assertTrue(game.checkWin(), "There should be a win by diagonal.");
    }

    @Test
    void testGameIsOverWhenAllFieldsAreTaken() {
        TicTacToe game = new TicTacToe();
        
        // Fülle das Brett, ohne einen Gewinner zu erzeugen
        game.makeMove(0, 0); // X's Zug
        game.makeMove(0, 1); // O's Zug
        game.makeMove(0, 2); // X's Zug
        game.makeMove(1, 1); // O's Zug
        game.makeMove(1, 0); // X's Zug
        game.makeMove(1, 2); // O's Zug
        game.makeMove(2, 1); // X's Zug
        game.makeMove(2, 0); // O's Zug
        game.makeMove(2, 2); // X's Zug, letztes Feld wird besetzt

        assertTrue(game.isBoardFull() && !game.checkWin(), "The game should be over with no winner when all fields are taken.");
    }

    @Test
    void testGameDeclaresCorrectWinner() {
        TicTacToe game = new TicTacToe();
        
        // Spieler 'X' gewinnt
        game.makeMove(0, 0); // X's Zug
        game.makeMove(0, 1); // O's Zug
        game.makeMove(1, 1); // X's Zug
        game.makeMove(0, 2); // O's Zug
        game.makeMove(2, 2); // X's Zug, vervollständigt eine Diagonale und gewinnt

        assertTrue(game.checkWin() && game.getWinner() == 'X', "Player X should be declared the winner.");
    }

    @Test
    void testGameDeclaresDrawIfNoWinner() {
        TicTacToe game = new TicTacToe();
        
        // Fülle das Brett, ohne einen Gewinner zu erzeugen, um ein Unentschieden zu erreichen
        game.makeMove(0, 0); // X's Zug
        game.makeMove(0, 1); // O's Zug
        game.makeMove(0, 2); // X's Zug
        game.makeMove(1, 0); // O's Zug
        game.makeMove(1, 1); // X's Zug
        game.makeMove(1, 2); // O's Zug
        game.makeMove(2, 1); // X's Zug
        game.makeMove(2, 0); // O's Zug
        game.makeMove(2, 2); // X's Zug, letztes Feld wird besetzt, kein Gewinner

        assertTrue(game.isBoardFull() && game.getWinner() == ' ', "The game should be declared a draw if there is no winner and the board is full.");
    }
}
