package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class InterestActivity extends AppCompatActivity {

    Button next;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        dbHelper = new DBHelper(this);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);

        next = findViewById(R.id.nextMain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    dbHelper.insert1(c1.getText().toString());
                    Toast.makeText(InterestActivity.this,"Save Successfuly",Toast.LENGTH_SHORT).show();
                }
                if(c2.isChecked()){
                    dbHelper.insert1(c2.getText().toString());
                }
                if(c3.isChecked()){
                    dbHelper.insert1(c3.getText().toString());
                }
                if(c4.isChecked()){
                    dbHelper.insert1(c4.getText().toString());
                }
                if(c5.isChecked()){
                    dbHelper.insert1(c5.getText().toString());
                }
                if(c6.isChecked()){
                    dbHelper.insert1(c6.getText().toString());
                }
                if(c7.isChecked()){
                    dbHelper.insert1(c7.getText().toString());
                }
                if(c8.isChecked()){
                    dbHelper.insert1(c8.getText().toString());
                }
                if(c9.isChecked()){
                    dbHelper.insert1(c9.getText().toString());
                }
                if(c10.isChecked()){
                    dbHelper.insert1(c10.getText().toString());
                }
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
    }
}
