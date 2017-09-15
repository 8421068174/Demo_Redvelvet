package nikam.com.demo_redvelvet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Geneka Technologies2 on 7/20/2017.
 */

public class Family_Table_Helper {




    public static boolean inserFamily(Context context, Family_Table family_table)
    {
        try
        {
            SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
            ContentValues values = new ContentValues();


            values.put(Family_Table.CL_FNAME,family_table.getName_value());
            values.put(Family_Table.CL_DOB, family_table.getDoB_value());
            values.put(Family_Table.RELATION,family_table.getRelation_value());
            values.put(Family_Table.FEEDBACK_ID,family_table.getFeedback_value());




            // Inserting Row

           Long  i=db.insert(Family_Table.TABLE_FAMIlY, null,values);


            if(i>0)
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

    public static ArrayList<Family_Table> getFamilyList(Context context,String feedbackID) {
        ArrayList<Family_Table> array_list = new ArrayList<Family_Table>();
        //hp = new HashMap();
        SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
        // Cursor cursor = db.rawQuery("SELECT * FROM " + Message_Table.TABLE_MESSAGE, null);
        Cursor cursor = db.rawQuery("SELECT * FROM "+Family_Table.TABLE_FAMIlY+" WHERE "+Family_Table.FEEDBACK_ID+"='"+feedbackID+"'",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false)
        {
            Family_Table feedback = new Family_Table();
            feedback.setDoB_value(cursor.getString(cursor.getColumnIndex(Family_Table.CL_DOB)));
            feedback.setFeedback_value(cursor.getString(cursor.getColumnIndex(Family_Table.FEEDBACK_ID)));
            feedback.setName_value(cursor.getString(cursor.getColumnIndex(Family_Table.CL_FNAME)));
            feedback.setRelation_value(cursor.getString(cursor.getColumnIndex(Family_Table.RELATION)));
            array_list.add(feedback);
            cursor.moveToNext();
        }
        return array_list;
    }






}
