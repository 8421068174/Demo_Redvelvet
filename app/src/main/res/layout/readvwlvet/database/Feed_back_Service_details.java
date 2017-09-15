package com.example.genekatechnologies2.readvwlvet.database;

/**
 * Created by Geneka Technologies2 on 7/9/2017.
 */

public class Feed_back_Service_details {


    public static final String TABLE_SERVICE_DETAILS = "Feedback_service_Details";
    public static final String CL_feedback_id="feedback_id",CL_ATRIBUTE_ID="attribute_id",Attribute_VAlue="attribute_value";
    public static final String CREATE_FEEDBACK_SERVICE_DETAILS="CREATE TABLE " + TABLE_SERVICE_DETAILS + "("+CL_feedback_id+" TEXT,"+CL_ATRIBUTE_ID+" TEXT,"+Attribute_VAlue+" TEXT)";



    long feedback_idvalue;
    String attribute_Value;

    public long getFeedback_idvalue() {
        return feedback_idvalue;
    }

    public void setFeedback_idvalue(long feedback_idvalue) {
        this.feedback_idvalue = feedback_idvalue;
    }

    public String getAttribute_Value() {
        return attribute_Value;
    }

    public void setAttribute_Value(String attribute_Value) {
        this.attribute_Value = attribute_Value;
    }

    public String getAttribute_Id() {
        return attribute_Id;
    }

    public void setAttribute_Id(String attribute_Id) {
        this.attribute_Id = attribute_Id;
    }

    String attribute_Id;

}
