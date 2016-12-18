package com.example.sunseer4.suneer4exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   //ビューの定義
    private Button ex_01;
    private Button ex_02;
    private Button ex_03;

    private Button app_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初期化
        ex_01 = (Button) findViewById(R.id.ex_01);
        ex_02 = (Button) findViewById(R.id.ex_02);
        ex_03 = (Button) findViewById(R.id.ex_03);
        app_01 = (Button) findViewById(R.id.app_01);
        //Listenerの設定
        ex_01.setOnClickListener(this);
        ex_02.setOnClickListener(this);
        ex_03.setOnClickListener(this);
        app_01.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == ex_01){
            Toast.makeText(this,"例の1は実行…",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Ex01_main.class);
            startActivity(intent);
        }
        if(view == ex_02){
            Toast.makeText(this,"例の2は実行…",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Ex02_main.class);
            startActivity(intent);
        }
        if(view == ex_03){
            Toast.makeText(this,"例の3は実行…",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Ex03_main.class);
            startActivity(intent);
        }
        if(view == app_01){
            Toast.makeText(this,"APP1は実行…",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,App01_main.class);
            startActivity(intent);
        }

    }
}
