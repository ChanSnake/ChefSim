package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    int loadCodeInt;

    int secondsPassed = 0;
    int time;

    NewLoad newGame;

    EditText etOrder;
    TextView tvRound;
    TextView tvTime;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    String roundString;
    String timeString;

    ArrayList<String> Order;
    ArrayList<String> Burger;

    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            timeString = " Time - " + (time - secondsPassed) + " ";
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        newGame = new NewLoad();
        speed = newGame.getSpeed();
        customers = newGame.getCustomers();
        ingredients = newGame.getIngredients();
        orderItems = newGame.getOrderItems();
        round = newGame.getRound();

        time = newGame.time()*60;

        etOrder = findViewById(R.id.etOrder);
        tvRound = findViewById(R.id.tvRound);
        tvTime = findViewById(R.id.tvTime);
        b1 = findViewById(R.id.butBurger1);
        b2 = findViewById(R.id.butBurger2);
        b3 = findViewById(R.id.butBurger3);
        b4 = findViewById(R.id.butBurger4);
        b5 = findViewById(R.id.butBurger5);
        b6 = findViewById(R.id.butBurger6);
        b7 = findViewById(R.id.butBurger7);
        b8 = findViewById(R.id.butBurger8);
        b9 = findViewById(R.id.butBurger9);

        newGame.set(speed, customers, ingredients, orderItems, round);

        roundString = " Round - " + round + " ";
/*
        tvRound.setText(roundString);
        myTimer.schedule(task, 1000,1000);
        while (time-secondsPassed > 0)
        {
            tvTime.setText(timeString);
        }
*/
    }

    public void clkBun(View view) {
        if(!b1.isEnabled())
        {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b2.setText("Bun");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
        }
        else
        {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b2.setText("Bun");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
        }
    }

    public void clkPatty(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
        b2.setText("Patty");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
    }

    public void clkBacon(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
        b2.setText("Bacon");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
    }

    public void clkTomato(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
        b2.setText("Tomato");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
    }

    public void clkLettuce(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
        b2.setText("Lettuce");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
    }

    public void clkPickles(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
        b2.setText("Pickles");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
    }

    public void clkKetchup(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
        b2.setText("Ketchup");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
    }

    public void clkMustard(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
        b2.setText("Mustard");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
    }

    public void clkCheese(View view) {
        b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
        b2.setText("Cheese");
        b2.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
    }

}
