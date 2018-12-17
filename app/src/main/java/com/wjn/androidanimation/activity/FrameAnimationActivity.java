package com.wjn.androidanimation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wjn.androidanimation.R;

/**
 * 帧动画
 */

public class FrameAnimationActivity extends AppCompatActivity {

    private Button startbtn;
    private Button stopbtn;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanimation);

        imageView = findViewById(R.id.img_show);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        //开始
        startbtn = findViewById(R.id.btn_start);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.start();
            }
        });


        //结束
        stopbtn = findViewById(R.id.btn_stop);
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != animationDrawable && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }

    }
}
