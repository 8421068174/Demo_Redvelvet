package nikam.com.demo_redvelvet.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by India on 09/04/2017.
 */
public class PreferanceManager {

    private static final String MyPREFERENCES = "MyPrefs";

    private static String COMPANYNAME="companyName",
                            OFFICE_ID="offfice_id",
                            OFFER="offer";

    public static void CreateLogin(Activity activity, String Office_ID)
    {
        SharedPreferences sharedpreferences =activity.
                getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedpreferences.edit();


        editor.putString(OFFICE_ID, Office_ID);


        editor.commit();


    }

    public  static  void setOffer(Activity activity,String offer)
    {
        SharedPreferences sharedpreferences =activity.
                getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(OFFER, offer);
        editor.commit();
    }

    public  static  String getOffer(Activity activity)
    {
        SharedPreferences sharedpreferences =activity.
                getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(OFFER, null);
       //return "";
    }




}
