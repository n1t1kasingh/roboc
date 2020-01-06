package com.nitikasingh.roboc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();


        LinearLayout gallery=findViewById(R.id.gallery);
        LayoutInflater inflater=LayoutInflater.from(this);



        NavigationView nav_view=findViewById(R.id.nav_view);

        for(int i=0;i<6;i++) {
            View view = inflater.inflate(R.layout.item, gallery, false);
            TextView textView = view.findViewById(R.id.withText);
            textView.setText("Item" + i);



            gallery.addView(view);
        }
        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
            nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id= menuItem.getItemId();
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                if(id==R.id.abt_cor)
                {
                    Intent intent=new Intent(getApplicationContext(),AboutCorsit.class);
                    startActivity(intent);
                    finish();
                }

                else if(id==R.id.abtrobo)
                {
                    Intent intent=new Intent(getApplicationContext(),AboutRobocore.class);
                    startActivity(intent);
                    finish();
                }

                else if(id==R.id.events)
                {
                    Intent intent=new Intent(getApplicationContext(),Events.class);
                    startActivity(intent);
                    finish();
                }

                return true;

            }

        });

        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) ||super.onOptionsItemSelected(item);
    }
}
