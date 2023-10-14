package com.example.practivejavaandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practivejavaandroid.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name;
    private ImageButton back;

    void initView(Context context){
        image = findViewById(R.id.productDetailThumb);
        name = findViewById(R.id.productDetailName);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        Integer imagePara = intent.getIntExtra("image", 0);
        String namePara = intent.getStringExtra("name");
        // display the string into textView
        image.setImageResource(imagePara);
        name.setText(namePara);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView(getBaseContext());
    }
}