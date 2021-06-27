package com.example.portfolioapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.dreams.DreamService;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView menuRV;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setHomeFragment();
        
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.page_1:
                            setHomeFragment();
                            return true;
                        case R.id.page_2:
                            setPortfolioFragment();
                            return true;
                        case R.id.page_3:
                            setCVFragment();
                            return true;
                        case R.id.page_4:
                            DownloadManager downloadManager;
                            String exampleURL = "https://drive.google.com/file/d/1wIkIlNjBbfS5A57OcFnAB1GSlTlMabtH/view?usp=sharing";
                            File path = new File("file:///C:/Users/usman/Documents/PortfolioApp/doc/CV.docx");
                            downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(exampleURL));
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                            Long reference = downloadManager.enqueue(request);
                            return true;
                        case R.id.page_5:
                            setBlogFragment();
                            return true;
                        default:
                            setHomeFragment();
                    }
                    return false;
                });
    }



    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_Home()).commit();
    }

    void setPortfolioFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setBlogFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new BlogFragment()).commit();
    }
}