package com.example.aditya.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    TextView textView;
    NavigationView nv;
    BottomNavigationView bottomNavigationView;
    TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this , mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = findViewById(R.id.mainText);
        bottomNavigationView = findViewById(R.id.navigation);
        textView1 = findViewById(R.id.textView1);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.camera:
                        textView1.setText("Camera Activity");
                        break;

                    case R.id.home1:
                        textView1.setText("Home");
                        break;
                    case R.id.profile:
                        textView1.setText("Your profile");
                        break;
                    case R.id.person:
                        textView1.setText("Add Your Friend");
                        break;
                    case R.id.setting:
                        textView1.setText("Settings");
                        break;


                }
                return true;
            }
        });
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.share:
                        textView.setText("Share");
                        break;
                    case R.id.settings:
                        textView.setText("Settings");
                        break;
                    case R.id.event:
                        textView.setText("Events");
                        break;
                    case R.id.db:
                        textView.setText("Dashboard");
                        break;
                    case R.id.activities:
                        textView.setText("Activities");
                        break;
                    case R.id.search:
                        textView.setText("Search");
                        break;
                    default:
                        return true;
                }
                return true;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



