 package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class FinalOutput extends AppCompatActivity {

     Toolbar toolbar;
     Button next;
     TextView text1,text2;
     String b,db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_output);
        toolbar = findViewById(R.id.actionbar1);
        next = findViewById(R.id.next);
        text1 = findViewById(R.id.decisonm);
        text2 = findViewById(R.id.meaning);
        Intent intent = getIntent();
        b = intent.getStringExtra("buy");
        db = intent.getStringExtra("de");
        text1.setText(b);
        text2.setText(db);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalOutput.this,Main2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
     public boolean onSupportNavigateUp(){
        finish();
        return true;
     }
}
