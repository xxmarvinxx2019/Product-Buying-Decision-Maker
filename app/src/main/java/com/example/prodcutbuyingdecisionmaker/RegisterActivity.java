package com.example.prodcutbuyingdecisionmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    Button personal;
    TextInputEditText e1,e2,e3,e4,e5;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);

        personal = findViewById(R.id.personal);
        e1 = findViewById(R.id.fname);
        e2 = findViewById(R.id.age);
        e3 = findViewById(R.id.occupation);
        e4 = findViewById(R.id.savings);
        e5 = findViewById(R.id.salary);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname,occupation;
                int age,savings,salary;

                if(e1.getText().toString().isEmpty()||e2.getText().toString().isEmpty()||e3.getText().toString().isEmpty()||e4.getText().toString().isEmpty()||e5.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Please fill-up this form",Toast.LENGTH_LONG).show();
                }
                else{
                    fname = e1.getText().toString();
                    age = Integer.parseInt(e2.getText().toString());
                    occupation = e3.getText().toString();
                    savings = Integer.parseInt(e4.getText().toString());
                    salary = Integer.parseInt(e5.getText().toString());

                    if(dbHelper.insert(fname,age,occupation,savings,salary)){
                        Intent intent = new Intent(RegisterActivity.this,Main2Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
