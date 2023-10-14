package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.fragment.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    BottomNavigationView bottomNavigationView;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FragmentManager fragmentManager;

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.idDrawer);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.idbottomNavigation);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.id_navigationview);

        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setBackground(null);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               int idItem = item.getItemId();
               if(idItem == R.id.menu_tap1)
               {
                   openFragment(new Fragment_order());
                   Log.d("d", String.valueOf(fragmentManager.getBackStackEntryCount()));
                   return true;
               }
                else if(idItem == R.id.menu_tap2)
                {
                    openFragment(new Fagment_profile());
                    return true;
                }
               else if(idItem == R.id.menu_tap3)
                {
                    openFragment(new Fragment_home());
                    return true;
                }
                else if(idItem == R.id.menu_tap4)
                {
                    openFragment(new Fragment_wishlist());
                    return true;
                }
               else if(idItem == R.id.menu_tap5)
               {
                   openFragment(new Fragment_cart());
                   return true;
               }
                return false;
            }
        });
        fragmentManager = getSupportFragmentManager();

        openFragment(new Fragment_home());

        bottomNavigationView.setSelectedItemId(R.id.menu_tap3);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();
        if(idItem == R.id.Edit_profile){
            openFragment(new Edit_profile());
            bottomNavigationView.setVisibility(View.GONE);
            toolbar.setTitle("Bla");
            Log.d("d", String.valueOf(fragmentManager.getBackStackEntryCount()));
        }
        else if(idItem == R.id.Transaction_history)
        {
            openFragment(new Transaction_history());
            bottomNavigationView.setVisibility(View.GONE);
            Log.d("d", String.valueOf(fragmentManager.getBackStackEntryCount()));
        }
        else if(idItem == R.id.Logout)
        {
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.Edit_profile){
            openFragment(new Fragment_home());
            return true;
        }
        else if (itemID == R.id.Transaction_history)
        {
            openFragment(new Fragment_home());
            return true;
        }

        // Xử lý các sự kiện khác ở đây nếu cần

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else {

           super.onBackPressed();
            bottomNavigationView.setVisibility(View.VISIBLE);
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}