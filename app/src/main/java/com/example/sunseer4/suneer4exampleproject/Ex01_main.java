package com.example.sunseer4.suneer4exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ex01_main extends AppCompatActivity implements View.OnClickListener {
    //定義
    private EditText et_main_message;
    private Button btn_main_start1;
    private Button btn_main_start2;
    private Button Ex01_main_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01_main);
        //初期化
        et_main_message = (EditText) findViewById(R.id.et_main_message);
        btn_main_start1 = (Button) findViewById(R.id.btn_main_start1);
        btn_main_start2 = (Button) findViewById(R.id.btn_main_start2);
        Ex01_main_close = (Button) findViewById(R.id.Ex01_main_close);

        //listsenerの設定
        btn_main_start1.setOnClickListener(this);
        btn_main_start2.setOnClickListener(this);
        Ex01_main_close.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2 && resultCode == 3){
            String result = data.getStringExtra("RESULT");
            et_main_message.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        //ボタン「呼出(返却無)」を押下する場合
        if(view == btn_main_start1){
//            Toast.makeText(this,"返却無",Toast.LENGTH_SHORT).show();
            //Intentのコンタクト
            Intent intent = new Intent(this,Ex01_second.class);
            //テキストボックス内容を取得
            String message = et_main_message.getText().toString();
            //Intentに文字列を添付
            intent.putExtra("MESSAGE",message);
            //Activityをスタート
            startActivity(intent);
        //ボタン「呼出(返却有)」を押下する場合
        } else if(view == btn_main_start2){
//            Toast.makeText(this,"返却有",Toast.LENGTH_SHORT).show();
            //Intentのコンタクト
            Intent intent = new Intent(this,Ex01_second.class);
            //本Activityのテキストボックス内容の取得
            String message = et_main_message.getText().toString();
            //Intentに添付
            intent.putExtra("MESSAGE",message);
            //requestCodeの設定
            int requestCode = 2;
            //Activityを呼び出す、かつ結果を請求
            startActivityForResult(intent,requestCode);
        } else if(view == Ex01_main_close) {
            finish();
        }
    }
}
