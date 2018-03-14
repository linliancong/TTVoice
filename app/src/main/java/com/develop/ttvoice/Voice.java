package com.develop.ttvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Voice extends AppCompatActivity {

    //语音引擎
    private TTSController mTTSManage;

    private EditText text;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        //实例化语音引擎
        mTTSManage=TTSController.getInstance(getApplicationContext());
        mTTSManage.init();

        text=findViewById(R.id.text);
        btn=findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //语音播报
                mTTSManage.Speark(text.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTTSManage.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //仅仅是停止当前在说的话
        mTTSManage.stopSpeaking();
    }
}
