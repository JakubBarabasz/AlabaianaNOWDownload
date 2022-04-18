package com.example.tictactoeai;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public final class MainActivity extends AppCompatActivity {


        private final ImageView[][] boardCells;
        private final Board board;
        public final Board getBoard() {
                return this.board;
        }
        protected void onCreate(Bundle  savedInstanceState) {
                super.onCreate(savedInstanceState);
                this.loadBoard();

        }

        private void mapBoardToUi() {
                int i = 0;

                for(int var2 = this.board.getBoard().length; i < var2; ++i) {
                        int j = 0;

                        for(int var4 = this.board.getBoard().length; j < var4; ++j) {
                                String var10000 = this.board.getBoard()[i][j];
                                ImageView var6;
                                if (var10000 != null) {
                                        switch(var10000.hashCode()) {
                                                case 79:
                                                        if (var10000.equals("O")) {
                                                                var6 = this.boardCells[i][j];
                                                                if (var6 != null) {
                                                                        var6.setImageResource(R.drawable.circle);
                                                                }

                                                                var6 = this.boardCells[i][j];
                                                                if (var6 != null) {
                                                                        var6.setEnabled(false);
                                                                }
                                                                continue;
                                                        }
                                                        break;
                                                case 88:
                                                        if (var10000.equals("X")) {
                                                                var6 = this.boardCells[i][j];
                                                                if (var6 != null) {
                                                                        var6.setImageResource(R.drawable.cross);
                                                                }

                                                                var6 = this.boardCells[i][j];
                                                                if (var6 != null) {
                                                                        var6.setEnabled(false);
                                                                }
                                                                continue;
                                                        }
                                        }
                                }

                                var6 = this.boardCells[i][j];
                                if (var6 != null) {
                                        var6.setImageResource(0);
                                }

                                var6 = this.boardCells[i][j];
                                if (var6 != null) {
                                        var6.setEnabled(true);
                                }
                        }
                }

        }

        private void loadBoard() {
                int i = 0;

                for(int var2 = this.boardCells.length; i < var2; ++i) {
                        int j = 0;

                        for(int var4 = this.boardCells.length; j < var4; ++j) {
                                this.boardCells[i][j] = new ImageView(this);
                                ImageView allCells = this.boardCells[i][j];
                                if (allCells != null) {
                                        LayoutParams cell = new LayoutParams();
                                        cell.rowSpec = GridLayout.spec(i);
                                        cell.columnSpec = GridLayout.spec(j);
                                        cell.width = 250;
                                        cell.height = 250;
                                        cell.bottomMargin = 5;
                                        cell.topMargin = 5;
                                        cell.leftMargin = 5;
                                        cell.rightMargin = 5;

                                }

                                allCells = this.boardCells[i][j];
                                if (allCells != null) {
                                        allCells.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                                }

                                allCells = this.boardCells[i][j];
                                if (allCells != null) {
                                        allCells.setOnClickListener(new CellClickListener(i, j));
                                }

                                ((GridLayout)this.findViewById(R.id.layout_board)).addView(this.boardCells[i][j]);
                        }
                }

        }

        public MainActivity() {
                byte row = 3;
                ImageView[][] var2 = new ImageView[row][];

                for(int zero = 0; zero < row; ++zero) {
                        ImageView[] var9 = new ImageView[3];
                        var2[zero] = var9;
                }

                this.boardCells = var2;
                this.board = new Board();
        }


        public final class CellClickListener implements OnClickListener {
                private final int i;
                private final int j;

                @SuppressLint("SetTextI18n")
                public void onClick(View p0) {
                        if (!MainActivity.this.getBoard().isGameOver()) {
                                Cell cell = new Cell(this.i, this.j);
                                MainActivity.this.getBoard().placeMove(cell, "O");
                                MainActivity.this.getBoard().minimax(0, "X");
                                Cell var10000 = MainActivity.this.getBoard().getComputersMove();
                                if (var10000 != null) {

                                        MainActivity.this.getBoard().placeMove(var10000, "X");
                                }

                                MainActivity.this.mapBoardToUi();
                        }

                        TextView var6;
                        if (MainActivity.this.getBoard().hasComputerWon()) {
                                var6 = MainActivity.this.findViewById(R.id.text_view_result);
                                var6.setText("Robot Won");
                        } else if (MainActivity.this.getBoard().hasPlayerWon()) {
                                var6 = MainActivity.this.findViewById(R.id.text_view_result);
                                var6.setText("You Won");
                        } else if (MainActivity.this.getBoard().isGameOver()) {
                                var6 = MainActivity.this.findViewById(R.id.text_view_result);
                                var6.setText("Game Tied");
                        }

                }

                public CellClickListener(int i, int j) {
                        this.i = i;
                        this.j = j;
                }
        }
}
