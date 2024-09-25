package com.diegocayo.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private Random random = new Random();
ImageView imagePlayer, imageCPU;
Button rockButton, paperButton, scissorsButton;
TextView resultText, scoreText;
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagePlayer = findViewById(R.id.playerImage);
        imageCPU = findViewById(R.id.cpuImage);
        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorButton);
        resultText = findViewById(R.id.resultText);
        scoreText = findViewById(R.id.scoreText);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = generateRandomNumber();
                showWinner(randomNumber, "rock");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = generateRandomNumber();
                showWinner(randomNumber, "paper");
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = generateRandomNumber();
                showWinner(randomNumber, "scissor");
            }
        });
    }

    private int generateRandomNumber () {
        int result = random.nextInt(3-1+1)+1;
        return result;
    }

    private void showWinner(int result, String userChoice) {


        switch (result) {
            case 1:
                imageCPU.setImageResource(R.drawable.pedra);
                showPlayerImage(userChoice);
                if (userChoice.equalsIgnoreCase("rock")){
                    resultText.setText(getString(R.string.drawText));
                } else if (userChoice.equalsIgnoreCase("paper")) {
                    resultText.setText(getString(R.string.winText));
                    score++;
                    String scoreStr = "Score: " + score;
                    scoreText.setText(scoreStr);
                } else if (userChoice.equalsIgnoreCase("scissor")) {
                    resultText.setText(getString(R.string.defeatText));
                }
                break;
            case 2:
                imageCPU.setImageResource(R.drawable.paper);
                showPlayerImage(userChoice);
                if (userChoice.equalsIgnoreCase("rock")){
                    resultText.setText(getString(R.string.defeatText));
                } else if (userChoice.equalsIgnoreCase("paper")) {
                    resultText.setText(getString(R.string.drawText));
                } else if (userChoice.equalsIgnoreCase("scissor")) {
                    resultText.setText(getString(R.string.winText));
                    score++;
                    String scoreStr = "Score: " + score;
                    scoreText.setText(scoreStr);
                }
                break;
            case 3:
                imageCPU.setImageResource(R.drawable.tisores);
                showPlayerImage(userChoice);
                if (userChoice.equalsIgnoreCase("rock")){
                    resultText.setText(getString(R.string.winText));
                    score++;
                    String scoreStr = "Score: " + score;
                    scoreText.setText(scoreStr);
                } else if (userChoice.equalsIgnoreCase("paper")) {
                    resultText.setText(getString(R.string.defeatText));
                } else if (userChoice.equalsIgnoreCase("scissor")) {
                    resultText.setText(getString(R.string.drawText));
                }
                break;
        }

    }

    private void showPlayerImage(String userChoice) {
        if (userChoice.equalsIgnoreCase("rock")) {
            imagePlayer.setImageResource(R.drawable.pedra);
        } else if (userChoice.equalsIgnoreCase("paper")) {
            imagePlayer.setImageResource(R.drawable.paper);
        } else if (userChoice.equalsIgnoreCase("scissor")) {
            imagePlayer.setImageResource(R.drawable.tisores);
        }
    }
}