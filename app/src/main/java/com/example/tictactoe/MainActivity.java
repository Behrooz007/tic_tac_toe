package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1 : x and 0 : y and 2 : empty
    int [][] winnigPosition= {{0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1,4,7} ,{2,5,8} ,{0,4,8},{2,4,6}};
    int activePlayer = 1;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    boolean gameActive = true;
    TextView winnerTextview ;
    public void dropIn(View view){

        ImageView counter = (ImageView) view ;
        Log.i("Tag",counter.getTag().toString());
        int tappedCouner = Integer.parseInt(counter.getTag().toString());

        if(gamestate[tappedCouner] == 2 && gameActive ){

            gamestate[tappedCouner] = activePlayer;


            counter.setTranslationY(-1500);

            if (activePlayer == 1){

                counter.setImageResource(R.drawable.y);

                activePlayer = 0 ;
            }else{

                counter.setImageResource(R.drawable.x1);
                activePlayer = 1 ;
            }
            counter.animate().translationYBy(1500).rotation(360*3).setDuration(500);


            for(int[] winnigPosition : winnigPosition) {

                if (gamestate[winnigPosition[0]] == gamestate[winnigPosition[1]] && gamestate[winnigPosition[1]] == gamestate[winnigPosition[2]] && gamestate[winnigPosition[0]] != 2) {

                    gameActive = false;
                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "X";
                    } else {

                        winner = "Y";
                    }


                    Button winnerButton = (Button) findViewById(R.id.winnerButton);
                    winnerTextview.setVisibility(View.VISIBLE);
                    winnerTextview.setText(winner + " WINNER");
                    winnerButton.setVisibility(View.VISIBLE);
                    winnerTextview.setVisibility(View.VISIBLE);

                }
            }
        }
    }



    public void playAgain(View view) {

        Button winnerButton = (Button) findViewById(R.id.winnerButton);
        TextView winnerTextview = (TextView) findViewById(R.id.winnerTextview);
        winnerButton.setVisibility(View.INVISIBLE);
        winnerTextview.setVisibility(View.INVISIBLE);


        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

            for (int j = 0; j < gamestate.length; j++) {

                gamestate[j] = 2;
                activePlayer = 0;
                gameActive = true;


            }
        }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerTextview = (TextView) findViewById(R.id.winnerTextview);
        winnerTextview.setVisibility(View.INVISIBLE);

    }
}