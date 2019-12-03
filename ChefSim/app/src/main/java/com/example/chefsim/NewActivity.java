package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    int loadCodeInt;

    NewLoad newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        newGame = new NewLoad();
    }

    public void backMain(){
        Intent newMain = new Intent(this, MainActivity.class);
        startActivity(newMain);
    }

    public void newGame(){
        Intent newGame = new Intent(this, GameActivity.class);
        startActivity(newGame);
    }

    public void clkBack(View view)
    {
        finish();
        backMain();
    }

    public void clkEasy(View view) {
        speed = 2;
        customers = 2;
        ingredients = 2;
        orderItems = 2;
        round = 1;
        loadCodeInt = 222201;
        newGame.set(speed, customers, ingredients, orderItems, round);
        Intent myIntent = new Intent(NewActivity.this, GameActivity.class);
        myIntent.putExtra("int", loadCodeInt);
        startActivity(myIntent);
        finish();
    }

    public void clkNormal(View view) {
        speed = 5;
        customers = 5;
        ingredients = 5;
        orderItems = 5;
        round = 1;
        loadCodeInt = 555501;
        newGame.set(speed, customers, ingredients, orderItems, round);
        Intent myIntent = new Intent(NewActivity.this, GameActivity.class);
        myIntent.putExtra("int", loadCodeInt);
        startActivity(myIntent);
        finish();
    }

    public void clkHard(View view) {
        speed = 8;
        customers = 8;
        ingredients = 8;
        orderItems = 8;
        round = 1;
        loadCodeInt = 888801;
        newGame.set(speed, customers, ingredients, orderItems, round);
        Intent myIntent = new Intent(NewActivity.this, GameActivity.class);
        myIntent.putExtra("int", loadCodeInt);
        startActivity(myIntent);
        finish();
    }
}
