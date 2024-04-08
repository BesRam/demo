package com.example.demo;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private final char EMPTY_FIELD = ' ';

    public TicTacToe() {
        this.board = new char[3][3];
        // Initialisiere das Brett mit leeren Feldern
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = EMPTY_FIELD;
            }
        }
        this.currentPlayer = 'X'; // X beginnt immer
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] != EMPTY_FIELD) {
                    return false; // Ein Feld ist nicht leer
                }
            }
        }
        return true; // Alle Felder sind leer
    }

    public char getCurrentPlayer() {
        return this.currentPlayer;
    }
}
