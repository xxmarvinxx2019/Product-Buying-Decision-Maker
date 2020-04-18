package com.example.prodcutbuyingdecisionmaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    ViewPager viewPager;
    Model1 adapter;
    List<Model> models;
    BottomAppBar bottom;
    DBHelper dbHelper;
    TextView name;
    BottomNavigationView b;

    FloatingActionButton buttonquery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHelper = new DBHelper(this);
        name = findViewById(R.id.name);
        b = findViewById(R.id.bottomnavigation);

        String fname;

        try(Cursor cursor = dbHelper.fetch()){
            cursor.moveToFirst();
            fname = cursor.getString(1);
            name.setText(fname);
        }
        catch (Exception ex){
            return;
        }

        models = new ArrayList<>();
        models.add(new Model(R.drawable.shop_opt3,"Always look for the right product read the description and promotion."));
        models.add(new Model(R.drawable.buy1_opt,"Buy the products that suits your wants and need."));
        models.add(new Model(R.drawable.save_money_opt3, "Always save money. Never buy a product that exceeds your purchase power. Save Save and Save"));
        models.add(new Model(R.drawable.cart_opt3, "Check all the information of the product that you want to buy."));

        adapter = new Model1(models,this);
        buttonquery = findViewById(R.id.buttonquery);
        bottom = findViewById(R.id.bottomapp);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);
        viewPager.setOffscreenPageLimit(1);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTasktimer(),5000,5000);

        buttonquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,ProductActivity.class);
                startActivity(intent);
            }
        });
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,EditActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        b.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.menuAbout:
                        openDialog();
                        break;
                }
                return true;
            }
        });

    }

    public class myTasktimer extends TimerTask{
        public void run(){
            Main2Activity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void openDialog(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        dialog1 dialog1 = new dialog1();
        dialog1.show(fragmentManager,"log");
    }
}
