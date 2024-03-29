package com.example.fragmenttugas;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fr=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   fr=new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    fr= new DashboardFragment();
                    break;
                case R.id.navigation_notifications:
                    fr= new NotifikasiFragment();
                    break;
                case R.id.navigation_profile:
                    fr= new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.nav_view,fr).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_view,new HomeFragment()).commit();
        }
    }

}
