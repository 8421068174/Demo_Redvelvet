package com.example.genekatechnologies2.readvwlvet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Administrator on 05.04.2017.
 */

public class FeedBackHelper {
    public static boolean inserFeedBack(Context context, com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack feedback)
    {
        try
        {
            SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.cust_id,feedback.getCust_id_value());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.FEEDBACK_TIME, feedback.getFeedback_time());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_DESCRIPTION,feedback.getDescription_value());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_STATUS,"0");
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CAKE,feedback.getCake());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD,feedback.getFood());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_HOLL,feedback.getHoll());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD_QUILITY,feedback.getFood_quility());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_SERVICE,feedback.getService());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CLEANLINESS,feedback.getCleanliness());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_VALUE_OF_MONEY,feedback.getValueformoney());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_RESPONCETIME,feedback.getResponcetime());
            feedback.setFeedback_Id_Value((db.insert(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.TABLE_CUSTOMER_FEEDBACK, null, values)));
            if(feedback.getFeedback_Id_Value()>0)
            {
                return  true;
            }
            else
            {
                return  false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
  public static ArrayList<com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack> getUnuploadedFeddBackList(Context context) {
        ArrayList<com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack> array_list = new ArrayList<com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack>();
        SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.TABLE_CUSTOMER_FEEDBACK+" WHERE "+ com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_STATUS+"='0'",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack feedback = new com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack();
            feedback.setCust_id_value(cursor.getString(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.cust_id)));
            feedback.setFeedback_Id_Value(cursor.getLong(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_feedback_id)));
            feedback.setFeedback_time(cursor.getString(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.FEEDBACK_TIME)));
            feedback.setStatus(cursor.getInt(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_STATUS)));
            feedback.setCake(cursor.getString(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CAKE)));
            feedback.setFood(cursor.getString(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD)));
            feedback.setHoll(cursor.getString(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_HOLL)));
            feedback.setFood_quility(cursor.getFloat(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD_QUILITY)));
            feedback.setResponcetime(cursor.getFloat(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_RESPONCETIME)));
            feedback.setService(cursor.getFloat(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_SERVICE)));
            feedback.setCleanliness(cursor.getFloat(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CLEANLINESS)));
            feedback.setValueformoney(cursor.getFloat(cursor.getColumnIndex(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_VALUE_OF_MONEY)));
            array_list.add(feedback);
            cursor.moveToNext();
        }
        return array_list;
    }

public static boolean updateFeedBack(Context context, com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack feedback) {

        try
        {
            SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.cust_id,feedback.getCust_id_value());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.FEEDBACK_TIME, feedback.getFeedback_time());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_DESCRIPTION,feedback.getDescription_value());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_STATUS,"1");
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CAKE,feedback.getCake());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD,feedback.getFood());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_HOLL,feedback.getHoll());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_FOOD_QUILITY,feedback.getFood_quility());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_SERVICE,feedback.getService());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CLEANLINESS,feedback.getCleanliness());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_VALUE_OF_MONEY,feedback.getValueformoney());
            values.put(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_RESPONCETIME,feedback.getResponcetime());
            // upadating Row
            db.update(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.TABLE_CUSTOMER_FEEDBACK, values, com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_feedback_id+"="+feedback.getFeedback_Id_Value(), null);
            db.close(); // Closing database connection
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
