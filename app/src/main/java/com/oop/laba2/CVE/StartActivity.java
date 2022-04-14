package com.oop.laba2.CVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

public class StartActivity extends AppCompatActivity {

    Button btn_form1,btn_form2,btn_form3;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //StatusBarUtil.setTransparent(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        btn_form1 = findViewById(R.id.button_form1);
        btn_form2 = findViewById(R.id.button_form2);
        btn_form3 = findViewById(R.id.button_form3);
        btn_form1.setOnClickListener(btn_form_click_listener);
        btn_form2.setOnClickListener(btn_form_click_listener);
        btn_form3.setOnClickListener(btn_form_click_listener);
    }
    public View.OnClickListener btn_form_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.button_form1:
                    startNewActivity(new MainActivity());
                    break;
                case R.id.button_form2:
                    startNewActivity(new NewsActivity());
                    break;
                case R.id.button_form3:
                    startNewActivity(new CollectionActivity());
                    break;
                default:
                    break;
            }

        }
    };
    @Override
    public void onBackPressed() {
        finish();
    }
    private void startNewActivity(Activity next_activity)
    {
        startActivity(new Intent(StartActivity.this, next_activity.getClass()));
    }
}