package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.fragment.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;

    DrawerLayout drawerLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();

        setEvent();

    }

    private void setEvent() {

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Fragment_home());
        binding.idbottomNavigation.setSelectedItemId(R.id.menu_tap3);
        binding.idbottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.menu_tap1:
                    replaceFragment(new Fragment_order());
                    break;
                case R.id.menu_tap2:
                    replaceFragment(new Fagment_profile());
                    break;
                case R.id.menu_tap3:

                    replaceFragment(new Fragment_home());

                    break;
                case R.id.menu_tap4:
                    replaceFragment(new Fragment_wishlist());
                    break;
                case R.id.menu_tap5:
                    replaceFragment(new Fragment_cart());
                    break;

            }

                return true;
        });

//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        binding.toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
//        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_drawer, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.Edit_profile) {
//          replaceFragment(new Edit_profile());
//        }
//        else if(id == R.id.Transaction_history)
//        {
//            replaceFragment(new Transaction_history());
//        }
//        else if (id == R.id.Logout){
//            finish();
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }

    private void setControl() {
//        drawerLayout = findViewById(R.id.iddrawer);
        toolbar = findViewById(R.id.toolbar);

        bottomNavigationView = findViewById(R.id.idbottomNavigation);

    }
    private void replaceFragment(Fragment fragment)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }

//    @Override
//    public void onBackPressed() {
//        if(binding.iddrawer.isDrawerOpen(GravityCompat.START))
//        {
//            binding.iddrawer.closeDrawer(GravityCompat.START);
//        }
//        super.onBackPressed();
//    }
}