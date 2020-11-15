package com.example.secondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.putExtra("data_return","Hello MainActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    public void onBackPressed(){
        Intent intent =new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}

