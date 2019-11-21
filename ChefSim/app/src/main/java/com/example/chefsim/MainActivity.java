package com.example.chefsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//waddup
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

    public void clkNew(View view) {
        openNew();
    }

    public void clkLoad(View view) {
        openLoad();
    }

    public void clkExit(View view) {
        finish();
        System.exit(0);
    }

    public void hi()
    {

    }
}