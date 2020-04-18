package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button next;
    Spinner decision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        toolbar = findViewById(R.id.actionbar1);
        next = findViewById(R.id.next);
        decision = findViewById(R.id.decision);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Choose");
        arrayList.add("Yes, I have one working properly");
        arrayList.add("Yes, I have one but its old");
        arrayList.add("Yes, I have one but its broken");
        arrayList.add("No, I don't own one");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
        decision.setAdapter(arrayAdapter);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String de = decision.getSelectedItem().toString();
                if(de == "Yes, I have one working properly") {
                    Intent intent = new Intent(Main4Activity.this, Main8Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(de == "Yes, I have one but its old"){
                    Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if(de == "Yes, I have one but its broken"){
                    Intent intent = new Intent(Main4Activity.this, Main6Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(de == "No, I don't own one"){
                    Intent intent = new Intent(Main4Activity.this, Main7Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(de == "Choose"){
                    Toast.makeText(Main4Activity.this,"Please Select one",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
