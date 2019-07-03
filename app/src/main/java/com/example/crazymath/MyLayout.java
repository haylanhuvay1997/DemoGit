package com.example.crazymath;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MyLayout extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_so1;
    private TextView tv_so2;
    private TextView tv_result;
    private TextView tv_time;
    private TextView tv_point;
    private TextView dapan;
    private ImageView iv_check_true, iv_check_false;
    private int scores;
    private int result, dem = 0;
    private int timeFinish = 100000;
    private boolean check = true;
    CountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kiemtra();
        initView();
    }

    private void kiemtra() {
        Random rd = new Random();
        int so1 = rd.nextInt(100);
        int so2 = rd.nextInt(100);
        tv_so1.setText(String.valueOf(so1));
        tv_so2.setText(String.valueOf(so2));
        tv_point.setText("0");
        result = so1 + so2;
        int min = result - 1;
        int max = result + 1;
        int item = max - min + 1;
        int kq = result - 1 + new Random().nextInt(item);
        dapan.setText(String.valueOf(kq));
        tv_time.setText("");
        if (scores < 3) {
            timer = new CountDownTimer(timeFinish, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (check = true) {
                        tv_time.setText(String.valueOf(1 / 1000));
                    }

                }

                @Override
                public void onFinish() {
                    tv_time.setText("0");
                    Toast.makeText(MyLayout.this, "diem cua ban " + scores, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyLayout.this, ActivityFinish.class);
                    startActivity(intent);


                }
            }.start();
        } else if (scores < 10) {
            timer = new CountDownTimer(timeFinish, 1500) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (check == true) {
                        tv_time.setText(String.valueOf(1 / 1500));

                    }

                }

                @Override
                public void onFinish() {
                    tv_time.setText("0");
                    Toast.makeText(MyLayout.this, "diem cua ban " + scores, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyLayout.this, ActivityFinish.class);
                    startActivity(intent);

                }
            }.start();
        } else
            timer = new CountDownTimer(timeFinish, 2000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (check == true) {
                        tv_time.setText(String.valueOf(1 / 2000));
                    }

                }

                @Override
                public void onFinish() {
                    tv_time.setText("0");
                    Toast.makeText(MyLayout.this, "diem cua ban " + scores, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyLayout.this, ActivityFinish.class);
                    startActivity(intent);


                }
            }.start();
        iv_check_false.setOnClickListener(this);
        iv_check_true.setOnClickListener(this);


    }

    private void initView() {
        tv_so1 = findViewById(R.id.tv_so1);
        tv_so2 = findViewById(R.id.tv_so2);
        tv_result = findViewById(R.id.tv_result);
        tv_point = findViewById(R.id.tv_diem);
        tv_time = findViewById(R.id.tv_time);
        iv_check_true = findViewById(R.id.iv_check_true);
        iv_check_false = findViewById(R.id.iv_check_false);
        dapan = findViewById(R.id.tv_equals);

    }

    @Override
    public void onClick(View v) {
        result = Integer.parseInt(tv_so1.getText().toString()) + Integer.parseInt(tv_so2.getText().toString());
        switch (v.getId()) {
            case R.id.iv_check_true:
                if (Integer.parseInt(dapan.getText().toString()) == result) {
                    Random rd = new Random();
                    int so1 = rd.nextInt(100);
                    int so2 = rd.nextInt(100);
                    tv_so1.setText(String.valueOf(so1));
                    tv_so2.setText(String.valueOf(so2));
                    tv_point.setText("0");
                    result = so1 + so2;
                    int min = result - 1;
                    int max = result + 1;
                    int item = max - min + 1;
                    int kq = result - 1 + new Random().nextInt(item);
                    scores++;
                    dapan.setText(String.valueOf(kq));
                    tv_point.setText(String.valueOf(scores));
                } else {
                    Toast.makeText(MyLayout.this, "ban đã chọn đáp án sai" +
                            "", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyLayout.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.iv_check_false:
                if (Integer.parseInt(dapan.getText().toString()) != result) {
                    Random rd = new Random();
                    int so1 = rd.nextInt(100);
                    int so2 = rd.nextInt(100);
                    tv_so1.setText(String.valueOf(so1));
                    tv_so2.setText(String.valueOf(so2));
                    tv_point.setText("0");
                    result = so1 + so2;
                    int min = result - 1;
                    int max = result + 1;
                    int item = max - min + 1;
                    int kq = result - 1 + new Random().nextInt(item);
                    scores++;
                    dapan.setText(String.valueOf(kq));
                    tv_point.setText(String.valueOf(scores));


                } else {
                    Toast.makeText(this, "ban da chon dap an sai ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MyLayout.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
                default:
                    break;


        }
    }
}
