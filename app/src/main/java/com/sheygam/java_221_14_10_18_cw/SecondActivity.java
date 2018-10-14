package com.sheygam.java_221_14_10_18_cw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Button btn = findViewById(R.id.start_main_btn);
//        btn.setVisibility(View.INVISIBLE);

        findViewById(R.id.start_main_btn)
                .setOnClickListener(v -> {
                    Intent intent = new Intent("my.first.action");
                    startActivity(intent);
                });

        findViewById(R.id.second_action_btn)
                .setOnClickListener(v -> {
                    Intent intent = new Intent("my.second.action");
                    Intent chooser = Intent.createChooser(intent,"Choice app!");
                    startActivity(chooser);
                });
    }
}
