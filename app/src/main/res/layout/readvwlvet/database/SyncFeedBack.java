package com.example.genekatechnologies2.readvwlvet.database;

import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 05.04.2017.
 */

public class SyncFeedBack {
    public static String feedbackurl = "http://genekatechnologies.com/travel/api/requestinquiry.php";

    private static String createGetWithParams(Activity activity, String url, Map<String, String> params)
    {
        StringBuilder builder = new StringBuilder();
        for (String key : params.keySet())
        {
            Object value = params.get(key);
            if (value != null)
            {
                //value = URLEncoder.encode(String.valueOf(value),"utf-8");
                if (builder.length() > 0)
                    builder.append("&");
                builder.append(key).append("=").append(value);

            }else{

            }
        }

        return (url += "?" + builder.toString());
    }
    public static Boolean uploadFeedBack(final Activity activity, final com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack feddback)
    {
        StringRequest strReq = new StringRequest(Request.Method.POST, feedbackurl, new Response.Listener<String>() {
       @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject result=new JSONObject(response);
                    String message = result.getString("success");
                    if(message.equalsIgnoreCase("1"))
                    {
                        feddback.setStatus(1);
                        com.example.genekatechnologies2.readvwlvet.database.FeedBackHelper.updateFeedBack(activity,feddback);
                    }
                    else
                    {

                    }
                }
                catch (JSONException e)
                {

                }
            }
        }
                , new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

             //   Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("hotel_id","9975294782" );
                params.put("tab_id", "9975294782");
                params.put("",feddback.getHoll());
                params.put("",feddback.getFood());
                params.put("",feddback.getCake());
                params.put("", String.valueOf(feddback.getCleanliness()));
                params.put("", String.valueOf(feddback.getFood_quility()));
                params.put("", String.valueOf(feddback.getService()));
                params.put("", String.valueOf(feddback.getValueformoney()));
                params.put("", String.valueOf(feddback.getDescription_value()));
                params.put("", String.valueOf(feddback.getFeedback_time()));
                params.put("", String.valueOf(feddback.getResponcetime()));

             //   params.put("", String.valueOf(feddback.));
                com.example.genekatechnologies2.readvwlvet.database.Customer_Table_Helper.getCustomerdata(activity,feddback.getCust_id_value());
                params.put("","");
                com.example.genekatechnologies2.readvwlvet.database.Family_Table_Helper.getFamilyList(activity, String.valueOf(feddback.getFeedback_Id_Value()));
                params.put("","");

                return  params;
            }
        };
        MySingleton.getInstance(activity).addToRequestQueue(strReq);
        return null;
    }

    public static Boolean updateDiscount(final Activity activity)
    {
        StringRequest strReq = new StringRequest(Request.Method.POST, feedbackurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject result=new JSONObject(response);
                    String message = result.getString("success");
                    if(message.equalsIgnoreCase("1"))
                    {

                    }
                    else
                    {

                    }
                }
                catch (JSONException e)
                {

                }
            }
        }
                , new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                //   Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("hotelid","9975294782" );
              //  params.put("tab_id", "9975294782");
                return  params;
            }
        };
        MySingleton.getInstance(activity).addToRequestQueue(strReq);
        return null;
    }

}
