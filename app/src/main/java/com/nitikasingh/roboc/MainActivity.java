package com.nitikasingh.roboc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

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

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
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
