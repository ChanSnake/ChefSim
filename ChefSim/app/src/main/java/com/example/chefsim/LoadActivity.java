package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoadActivity extends AppCompatActivity {

    int speed;
    int customers;
    int ingredients;
    int orderItems;
    int round;
    String loadCodeStr;
    int loadCodeInt;

    EditText load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void backMain(){
        Intent newMain = new Intent(this, MainActivity.class);
        startActivity(newMain);
    }

    public void clkBack(View view) {
        backMain();
    }

    public void clkLoad(View view) {
        load = findViewById(R.id.etLoad);
        loadCodeStr = load.getText().toString();

        if(!loadCodeStr.equals(""))
        {
            
        }
    }
}
