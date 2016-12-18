package com.example.sunseer4.suneer4exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ex03_second extends AppCompatActivity {

    public  Ex03_second(){
        Log.e("TAG","Ex03_second() is created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03_second);
    }

    public void Ex03_start3(View view){
        Intent intent = new Intent(this,Ex03_third.class);
        startActivity(intent);
    }

    public void Ex03_start1(View view){
        Intent intent = new Intent(this,Ex03_main.class);
        startActivity(intent);
    }
}
