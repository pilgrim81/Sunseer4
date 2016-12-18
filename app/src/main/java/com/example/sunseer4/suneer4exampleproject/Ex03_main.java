package com.example.sunseer4.suneer4exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ex03_main extends AppCompatActivity {

    public Ex03_main(){
        Log.e("TAG","Ex03_main() is created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03_main);
    }

    public void Ex03_start2(View view){
        Intent intent = new Intent(this,Ex03_second.class);
        startActivity(intent);
    }

    public void Ex03_start1(View view){
        Intent intent = new Intent(this,Ex03_main.class);
        startActivity(intent);
    }
}
