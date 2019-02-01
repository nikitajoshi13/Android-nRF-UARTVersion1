package com.nordicsemi.nrfUARTv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Splash extends AppCompatActivity {

     String PREFS_NAME;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.mainAppTheme);
        setContentView(R.layout.activity_splash);

        PREFS_NAME= "MyPrefsFile";
        settings = getSharedPreferences(PREFS_NAME, 0);


        Thread t=new Thread() {
           public void run() {

                try {
                    sleep(10000);

                    //start new activity


                    if (settings.getBoolean("my_first_time", true)) {
                        //the app is being launched for first time, do something
                        Log.d("Comments", "First time");
                        // record the fact that the app has been started at least once
                        settings.edit().putBoolean("my_first_time", false).commit();
                        Intent i=new Intent(Splash.this,Frontpage.class);
                        startActivity(i);
                    }

                    else
                    {
                        Intent i=new Intent(Splash.this,MainActivity.class);
                        startActivity(i);
                    }

                    //destroying Splash activity
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

  //      start thread
        t.start();
  }
}
