package com.example.sunseer4.suneer4exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ex01_second extends AppCompatActivity {
    //定義
    private EditText et_second_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01_second);

        //初期化
        et_second_message = (EditText) findViewById(R.id.et_second_message);
        //呼び出す元からのIntentを取得
        Intent intent = getIntent();
        //取得されたIntentに添付された文字列の取得
        String message = intent.getStringExtra("MESSAGE");
        //取得された文字列をテキストボックスに表示
        et_second_message.setText(message);
    }
    public void back1(View view){
        //本Activityを閉じる
        finish();
    }

    public void back2(View view){

        //requestCodeの値を与える
        int requestCode = 3;
        //返却する情報を運ぶIntentの定義
        Intent data = new Intent();
        //本Activityのテキストボックス内容の取得
        String res = et_second_message.getText().toString();
        //Intentに取得された内容を添付
        data.putExtra("RESULT",res);
        //結果を返却
        setResult(requestCode, data);

        //本Activityを閉じる
        finish();
    }

    public void Ex01_second_close(View view){
        finish();
    }

}
