package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button with_petButton = (Button) findViewById(R.id.with_petButton);
        with_petButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent withpet = new Intent(MenuActivity.this, Withpet.class);
                MenuActivity.this.startActivity(withpet);
            }
        });

        Button find_loadButton = (Button) findViewById(R.id.find_loadButton);
        find_loadButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent Findload = new Intent(MenuActivity.this, Findload.class);
                MenuActivity.this.startActivity(Findload);
            }
        });

        Button recommendButton = (Button) findViewById(R.id.recommendButton);
        recommendButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent Board = new Intent(MenuActivity.this, Weathers.class);
                MenuActivity.this.startActivity(Board);
            }
        });


        Button boardButton = (Button) findViewById(R.id.boardButton);

        boardButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent main_intent = new Intent(MenuActivity.this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "로그아웃에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                MenuActivity.this.startActivity(main_intent);
            }
        });


    }
}