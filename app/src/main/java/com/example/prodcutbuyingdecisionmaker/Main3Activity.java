package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button next;
    Spinner decision;
    DBHelper dbHelper;
    ProgressDialog progress;
    int money,salary,savings,int10,int20,int30,int50,int1,int2,int3,int4,int5;
    String a,b,c,d,e,g,h,i,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbHelper = new DBHelper(this);

        try(Cursor cursor = dbHelper.fetch()){
            cursor.moveToFirst();
            salary = cursor.getInt(5);
            savings = cursor.getInt(4);
            money = salary+savings;
            int1 = money / 100 * 1;
            int2 = money / 100 * 2;
            int3 = money / 100 * 3;
            int4 = money / 100 * 4;
            int5 = money / 100 * 5;
            int10 = money / 100 * 10;
            int20 = money / 100 * 20;
            int30 = money / 100 * 30;
            int50 = money / 100 * 31;

        }
        catch (Exception ex){
            return;
        }

        toolbar = findViewById(R.id.actionbar1);
        next = findViewById(R.id.next);
        decision = findViewById(R.id.decision);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Choose");
        arrayList.add("Less than "+int1);
        arrayList.add("Less than "+int2);
        arrayList.add("Less than "+int3);
        arrayList.add("Less than "+int4);
        arrayList.add("Less than "+int5);
        arrayList.add("Less than "+int10);
        arrayList.add("Less than "+int20);
        arrayList.add("Less than "+int30);
        arrayList.add("More than "+int50);

        a = "Less than "+int1;
        b = "Less than "+int2;
        c = "Less than "+int3;
        d = "Less than "+int4;
        e = "Less than "+int5;
        g = "Less than " +int10;
        h = "Less than " +int20;
        i = "Less than " +int30;
        j = "More than " +int50;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
        decision.setAdapter(arrayAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = decision.getSelectedItem().toString();
                if(size.equals(a)||size.equals(b)||size.equals(c)||size.equals(d)||size.equals(e)||size.equals(g)||size.equals(h)||size.equals(i)) {
                    Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(size.equals(j)){
                    progress = new ProgressDialog(Main3Activity.this);
                    progress.show();
                    progress.setContentView(R.layout.progress_layout);
                    progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    progress.setCancelable(false);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progress.dismiss();
                            String b = "Don't Buy";
                            String mean = "Spending more than 30% of you're overall money is not a good decision to buy. We advice you to save more for you to be able to buy this in the near future.";
                            Intent intent = new Intent(Main3Activity.this, FinalOutput.class);
                            intent.putExtra("buy",b);
                            intent.putExtra("de",mean);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    },2000);

                }else if(size.equals("Choose")){
                    Toast.makeText(Main3Activity.this,"Please Choose one",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
