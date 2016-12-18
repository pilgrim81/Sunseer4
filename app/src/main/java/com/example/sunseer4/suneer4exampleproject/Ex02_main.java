package com.example.sunseer4.suneer4exampleproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/*
 *  状態遷移：
 *  1.開始(終了)⇒実行(起動する場合)
 *    Ex02_main()⇒onCreate()⇒onStart()⇒onResume()
 *  2．実行⇒終了(アプリを閉じる)
 *    onPause()⇒onStop()⇒onDestroy()
 *  3．実行⇒停止(HOMEボタンを押下)
 *  　onPause()⇒onStop()
 *  4．停止⇒実行
 *  　onRestart()⇒onStart()⇒onResume()
 *  5. 実行⇒一時停止(ボタンを押下、ダイヤログ表示)
 *    onPause()
 *　6．一時停止⇒実行(ダイヤログを閉じる)
 *    onResume()
 */
public class Ex02_main extends Activity {

    public Ex02_main(){
        Log.e("TAG","Ex02_main()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("TAG","onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02_main);
    }

    @Override
    protected void onStart() {
        Log.e("TAG","onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.e("TAG","onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e("TAG","onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG","onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.e("TAG","onPause()");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e("TAG","onResume()");
        super.onResume();
    }

    public void testPause(View view){
        Intent intent = new Intent(this,Ex02_second.class);
        startActivity(intent);
    }
}
