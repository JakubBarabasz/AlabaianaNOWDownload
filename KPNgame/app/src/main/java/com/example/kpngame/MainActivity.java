package com.example.kpngame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int playerChoice;
    int playerScore = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView playerScoreText = findViewById(R.id.playerScoreText);
        TextView gameStatus = findViewById(R.id.gameStatus);

        ImageView playerRock = findViewById(R.id.playerRock);
        ImageView playerPaper = findViewById(R.id.playerPaper);
        ImageView playerScissors = findViewById(R.id.playerScissors);

        ImageView compRock = findViewById(R.id.compRock);
        ImageView compPaper = findViewById(R.id.compPaper);
        ImageView compScissors = findViewById(R.id.compScissors);

        Button chooseRock = findViewById(R.id.chooseRock);
        Button choosePaper = findViewById(R.id.choosePaper);
        Button chooseScissors = findViewById(R.id.chooseScissors);

        playerRock.setVisibility(View.INVISIBLE);
        playerPaper.setVisibility(View.INVISIBLE);
        playerScissors.setVisibility(View.INVISIBLE);
        compRock.setVisibility(View.INVISIBLE);
        compPaper.setVisibility(View.INVISIBLE);
        compScissors.setVisibility(View.INVISIBLE);
        
        chooseRock.setOnClickListener(v -> {
            playerChoice = 0;

            Random random = new Random();
            int compChoose = random.nextInt(3);

            if (compChoose == 0) {
                compRock.setVisibility(View.VISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 1) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.VISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 2) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.VISIBLE);
            }

            if (compChoose == 0 && playerChoice == 1) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 0 && playerChoice == 2) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 0) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 2) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 0) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 1) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else{
                gameStatus.setText("Remis!");
            }


            playerScoreText.setText("Punkty: " + playerScore);

            playerRock.setVisibility(View.VISIBLE);
            playerPaper.setVisibility(View.INVISIBLE);
            playerScissors.setVisibility(View.INVISIBLE);
        });

        choosePaper.setOnClickListener(v -> {

            playerChoice = 1;

            Random random = new Random();
            int compChoose = random.nextInt(3);

            if (compChoose == 0) {
                compRock.setVisibility(View.VISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 1) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.VISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 2) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.VISIBLE);
            }

            if (compChoose == 0 && playerChoice == 1) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 0 && playerChoice == 2) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 0) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 2) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 0) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 1) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else{
                gameStatus.setText("Remis!");
            }


            playerScoreText.setText("Punkty: " + playerScore);

            playerRock.setVisibility(View.INVISIBLE);
            playerPaper.setVisibility(View.VISIBLE);
            playerScissors.setVisibility(View.INVISIBLE);
        });

        chooseScissors.setOnClickListener(v -> {

            playerChoice = 2;

            Random random = new Random();
            int compChoose = random.nextInt(3);

            if (compChoose == 0) {
                compRock.setVisibility(View.VISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 1) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.VISIBLE);
                compScissors.setVisibility(View.INVISIBLE);
            }
            if (compChoose == 2) {
                compRock.setVisibility(View.INVISIBLE);
                compPaper.setVisibility(View.INVISIBLE);
                compScissors.setVisibility(View.VISIBLE);
            }

            if (compChoose == 0 && playerChoice == 1) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 0 && playerChoice == 2) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 0) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else if (compChoose == 1 && playerChoice == 2) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 0) {
                playerScore++;
                gameStatus.setText("Wygrałeś!");
            }else if (compChoose == 2 && playerChoice == 1) {
                playerScore--;
                gameStatus.setText("Przegrałeś!");
            }else{
                gameStatus.setText("Remis!");
            }


            playerScoreText.setText("Punkty: " + playerScore);

            playerRock.setVisibility(View.INVISIBLE);
            playerPaper.setVisibility(View.INVISIBLE);
            playerScissors.setVisibility(View.VISIBLE);
        });

    }


}