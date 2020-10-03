package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Button bt1 = (Button) findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });
    }
    void open(View v){
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }
}
