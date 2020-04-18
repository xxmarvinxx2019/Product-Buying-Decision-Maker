package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button next;
    Spinner decision;
    TextView text1;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        toolbar = findViewById(R.id.actionbar1);
        next = findViewById(R.id.next);
        decision = findViewById(R.id.decision);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Choose");
        arrayList.add("Yes");
        arrayList.add("No");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
        decision.setAdapter(arrayAdapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = decision.getSelectedItem().toString();
                if(s == "Yes") {
                    progress = new ProgressDialog(Main5Activity.this);
                    progress.show();
                    progress.setContentView(R.layout.progress_layout);
                    progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    progress.setCancelable(false);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progress.dismiss();
                            String b = "Buy";
                            String ss = "Based on your answer we recommend you to buy this product because it will be useful to you.";
                            Intent intent = new Intent(Main5Activity.this, FinalOutput.class);
                            intent.putExtra("buy",b);
                            intent.putExtra("de",ss);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    },2000);
                }else if(s == "No"){
                    Intent intent = new Intent(Main5Activity.this, Main10Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(s.equals("Choose")){
                    Toast.makeText(Main5Activity.this,"Please Choose one",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
