package com.nordicsemi.nrfUARTv2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Frontpage extends Activity {
    EditText e1,e2,e3;
    Button b1;
   // SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // prefs = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        e1= (EditText) findViewById(R.id.phn1);
        e2= (EditText) findViewById(R.id.phn2);
        e3= (EditText) findViewById(R.id.phn3);
//        final Boolean isFirstRun =// getSharedPreferences("PREFERENCE", MODE_PRIVATE)
//                prefs.getBoolean("isFirstRun", true);



        b1= (Button) findViewById(R.id.subbtn);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                if(s1.length()!=10)
                {
                    e1.setError("invalid phone number");
                }
                String s2=e2.getText().toString().trim();
                if(s2.length()!=10)
                {
                    e2.setError("invalid phone number");
                }
                String s3=e3.getText().toString().trim();
                if(s3.length()!=10)
                {
                    e3.setError("invalid phone number");
                }
                if(e1.getText().toString().trim().isEmpty()&& e2.getText().toString().trim().isEmpty()){
                    e1.setError("Please fill this field");
                    e2.setError("Please fill this field");

                }

                Intent intent=new Intent(Frontpage.this,MainActivity.class);
                intent.putExtra("ph1", s1);
                intent.putExtra("ph2", s2);
                intent.putExtra("ph3", s3);


//                if (isFirstRun) {
//                    //show sign up activity
//                    startActivity(intent);
//                    //Toast.makeText(MainActivity.this, "Run only once", Toast.LENGTH_LONG).show();
//                }
                startActivity(intent);
//                prefs.getPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).apply();
            }
        });
    }

}
