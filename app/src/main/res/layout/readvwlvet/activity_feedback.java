package com.example.genekatechnologies2.readvwlvet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.genekatechnologies2.readvwlvet.R;

public class activity_feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actovity_feedback);
        FragmentManager fm = getFragmentManager();
        // add
        Fragment fragment= new com.example.genekatechnologies2.readvwlvet.FragmentMobileVerify();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragmentview,fragment);
        ft.commit();




    }
}
