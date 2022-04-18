package com.example.tictactoeai;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private final String[][] board;
    private Cell computersMove;

    public final String[][] getBoard() {
        return this.board;
    }

    @NonNull
    private List<Cell> getAvailableCells() {
        List<Cell> cells = new ArrayList<>();
        int i = 0;

        for(int var3 = this.board.length; i < var3; ++i) {
            int j = 0;

            for(int var5 = this.board.length; j < var5; ++j) {
                CharSequence var6 = this.board[i][j];
                if (var6 == null || var6.length() == 0) {
                    cells.add(new Cell(i, j));
                }
            }
        }

        return cells;
    }

    public final boolean isGameOver() {
        return this.hasComputerWon() || this.hasPlayerWon() || this.getAvailableCells().isEmpty();
    }

    public final boolean hasComputerWon() {
        if ((this.board[0][0].equals(this.board[1][1])) && (this.board[0][0].equals(this.board[2][2])) && (this.board[0][0].equals("X")) || (this.board[0][2].equals(this.board[1][1])) && (this.board[0][2].equals(this.board[2][0])) && (this.board[0][2].equals("X"))) {
            return true;
        } else {
            int i = 0;

            for(int var2 = this.board.length; i < var2; ++i) {
                if ((this.board[i][0].equals(this.board[i][1])) && (this.board[i][0].equals(this.board[i][2])) && (this.board[i][0].equals("X")) || (this.board[0][i].equals(this.board[1][i])) && (this.board[0][i].equals(this.board[2][i])) && (this.board[0][i].equals("X"))) {
                    return true;
                }
            }

            return false;
        }
    }

    public final boolean hasPlayerWon() {
        if ((this.board[0][0].equals(this.board[1][1])) && (this.board[0][0].equals(this.board[2][2])) && (this.board[0][0].equals("O")) || (this.board[0][2].equals(this.board[1][1])) && (this.board[0][2].equals(this.board[2][0])) && (this.board[0][2].equals("O"))) {
            return true;
        } else {
            int i = 0;

            for(int var2 = this.board.length; i < var2; ++i) {
                if ((this.board[i][0].equals(this.board[i][1])) && (this.board[i][0].equals(this.board[i][2])) && (this.board[i][0].equals("O")) || (this.board[0][i].equals(this.board[1][i])) && (this.board[0][i].equals(this.board[2][i])) && (this.board[0][i].equals("O"))) {
                    return true;
                }
            }

            return false;
        }
    }

    public final Cell getComputersMove() {
        return this.computersMove;
    }

    public final int minimax(int depth,String player) {
        if (this.hasComputerWon()) {
            return 1;
        } else if (this.hasPlayerWon()) {
            return -1;
        } else if (this.getAvailableCells().isEmpty()) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int i = 0;

            for(int var6 = (this.getAvailableCells()).size(); i < var6; ++i) {
                Cell cell = this.getAvailableCells().get(i);
                int currentScore;
                if ((player.equals("X"))) {
                    this.placeMove(cell, "X");
                    currentScore = this.minimax(depth + 1, "O");
                    max = Math.max(currentScore, max);
                    if (currentScore >= 0 && depth == 0) {
                        this.computersMove = cell;
                    }

                    if (currentScore == 1) {
                        this.board[cell.getI()][cell.getJ()] = "";
                        break;
                    }

                    if (i == this.getAvailableCells().size() - 1 && max < 0 && depth == 0) {
                        this.computersMove = cell;
                    }
                } else if ((player.equals("O"))) {
                    this.placeMove(cell, "O");
                    currentScore = this.minimax(depth + 1, "X");
                    min = Math.min(currentScore, min);
                    if (min == -1) {
                        this.board[cell.getI()][cell.getJ()] = "";
                        break;
                    }
                }

                this.board[cell.getI()][cell.getJ()] = "";
            }

            return player.equals("X") ? max : min;
        }
    }

    public final void placeMove( Cell cell, String player) {
        this.board[cell.getI()][cell.getJ()] = player;
    }
    public Board() {
        byte var1 = 3;
        String[][] var2 = new String[var1][];

        for(int var3 = 0; var3 < var1; ++var3) {
            String[] var9 = new String[3];
            var2[var3] = var9;
        }

        this.board = var2;
    }
}
