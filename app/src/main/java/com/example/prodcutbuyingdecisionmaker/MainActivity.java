package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button enter;
    SharedPreferences sharedPreferences;
    Boolean firstTime;
    DBHelper dbHelper;
    int numrows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);

        enter = findViewById(R.id.enter);

        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);

        if(firstTime) {
            Cursor d = dbHelper.fetch();
            numrows = d.getCount();
            if(numrows == 0){
            enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        firstTime = false;
                        editor.putBoolean("firstTime", firstTime);
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                        startActivity(intent);
                        finish();
                }
            });
            }
            else{
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }

        }else{
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            finish();
        }
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

    }
}
