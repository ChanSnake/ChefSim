package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoadActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    int loadCodeInt = 6969;

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
        loadCodeInt = Integer.parseInt(load.getText().toString());
        newGame = new NewLoad();

        if(loadCodeInt == 6969){
            message.setText("No Code");
        }
        else if(loadCodeInt > 111099 && loadCodeInt < 1000000) {
            message.setText("6 Digit Code");
        }
        else {

        }
    }
}
