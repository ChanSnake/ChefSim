package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class GameActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    int loadCodeInt;
    int difficulty;
 int points;
    int secondsPassed = 0;
    int time;

    String codeString;

    NewLoad newGame;
    Order myOrder;

    EditText etOrder;
    TextView tvRound;
    TextView tvTime;
    Button button;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    String top1;
    String top2;
    String top3;
    String top4;
    String top5;
    String top6;
    String top7;
    String top8;



    String roundString;
    String timeString;

    ArrayList<String> Order;
    ArrayList<String> Burger;
    ArrayList<String> codeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        myOrder = new Order();
        Burger = new ArrayList<>();
        points = 0;

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

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("int", 111111);

        loadCodeInt = (intValue);


        codeList = new ArrayList<String>();
        while (loadCodeInt > 0) {

            codeList.add(String.valueOf(loadCodeInt % 10));

            loadCodeInt = loadCodeInt / 10;
        }
        for(int i = 2; i < 5; i++)
        {
            if(Integer.parseInt(codeList.get(i)) == 0) {
                codeList.set(i, "1");
            }
        }
        if(Integer.parseInt(codeList.get(0)) == 0 && Integer.parseInt(codeList.get(1)) == 0)
        {
            codeList.set(0, "1");
            speed = Integer.parseInt(codeList.get(5));
            customers = Integer.parseInt(codeList.get(4));
            ingredients = Integer.parseInt(codeList.get(3));
            orderItems = Integer.parseInt(codeList.get(2));
            round = Integer.parseInt(codeList.get(1) + codeList.get(0));
            System.out.println("speed" + speed);
            System.out.println("customers" + customers);
            System.out.println("ingredients" + ingredients);
            System.out.println("orderItems" + orderItems);
            System.out.println("round" + round);
        }
        else
        {
            speed = Integer.parseInt(codeList.get(5));
            customers = Integer.parseInt(codeList.get(4));
            ingredients = Integer.parseInt(codeList.get(3));
            orderItems = Integer.parseInt(codeList.get(2));
            round = Integer.parseInt(codeList.get(1) + codeList.get(0));
            System.out.println("speed" + speed);
            System.out.println("customers" + customers);
            System.out.println("ingredients" + ingredients);
            System.out.println("orderItems" + orderItems);
            System.out.println("round" + round);
        }
        roundString = " Round - " + round + " ";
        tvRound.setText(roundString);

        timeString = " Points - " + points + " ";
        tvTime.setText(timeString);

        if(ingredients < 4)
        {
            difficulty = 1;
            etOrder.setText(myOrder.getRandomIngredientEasy());
            System.out.println("e");
        }
        else if(ingredients > 3 && ingredients < 7)
        {
            difficulty = 2;
            etOrder.setText(myOrder.getRandomIngredientMedium());
            System.out.println("m");
        }
        else        {
            difficulty = 3;
            etOrder.setText(myOrder.getRandomIngredientHard());
            System.out.println("h");
        }
    }

/*
        tvRound.setText(roundString);
        myTimer.schedule(task, 1000,1000);
        while (time-secondsPassed > 0)
        {
            tvTime.setText(timeString);
        }
*/



    public void set(int speed,  int customers, int ingredients, int orderItems, int round)
    {
        this.speed = speed;
        this.customers = customers;
        this.ingredients = ingredients;
        this.orderItems = orderItems;
        this.round = round;
        System.out.println("speed " + this.speed);
        System.out.println("customers " + this.customers);
        System.out.println("ingredients " + this.ingredients);
        System.out.println("orderItems " + this.orderItems);
        System.out.println("round " + this.round);

    }

    public void clkBun(View view) {
        if(Burger.isEmpty())
        {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b1.setText("Bun");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("bun");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1)
        {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b2.setText("Bun");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2)
        {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b3.setText("Bun");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3)
        {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b4.setText("Bun");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4)
        {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b5.setText("Bun");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5)
        {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b6.setText("Bun");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6)
        {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b7.setText("Bun");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7)
        {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b8.setText("Bun");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8)
        {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
            b9.setText("Bun");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
            Burger.add("bun");
            b9.setVisibility(View.VISIBLE);
        }

    }

    public void clkPatty(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b1.setText("Patty");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b2.setText("Patty");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b3.setText("Patty");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b4.setText("Patty");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b5.setText("Patty");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b6.setText("Patty");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b7.setText("Patty");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b8.setText("Patty");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
            b9.setText("Patty");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
            Burger.add("patty");
            b9.setVisibility(View.VISIBLE);
        }

    }

    public void clkBacon(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b1.setText("Bacon");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b2.setText("Bacon");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b3.setText("Bacon");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b4.setText("Bacon");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b5.setText("Bacon");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b6.setText("Bacon");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b7.setText("Bacon");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b8.setText("Bacon");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
            b9.setText("Bacon");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
            Burger.add("bacon");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkTomato(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b1.setText("Tomato");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b2.setText("Tomato");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b3.setText("Tomato");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b4.setText("Tomato");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b5.setText("Tomato");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b6.setText("Tomato");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b7.setText("Tomato");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b8.setText("Tomato");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
            b9.setText("Tomato");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("tomato");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkLettuce(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b1.setText("Lettuce");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b2.setText("Lettuce");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b3.setText("Lettuce");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b4.setText("Lettuce");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b5.setText("Lettuce");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b6.setText("Lettuce");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b7.setText("Lettuce");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b8.setText("Lettuce");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
            b9.setText("Lettuce");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
            Burger.add("lettuce");
            b9.setVisibility(View.VISIBLE);
        }

    }

    public void clkPickles(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b1.setText("Pickles");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b2.setText("Pickles");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b3.setText("Pickles");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b4.setText("Pickles");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b5.setText("Pickles");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b6.setText("Pickles");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b7.setText("Pickles");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b8.setText("Pickles");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
            b9.setText("Pickles");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("pickles");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkKetchup(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b1.setText("Ketchup");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b2.setText("Ketchup");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b3.setText("Ketchup");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b4.setText("Ketchup");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b5.setText("Ketchup");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b6.setText("Ketchup");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b7.setText("Ketchup");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b8.setText("Ketchup");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
            b9.setText("Ketchup");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("ketchup");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkMustard(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b1.setText("Mustard");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b2.setText("Mustard");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b3.setText("Mustard");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b4.setText("Mustard");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b5.setText("Mustard");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b6.setText("Mustard");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b7.setText("Mustard");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b8.setText("Mustard");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
            b9.setText("Mustard");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
            Burger.add("mustard");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkCheese(View view) {
        if(Burger.isEmpty()) {
            b1.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b1.setText("Cheese");
            b1.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b1.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 1) {
            b2.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b2.setText("Cheese");
            b2.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b2.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 2) {
            b3.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b3.setText("Cheese");
            b3.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b3.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 3) {
            b4.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b4.setText("Cheese");
            b4.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b4.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 4) {
            b5.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b5.setText("Cheese");
            b5.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b5.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 5) {
            b6.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b6.setText("Cheese");
            b6.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b6.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 6) {
            b7.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b7.setText("Cheese");
            b7.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b7.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 7) {
            b8.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b8.setText("Cheese");
            b8.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b8.setVisibility(View.VISIBLE);
        }
        else if(Burger.size() == 8) {
            b9.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
            b9.setText("Cheese");
            b9.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
            Burger.add("cheese");
            b9.setVisibility(View.VISIBLE);
        }
    }

    public void clkCode(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if(round < 10)
        {
            codeString = String.valueOf(speed)+String.valueOf(customers)+String.valueOf(ingredients)+String.valueOf(orderItems)+0+String.valueOf(round);
        }
        else
        {
            codeString = String.valueOf(speed)+String.valueOf(customers)+String.valueOf(ingredients)+String.valueOf(orderItems)+String.valueOf(round);
        }
        System.out.println(codeString);
        ClipData clip = ClipData.newPlainText("code", codeString);
        clipboard.setPrimaryClip(clip);
    }

    public void backMain(){
        Intent newMain = new Intent(this, MainActivity.class);
        startActivity(newMain);
    }

    public void clkBack(View view) {
        finish();
        backMain();
    }

    public void clkBtn1(View view) {
        Burger.remove(0);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn2(View view) {
        Burger.remove(1);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn3(View view) {
        Burger.remove(2);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn4(View view) {
        Burger.remove(3);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn5(View view) {
        Burger.remove(4);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }

            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }    }

    public void clkBtn6(View view) {
        Burger.remove(5);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn7(View view) {
        Burger.remove(6);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn8(View view) {
        Burger.remove(7);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkBtn9(View view) {
        Burger.remove(8);
        for(int i = 0; i < 9; i++) {
            if(i==0)
            {
                button = findViewById(R.id.butBurger1);
            }
            else if (i==1)
            {
                button = findViewById(R.id.butBurger2);
            }
            else if (i==2)
            {
                button = findViewById(R.id.butBurger3);
            }
            else if (i==3)
            {
                button = findViewById(R.id.butBurger4);
            }
            else if (i==4)
            {
                button = findViewById(R.id.butBurger5);
            }
            else if (i==5)
            {
                button = findViewById(R.id.butBurger6);
            }
            else if (i==6)
            {
                button = findViewById(R.id.butBurger7);
            }
            else if (i==7)
            {
                button = findViewById(R.id.butBurger8);
            }
            else if (i==8)
            {
                button = findViewById(R.id.butBurger9);
            }
            else
            {
                break;
            }
            if(i +1> Burger.size())
            {
                button.setVisibility(View.GONE);
            }

            else if (Burger.get(i).equals("bun")) {
                if(i == 0)
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                    button.setVisibility(View.VISIBLE);
                }
                else
                {
                    button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bun));
                    button.setText("Bun");
                    button.setLayoutParams(new LinearLayout.LayoutParams(490, 200));
                    button.setVisibility(View.VISIBLE);
                }
            } else if (Burger.get(i).equals("patty")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.patty));
                button.setText("Patty");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 160));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("bacon")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.bacon));
                button.setText("Bacon");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 100));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("cheese")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.cheese));
                button.setText("Cheese");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("ketchup")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.ketchup));
                button.setText("Ketchup");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("mustard")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.mustard));
                button.setText("Mustard");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 60));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("lettuce")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.lettuce));
                button.setText("Lettuce");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("pickles")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.pickles));
                button.setText("Pickles");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 80));
                button.setVisibility(View.VISIBLE);

            } else if (Burger.get(i).equals("tomato")) {
                button.setBackground(ContextCompat.getDrawable(GameActivity.this, R.drawable.tomato));
                button.setText("Tomato");
                button.setLayoutParams(new LinearLayout.LayoutParams(490, 120));
                button.setVisibility(View.VISIBLE);

            }
            else
            {
                break;
            }
        }
    }

    public void clkDeliver(View view) {
        if(!Burger.isEmpty())
        {
            Boolean tf = false;
            System.out.println(Burger.get(0) + " " + Burger.get(1));
            if (difficulty == 1) {
                tf = myOrder.testE(Burger.get(0), Burger.get(1));
            } else if (difficulty == 2) {
                tf = myOrder.testM(Burger.get(0), Burger.get(1), Burger.get(2), Burger.get(3), Burger.get(4));
            } else if (difficulty == 3) {
                tf = myOrder.testH(Burger.get(0), Burger.get(1), Burger.get(2), Burger.get(3), Burger.get(4), Burger.get(5), Burger.get(6), Burger.get(7));
            }
            if (tf == false) {
                points--;
                timeString = " Points - " + points + " ";
                tvTime.setText(timeString);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                Burger.clear();

                etOrder.setText("Messed up order!");
                if (ingredients < 4) {
                    difficulty = 1;
                    etOrder.setText(myOrder.getRandomIngredientEasy());
                    System.out.println("e");
                } else if (ingredients > 3 && ingredients < 7) {
                    difficulty = 2;
                    etOrder.setText(myOrder.getRandomIngredientMedium());
                    System.out.println("m");
                } else {
                    difficulty = 3;
                    etOrder.setText(myOrder.getRandomIngredientHard());
                    System.out.println("h");
                }
            } else {
                points += points*round;
                timeString = " Points - " + points + " ";
                tvTime.setText(timeString);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                Burger.clear();
                etOrder.setText("Good Burger!");
                if (ingredients < 4) {
                    difficulty = 1;
                    etOrder.setText(myOrder.getRandomIngredientEasy());
                    System.out.println("e");
                } else if (ingredients > 3 && ingredients < 7) {
                    difficulty = 2;
                    etOrder.setText(myOrder.getRandomIngredientMedium());
                    System.out.println("m");
                } else {
                    difficulty = 3;
                    etOrder.setText(myOrder.getRandomIngredientHard());
                    System.out.println("h");
                }
            }
        }
    }

    public void clkNext(View view) {
        if(round < 99)
        {
            round++;
            roundString = " Round - " + round + " ";
            tvRound.setText(roundString);
            if(ingredients < 4)
            {
                difficulty = 1;
                etOrder.setText(myOrder.getRandomIngredientEasy());
                System.out.println("e");
            }
            else if(ingredients > 3 && ingredients < 7)
            {
                difficulty = 2;
                etOrder.setText(myOrder.getRandomIngredientMedium());
                System.out.println("m");
            }
            else        {
                difficulty = 3;
                etOrder.setText(myOrder.getRandomIngredientHard());
                System.out.println("h");
            }
        }
        else
        {
            etOrder.setText("All Rounds have been completed! \n You win!");
        }
    }
}
