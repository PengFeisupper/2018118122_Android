package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NormalActivity",this.toString());
        setContentView(R.layout.normal_layout);
        Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

        startMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}