package com.example.genekatechnologies2.readvwlvet.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
        Context context;
    // Database Name
    public static final String DATABASE_NAME = "aura";

    // Contacts table name

    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(Custumor_Table.CREATE_Custumor_Table);
        db.execSQL(com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.CL_CREATE_TABLE_CUSTOMER_FEEDBACK);
        db.execSQL(com.example.genekatechnologies2.readvwlvet.database.Family_Table.CREATE_FEEDBACKTABLE);








    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS "+ Custumor_Table.TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS "+ com.example.genekatechnologies2.readvwlvet.database.Family_Table.TABLE_FAMIlY);
        db.execSQL("DROP TABLE IF EXISTS "+ com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack.TABLE_CUSTOMER_FEEDBACK);
        onCreate(db);
    }

}