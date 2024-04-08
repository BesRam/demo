package com.example.demo;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private final char EMPTY_FIELD = ' ';
    private final char PLAYER_X = 'X';
    private final char PLAYER_O = 'O';

    public TicTacToe() {
        this.board = new char[3][3];
        // Initialisiere das Brett mit leeren Feldern
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = EMPTY_FIELD;
            }
        }
        this.currentPlayer = PLAYER_X; // X beginnt immer
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

    public void makeMove(int row, int col) {
        if (board[row][col] == EMPTY_FIELD) {
            board[row][col] = currentPlayer;
            togglePlayer(); // Wechselt den Spieler nach jedem gültigen Zug
        }
    }

    private void togglePlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }

    public char getBoardValue(int row, int col) {
        return board[row][col];
    }

}
