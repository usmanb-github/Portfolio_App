package com.example.portfolioapp;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS); //gets called before OnCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setHomeFragment();
        initPage();
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        getWindow().setEnterTransition(transition);
    }


    private void initPage() {
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
                         /*   DownloadManager downloadManager;
                            String exampleURL = "https://drive.google.com/file/d/1wIkIlNjBbfS5A57OcFnAB1GSlTlMabtH/view?usp=sharing";
                            File path = new File("file:///C:/Users/usman/Documents/PortfolioApp/doc/CV.docx");
                            downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(exampleURL));
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                            Long reference = downloadManager.enqueue(request); */
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVDownloadFragment()).commit();


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