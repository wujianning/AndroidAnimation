package com.wjn.androidanimation.activity;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wjn.androidanimation.R;

/**
 * 属性动画
 * */

public class AttributeAnimationActivity extends AppCompatActivity {

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributeanimation);

        linearLayout = findViewById(R.id.linearlayout);
        btn_one = findViewById(R.id.button1);
        btn_two = findViewById(R.id.button2);
        btn_three = findViewById(R.id.button3);
        btn_four = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageview);


        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineAnimator();
            }
        });


        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleAnimator();
            }
        });


        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raAnimator();
            }
        });


        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleAnimator();
            }
        });
    }

    /**
     * 移动图片
     * */


    private void moveView(View view, int rawX, int rawY) {
        int left = rawX - imageView.getWidth() / 2;
        int top = rawY - imageView.getHeight();
        int width = left + view.getWidth();
        int height = top + view.getHeight();
        view.layout(left, top, width, height);
    }


    //按轨迹方程来运动
    private void lineAnimator() {
        width = linearLayout.getWidth();
        height = linearLayout.getHeight();
        ValueAnimator xValue = ValueAnimator.ofInt(height, 0, height / 4, height / 2, height / 4 * 3, height);
        xValue.setDuration(3000L);
        xValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 轨迹方程 x = width / 2
                int y = (Integer) animation.getAnimatedValue();
                int x = width / 2;
                moveView(imageView, x, y);
            }
        });
        xValue.setInterpolator(new LinearInterpolator());
        xValue.start();
    }


    //缩放效果
    private void scaleAnimator() {
        ValueAnimator vValue = ValueAnimator.ofFloat(1.0f, 0.6f, 1.2f, 1.0f, 0.6f, 1.2f, 1.0f);
        vValue.setDuration(1000L);
        vValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (Float) animation.getAnimatedValue();
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });
        vValue.setInterpolator(new LinearInterpolator());
        vValue.start();
    }




    //旋转的同时透明度变化
    private void raAnimator() {
        ValueAnimator rValue = ValueAnimator.ofInt(0, 360);
        rValue.setDuration(1000L);
        rValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int rotateValue = (Integer) animation.getAnimatedValue();
                imageView.setRotation(rotateValue);
                float fractionValue = animation.getAnimatedFraction();
                imageView.setAlpha(fractionValue);
            }
        });
        rValue.setInterpolator(new DecelerateInterpolator());
        rValue.start();
    }


    //圆形旋转
    protected void circleAnimator() {
        width = linearLayout.getWidth();
        height = linearLayout.getHeight();
        final int R = width / 4;
        ValueAnimator tValue = ValueAnimator.ofFloat(0, (float) (2.0f * Math.PI));
        tValue.setDuration(1000);
        tValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 圆的参数方程 x = R * sin(t) y = R * cos(t)
                float t = (Float) animation.getAnimatedValue();
                int x = (int) (R * Math.sin(t) + width / 2);
                int y = (int) (R * Math.cos(t) + height / 2);
                moveView(imageView, x, y);
            }
        });
        tValue.setInterpolator(new DecelerateInterpolator());
        tValue.start();
    }

}
