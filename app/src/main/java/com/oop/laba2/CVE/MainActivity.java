package com.oop.laba2.CVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    private CountDownTimer mTimer;
    TextView back;
    TextView time;
    Button send_new_code;
    EditText t1,t2,t3,t4;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //StatusBarUtil.setTransparent(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        time = findViewById(R.id.textView);
        back = findViewById(R.id.textView3);
        send_new_code = findViewById(R.id.button);
        t1 = findViewById(R.id.editTextNumber);
        t2 = findViewById(R.id.editTextNumber2);
        t3 = findViewById(R.id.editTextNumber5);
        t4 = findViewById(R.id.editTextNumber4);
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBackground();
                if (t1.getText().length()==1)
                {
                    if (t2.getText().length()==0)
                    {
                        t2.requestFocus();
                        return;
                    }
                    if (t3.getText().length()==0)
                    {
                        t3.requestFocus();
                        return;
                    }
                    if (t4.getText().length()==0)
                    {
                        t4.requestFocus();
                        return;
                    }
                }

            }
        });
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBackground();
                if (t2.getText().length()==1)
                {
                    if (t1.getText().length()==0)
                    {
                        t1.requestFocus();
                        return;
                    }
                    if (t3.getText().length()==0)
                    {
                        t3.requestFocus();
                        return;
                    }
                    if (t4.getText().length()==0)
                    {
                        t4.requestFocus();
                        return;
                    }

                }
            }
        });
        t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBackground();
                if (t3.getText().length()==1)
                {
                    if (t1.getText().length()==0)
                    {
                        t1.requestFocus();
                        changeBackground();
                        return;
                    }
                    if (t2.getText().length()==0)
                    {
                        t2.requestFocus();
                        changeBackground();
                        return;
                    }
                    if (t4.getText().length()==0)
                    {
                        t4.requestFocus();
                        changeBackground();
                        return;
                    }
                }
            }
        });
        t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBackground();
                if (t4.getText().length()==1)
                {
                    if (t1.getText().length()==0)
                    {
                        t1.requestFocus();
                        return;
                    }
                    if (t2.getText().length()==0)
                    {
                        t2.requestFocus();
                        return;
                    }
                    if (t3.getText().length()==0)
                    {
                        t3.requestFocus();
                        return;
                    }
                }
            }
        });
        send_new_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "4-значный код обновлен и будет действителен минуту",Toast.LENGTH_LONG).show();
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t1.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t2.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t3.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t4.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t1.requestFocus();
                mTimer.start();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mTimer = new CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished>=60000)
                {
                    long minutes = millisUntilFinished/60000;
                    long seconds = (millisUntilFinished-minutes*60000)/1000;
                    if (seconds>=0 && seconds<10)
                    {
                        time.setText(String.valueOf(minutes) + ":0" + String.valueOf(seconds));
                    }
                    else {
                        time.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
                    }
                }
                else
                {
                    long seconds = millisUntilFinished/1000;
                    if (seconds>=0 && seconds<10)
                    {
                        time.setText("00:0" + String.valueOf(seconds));
                    }
                    else {
                        time.setText("00:" + String.valueOf(seconds));
                    }
                }

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                time.setText("00:00");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t1.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t2.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t3.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t4.setBackgroundResource(R.drawable.bg_text_edit_blue);
                t1.requestFocus();
                mTimer.cancel();
                mTimer.start();
                Toast.makeText(getApplicationContext(), "4-значный код больше не действителен",Toast.LENGTH_LONG).show();
            }
        };
        mTimer.start();
        Toast.makeText(getApplicationContext(), "4-значный код действителен минуту",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onBackPressed() {
        mTimer.cancel();
        finish();
    }
    private void changeBackground()
    {
        String code = t1.getText().toString()+ t2.getText().toString()+t3.getText().toString()+t4.getText().toString();
        if (code.length()==4)
        {
            t1.setBackgroundResource(R.drawable.bg_text_edit_red);
            t2.setBackgroundResource(R.drawable.bg_text_edit_red);
            t3.setBackgroundResource(R.drawable.bg_text_edit_red);
            t4.setBackgroundResource(R.drawable.bg_text_edit_red);
        }
        if (t1.getText().length()==0)
        {
            t1.setBackgroundResource(R.drawable.bg_text_edit_blue);
        }
        if (t2.getText().length()==0)
        {
            t2.setBackgroundResource(R.drawable.bg_text_edit_blue);
        }
        if (t3.getText().length()==0)
        {
            t3.setBackgroundResource(R.drawable.bg_text_edit_blue);
        }
        if (t4.getText().length()==0)
        {
            t4.setBackgroundResource(R.drawable.bg_text_edit_blue);
        }
    }
}