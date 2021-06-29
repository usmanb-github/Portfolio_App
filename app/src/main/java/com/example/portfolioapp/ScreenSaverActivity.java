package com.example.portfolioapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;
import android.text.format.DateUtils;
import android.transition.Explode;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.portfolioapp.MainActivity;
import com.example.portfolioapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScreenSaverActivity extends Activity {

    ConstantsTransition type;
    String toolbarTitle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screensaver);


        final IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, final Intent intent) {
                startActivity(new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        }, filter);

        new CountDownTimer(3000, 2000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ScreenSaverActivity.this);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra(ConstantsTransition.animation_type, ConstantsTransition.TransitionType.ExplodeJava);
                startActivity(intent, options.toBundle());
            }

        }.start();
    }

    private void explodeTransitionByCode() {

    }
}
