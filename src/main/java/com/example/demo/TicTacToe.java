package com.example.demo;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private final char EMPTY_FIELD = ' ';
    private final char PLAYER_X = 'X';
    private final char PLAYER_O = 'O';

    public TicTacToe() {
        this.board = new char[3][3];
        initializeBoard();
        this.currentPlayer = PLAYER_X; // X starts the game
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = EMPTY_FIELD;
            }
        }
    }

    public boolean isBoardEmpty() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell != EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == EMPTY_FIELD) {
            board[row][col] = currentPlayer;
            togglePlayer();
        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public char getBoardValue(int row, int col) {
        return board[row][col];
    }

    public boolean checkWin() {
        return (checkLinesForWin() || checkDiagonalsForWin());
    }

    private boolean checkLine(char a, char b, char c) {
        return (a != EMPTY_FIELD) && (a == b) && (b == c);
    }

    private boolean checkLinesForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2]) || // Rows
                checkLine(board[0][i], board[1][i], board[2][i])) { // Columns
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return checkLine(board[0][0], board[1][1], board[2][2]) ||
               checkLine(board[0][2], board[1][1], board[2][0]);
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getWinner() {
        if (checkLinesForWin() || checkDiagonalsForWin()) {
            return (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X; // Return the last player
        }
        return EMPTY_FIELD;
    }
}