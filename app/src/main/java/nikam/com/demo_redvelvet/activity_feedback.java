package nikam.com.demo_redvelvet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class activity_feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actovity_feedback);
        FragmentManager fm = getFragmentManager();
        // add
        Fragment fragment= new FragmentMobileVerify();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragmentview,fragment);
        ft.commit();



    }
}
