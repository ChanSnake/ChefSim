package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    int loadCodeInt = 0;
    ArrayList<String> codeList;

    EditText load;
    TextView message;

    NewLoad newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void backMain(){
        Intent newMain = new Intent(this, MainActivity.class);
        startActivity(newMain);
    }

    public void clkBack(View view)
    {
        finish();
        backMain();
    }

    public void clkLoad(View view) {
        load = findViewById(R.id.etLoad);
        message = findViewById(R.id.tvMessage);
        if(load.getText().toString().equals(""))
        {
            message.setText("No Code");
        }
        else
        {
            loadCodeInt = Integer.parseInt(load.getText().toString());

            if(loadCodeInt < 111100 && loadCodeInt > 999999) {
                message.setText("6 Digit Code");
            }
            else {
                codeList = new ArrayList<String>();
                while (loadCodeInt > 0) {

                    codeList.add(String.valueOf(loadCodeInt % 10));

                    loadCodeInt = loadCodeInt / 10;
                }

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
                newGame = new NewLoad();
                newGame.set(speed, customers, ingredients, orderItems, round);
            }
        }
    }
}
