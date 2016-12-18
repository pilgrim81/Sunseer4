package com.example.sunseer4.suneer4exampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Ex03_third extends AppCompatActivity {
    public  Ex03_third(){
        Log.e("TAG","Ex03_third() is created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03_third);
    }
}
