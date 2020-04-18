package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

public class EditActivity extends AppCompatActivity {

    Toolbar toolbar;
    DBHelper dbHelper;
    TextView fname,occupation;
    TextInputEditText t1,t2,t3,t4,t5;
    Button update;
    String id,name,occo,age,month,saving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dbHelper = new DBHelper(this);

        toolbar = findViewById(R.id.actionbar1);
        fname = findViewById(R.id.fsname);
        occupation = findViewById(R.id.occupations);
        update = findViewById(R.id.next);
        t1 = findViewById(R.id.fname);
        t2 = findViewById(R.id.age);
        t3 = findViewById(R.id.occupation);
        t4 = findViewById(R.id.savings);
        t5 = findViewById(R.id.salary);

        try(Cursor cursor = dbHelper.fetch()){
            cursor.moveToFirst();
            id  = cursor.getString(0);
            name = cursor.getString(1);
            age = cursor.getString(2);
            occo = cursor.getString(3);
            saving = cursor.getString(4);
            month = cursor.getString(5);

            fname.setText(name);
            occupation.setText(occo);
            t1.setText(name);
            t2.setText(age);
            t3.setText(occo);
            t4.setText(saving);
            t5.setText(month);

        }
        catch (Exception ex){
            return;
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updatedata = dbHelper.update(id,t1.getText().toString(),Integer.parseInt(t2.getText().toString()),t3.getText().toString(),Integer.parseInt(t4.getText().toString()),Integer.parseInt(t5.getText().toString()));
                if(updatedata == true){
                    Toast.makeText(EditActivity.this,"Update Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(EditActivity.this,Main2Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(EditActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
