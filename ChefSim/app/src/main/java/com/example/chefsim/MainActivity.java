package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNew(){
        Intent newAct = new Intent(this, NewActivity.class);
        startActivity(newAct);
    }
    public void openLoad(){
        Intent LoadAct = new Intent(this, LoadActivity.class);
        startActivity(LoadAct);
    }
    public void openHow(){
        Intent HowAct = new Intent(this, HowActivity.class);
        startActivity(HowAct);
    }

    public void clkNew(View view) {
        openNew();
    }

    public void clkLoad(View view) {
        finish();
        openLoad();
    }


    public void clkHow(View view) {
        finish();
        openHow();
    }
}