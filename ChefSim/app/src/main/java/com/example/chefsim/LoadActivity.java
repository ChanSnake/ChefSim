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

    GameActivity newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
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

    public void clkLoad(View view) {
        load = findViewById(R.id.etLoad);
        message = findViewById(R.id.tvMessage);

        if(load.getText().toString().equals(""))
        {
            message.setText("No Code");
        }
        else if(Integer.parseInt(load.getText().toString()) > 999999 || Integer.parseInt(load.getText().toString()) < 100000)
        {
            message.setText("6 Digit Code");
        }
        else
        {
            loadCodeInt = Integer.parseInt(load.getText().toString());
            Intent myIntent = new Intent(LoadActivity.this, GameActivity.class);
            myIntent.putExtra("int", loadCodeInt);
            startActivity(myIntent);
        }
    }
}
