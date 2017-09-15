package com.example.genekatechnologies2.readvwlvet.database;

/**
 * Created by Administrator on 04.04.2017.
 */

public class Custumor_Table {


    public static final String TABLE_CUSTOMER = "Customer_Table";
    public static final String CL_MOBILE="mobile_no",CL_FNAME="F_Name",CL_LNAME="L_name",CL_DOB="DOB",CL_CITY="city",ANIVERSARY_DATE="anivarsary_date",CL_OCUPETION="ocupetion";
    public static final String CREATE_Custumor_Table="CREATE TABLE " + TABLE_CUSTOMER + "("+CL_MOBILE+" TEXT,"+CL_FNAME+" TEXT,"+CL_LNAME+" TEXT,"+CL_DOB+" TEXT,"+CL_CITY+" TEXT,"+CL_OCUPETION+" TEXT,"+ANIVERSARY_DATE+" TEXT)";
    private String MOBILE_VALUE;
    private String FNAME_VALUE;
    private String DOB_VALUE;
    private String LNAME_VALUE;
    private String OCUPETION_VALUE;
    private String CITY_VALUE;

    public String getAnivarsary_value() {
        return Anivarsary_value;
    }

    public void setAnivarsary_value(String anivarsary_value) {
        Anivarsary_value = anivarsary_value;
    }

    private  String Anivarsary_value;


    public String getMOBILE_VALUE() {
        return MOBILE_VALUE;
    }

    public void setMOBILE_VALUE(String MOBILE_VALUE) {
        this.MOBILE_VALUE = MOBILE_VALUE;
    }

    public String getFNAME_VALUE() {
        return FNAME_VALUE;
    }

    public void setFNAME_VALUE(String FNAME_VALUE) {
        this.FNAME_VALUE = FNAME_VALUE;
    }

    public String getDOB_VALUE() {
        return DOB_VALUE;
    }

    public void setDOB_VALUE(String DOB_VALUE) {
        this.DOB_VALUE = DOB_VALUE;
    }

    public String getLNAME_VALUE() {
        return LNAME_VALUE;
    }

    public void setLNAME_VALUE(String LNAME_VALUE) {
        this.LNAME_VALUE = LNAME_VALUE;
    }

    public String getOCUPETION_VALUE() {
        return OCUPETION_VALUE;
    }

    public void setOCUPETION_VALUE(String ADDRESS_VALUE) {
        this.OCUPETION_VALUE = ADDRESS_VALUE;
    }

    public String getCITY_VALUE() {
        return CITY_VALUE;
    }

    public void setCITY_VALUE(String CITY_VALUE) {
        this.CITY_VALUE = CITY_VALUE;
    }
}
