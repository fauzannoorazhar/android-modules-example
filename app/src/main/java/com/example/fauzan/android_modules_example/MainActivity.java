package com.example.fauzan.android_modules_example;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * findViewById untuk object toolbar
         * setSupportActionBar untuk menset toolbar menjadi actionBar
         * Lihat juga AndroidManifest pada Activity Main (menggunakan theme without ActionBar)
         * */
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        /*
         * findViewById untuk object DrawerLayout
         * membuat object ActionBarDrawerToggle
         * */
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_main);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        /*
         * findViewById untuk object NavigationView
         * setNavigationItemSelectedListener Set a listener yang akan diberitahukan ketika menu di klik.
         * */
        NavigationView navigationView = findViewById(R.id.main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_dashboard:
                break;
            case R.id.menu_listview:
                startListViewActivity();
                break;
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_main);
        drawerLayout.closeDrawer(Gravity.START);

        return true;
    }

    /*
    * Fungsi ketika kondisi menu drawer terbuka, lalu tombol back di tekan, maka menu akan tertutup
    * */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_main);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void startListViewActivity() {
        Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
        startActivity(intent);
    }
}
