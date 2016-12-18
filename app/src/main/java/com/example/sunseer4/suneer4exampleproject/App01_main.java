package com.example.sunseer4.suneer4exampleproject;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class App01_main extends Activity implements View.OnLongClickListener {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private EditText app01_input_tel;
    private EditText app01_input_msg;
    private Button app01_btn_tel;
    private Button app01_btn_msg;

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (view == app01_btn_tel) {
//                Toast.makeText(App01_main.this,"電話",Toast.LENGTH_SHORT).show();

                String action = "android.intent.action.DIAL";//Displayed com.android.dialer/.DialtactsActivity: +1s748ms
//                action = Intent.ACTION_DIAL
                Intent intent = new Intent(action);
                String telNum = app01_input_tel.getText().toString();
                intent.setData(Uri.parse("tel:" + telNum));//<data android:scheme="tel" />
                startActivity(intent);

            } else if (view == app01_btn_msg) {
//                Toast.makeText(App01_main.this,"メッセージ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String telNum = app01_input_tel.getText().toString();
                String smsCon = app01_input_msg.getText().toString();
                intent.setData(Uri.parse("smsto:" + telNum));
                intent.putExtra("sms_body",smsCon);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app01_main);

        //初期化
        app01_input_tel = (EditText) findViewById(R.id.app01_input_tel);
        app01_input_msg = (EditText) findViewById(R.id.app01_input_msg);
        app01_btn_tel = (Button) findViewById(R.id.app01_btn_tel);
        app01_btn_msg = (Button) findViewById(R.id.app01_btn_msg);

        //listenerを設定
        app01_btn_tel.setOnClickListener(onClickListener);
        app01_btn_msg.setOnClickListener(onClickListener);

        //Long Click Listenerを設定
        app01_btn_tel.setOnLongClickListener(this);
        app01_btn_msg.setOnLongClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("TAG","OKKKKKK");
                    // permission was granted, yay! do the
                    // calendar task you need to do.

                } else {
                    Log.e("TAG","NOOOOOO");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'switch' lines to check for other
            // permissions this app might request
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onLongClick(View view) {
        if (view == app01_btn_tel) {
//            Toast.makeText(App01_main.this, "電話を長押し", Toast.LENGTH_SHORT).show();
            String action = "android.intent.action.DIAL";
            action = Intent.ACTION_CALL;
            Intent intent = new Intent(action);
            String telNum = app01_input_tel.getText().toString();
            intent.setData(Uri.parse("tel:" + telNum));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Log.e("TAG", "Ask for permission");
                ActivityCompat.requestPermissions(App01_main.this,new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                return true;
            }
            startActivity(intent);

        } else if (view == app01_btn_msg){
//            Toast.makeText(App01_main.this,"メッセージを長押し",Toast.LENGTH_SHORT).show();
            SmsManager smsmanager = SmsManager.getDefault();
            String telNum = app01_input_tel.getText().toString();
            String smsCon = app01_input_msg.getText().toString();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                Log.e("TAG", "Ask for permission");
                ActivityCompat.requestPermissions(App01_main.this,new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                return true;
            }
            smsmanager.sendTextMessage(telNum,null,smsCon,null,null);
            Toast.makeText(this,"発信しました！！！",Toast.LENGTH_SHORT).show();
        }
        return true; //本イベントは完了、以降のイベントは実行しません。
    }
}
