package com.example.galgotiacollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.galgotiacollege.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                startActivity(new Intent(this, DeveloperActivity.class));
                break;
            case R.id.navigation_video:
                gotoUrl("https://www.youtube.com/c/GateSmashers/playlists");
                break;

            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbookActivity.class));
                break;
            case R.id.navigation_website:
                gotoUrl("https://galgotiacollege.edu/");
                break;
            case R.id.navigation_share:
               try{
                   Intent i = new Intent(Intent.ACTION_SEND);
                   i.setType("text/plain");
                   i.putExtra(Intent.EXTRA_SUBJECT,"Galgotias College");
                   i.putExtra(Intent.EXTRA_TEXT,"https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/app%2Fapp-debug.apk?alt=media&token=f7b3f5ca-1019-4057-9618-c7281ad22ab9"+getApplicationContext().getPackageName());
                   startActivity(Intent.createChooser(i,"Share with"));
               }catch (Exception e){
                   Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
               }
                break;
        }
        return true;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
}