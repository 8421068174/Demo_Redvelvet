package nikam.com.demo_redvelvet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Geneka Technologies2 on 7/9/2017.
 */

public class Customer_Table_Helper {


    public static boolean insertCustomer(Context context,Custumor_Table custumor)
    {
        try {
                SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Custumor_Table.CL_MOBILE, custumor.getMOBILE_VALUE());
                values.put(Custumor_Table.CL_FNAME, custumor.getFNAME_VALUE());
                values.put(Custumor_Table.CL_LNAME, custumor.getLNAME_VALUE());
                values.put(Custumor_Table.CL_DOB, custumor.getDOB_VALUE());
                values.put(Custumor_Table.ANIVERSARY_DATE, custumor.getAnivarsary_value());
                values.put(Custumor_Table.CL_OCUPETION, custumor.getOCUPETION_VALUE());
                values.put(Custumor_Table.CL_CITY, custumor.getCITY_VALUE());
                if (db.insert(Custumor_Table.TABLE_CUSTOMER, null, values) > 0)
                {
                    db.close();
                    return true;
                }
                else
                {
                    db.close();
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
}
public static Custumor_Table getCustomerdata(Context context,String Customer_mobile)
{
    SQLiteDatabase db = new DatabaseHandler(context).getWritableDatabase();
        // Cursor cursor = db.rawQuery("SELECT * FROM " + Message_Table.TABLE_MESSAGE, null);
    Cursor cursor = db.rawQuery("SELECT * FROM "+Custumor_Table.TABLE_CUSTOMER+" WHERE "+Custumor_Table.CL_MOBILE+"='"+Customer_mobile+"'",null);
    try
    {
            Custumor_Table customer = new Custumor_Table();
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false)
            {
                customer.setMOBILE_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_MOBILE)));
                customer.setFNAME_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_FNAME)));
                customer.setLNAME_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_LNAME)));
                customer.setDOB_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_DOB)));
                customer.setOCUPETION_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_OCUPETION)));
                customer.setCITY_VALUE(cursor.getString(cursor.getColumnIndex(Custumor_Table.CL_CITY)));
                customer.setAnivarsary_value(cursor.getString(cursor.getColumnIndex(Custumor_Table.ANIVERSARY_DATE)));
                return customer;
            }
            return null;
        }
        catch (Exception e)

        {
            return null;
        }

}

}
