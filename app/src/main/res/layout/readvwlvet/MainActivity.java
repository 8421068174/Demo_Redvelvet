package com.example.genekatechnologies2.readvwlvet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.example.genekatechnologies2.readvwlvet.database.PreferanceManager.setOffer(this,"20 % discount");


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run()
            {
  setContentView(R.layout.activity_coupon);
               Button btn=(Button) findViewById(R.id.btnNext);

                TextView offer=(TextView)findViewById(R.id.discountstring);
                offer.setText(com.example.genekatechnologies2.readvwlvet.database.PreferanceManager.getOffer(com.example.genekatechnologies2.readvwlvet.MainActivity.this));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(), com.example.genekatechnologies2.readvwlvet.activity_feedback.class);
                        startActivity(intent);

                    }
                });


                // close this activity

            }
        }, SPLASH_TIME_OUT);



    }
}
