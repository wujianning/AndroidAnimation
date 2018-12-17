package com.wjn.androidanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.wjn.androidanimation.R;

/**
 * 补间动画
 */

public class CurationAnimationActivity extends AppCompatActivity {

    private Button btn_alpha;
    private Button btn_scale;
    private Button btn_tran;
    private Button btn_rotate;
    private Button btn_set;
    private ImageView imageView;
    private Animation an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curationanimation);

        imageView = findViewById(R.id.img_show);
        //透明度
        btn_alpha = findViewById(R.id.btn_alpha);
        btn_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                an = AnimationUtils.loadAnimation(CurationAnimationActivity.this, R.anim.anim_alpha);
                imageView.startAnimation(an);
                an.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d("TAG","补间动画开始！");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d("TAG","补间动画结束！");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d("TAG","补间动画重复！");
                    }
                });
            }
        });


        //缩放
        btn_scale = findViewById(R.id.btn_scale);
        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                an = AnimationUtils.loadAnimation(CurationAnimationActivity.this, R.anim.anim_scale);
                imageView.startAnimation(an);
            }
        });


        //位移
        btn_tran = findViewById(R.id.btn_tran);
        btn_tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                an = AnimationUtils.loadAnimation(CurationAnimationActivity.this, R.anim.anim_translate);
                imageView.startAnimation(an);
            }
        });


        //旋转
        btn_rotate = findViewById(R.id.btn_rotate);
        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                an = AnimationUtils.loadAnimation(CurationAnimationActivity.this, R.anim.anim_rotate);
                imageView.startAnimation(an);
            }
        });


        //组合
        btn_set = findViewById(R.id.btn_set);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                an = AnimationUtils.loadAnimation(CurationAnimationActivity.this, R.anim.anim_set);
                imageView.startAnimation(an);
            }
        });

    }
}
