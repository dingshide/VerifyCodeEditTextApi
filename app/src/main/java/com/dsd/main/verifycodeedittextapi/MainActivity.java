package com.dsd.main.verifycodeedittextapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dsd.view.mylib.VerifyCodeEditText;

public class MainActivity extends AppCompatActivity implements VerifyCodeEditText.onVerifyInputCompleteListener{


    private VerifyCodeEditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (VerifyCodeEditText) findViewById(R.id.editall);
        text.setListener(this);
    }

    @Override
    public void onCallBack() {

    }

    @Override
    public void onCallBackError() {

    }
}
