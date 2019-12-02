package com.example.android.fragmentdatasharing;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_layout, fragmentOne).addToBackStack(null).commit();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case (R.id.first_fragment):

                        if (!fragmentOne.isAdded()) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_layout, fragmentOne).commit();
                        }

                        break;

                    case (R.id.second_fragment):

                        if (!fragmentTwo.isAdded()) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_layout, fragmentTwo).commit();
                        }
                }

                return true;
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ItemID", bottomNavigationView.getSelectedItemId());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int selectedItemId = savedInstanceState.getInt("ItemID");
        bottomNavigationView.setSelectedItemId(selectedItemId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
