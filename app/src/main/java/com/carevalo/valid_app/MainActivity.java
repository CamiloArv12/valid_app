package com.carevalo.valid_app;

import android.content.Intent;
import android.os.Bundle;

import com.carevalo.valid_app.network.ApiAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Properties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    Properties prop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_info, R.id.navigation_artist)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void loadData(){
        prop = new Properties();
        prop.setProperty("api_key", "829751643419a7128b7ada50de590067");
        prop.setProperty("country", "spain");
        prop.setProperty("api_format", "json");
    }

}
