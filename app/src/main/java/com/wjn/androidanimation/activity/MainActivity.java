package com.wjn.androidanimation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wjn.androidanimation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1=findViewById(R.id.activity_main_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FrameAnimationActivity.class);
                startActivity(intent);
            }
        });

        TextView textView2=findViewById(R.id.activity_main_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CurationAnimationActivity.class);
                startActivity(intent);
            }
        });

        TextView textView3=findViewById(R.id.activity_main_textview3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AttributeAnimationActivity.class);
                startActivity(intent);
            }
        });

    }
}
