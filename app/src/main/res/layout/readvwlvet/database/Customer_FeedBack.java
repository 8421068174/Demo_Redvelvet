package com.example.genekatechnologies2.readvwlvet.database;

/**
 * Created by Geneka Technologies2 on 7/9/2017.
 */

public class Customer_FeedBack {


    public static final String TABLE_CUSTOMER_FEEDBACK = "Feedback_Table";
    public static final String CL_feedback_id="feedback_id",CL_DESCRIPTION="Description",cust_id="cust_Id",FEEDBACK_TIME="feedback_time",CL_STATUS="status",CL_CAKE="cake",CL_HOLL="holl",CL_FOOD="food",CL_SERVICE="services",CL_FOOD_QUILITY="food_quility",CL_CLEANLINESS="cleanliness",CL_VALUE_OF_MONEY="valueofmoney",CL_RESPONCETIME="responcetime";

    public static final String CL_CREATE_TABLE_CUSTOMER_FEEDBACK="CREATE TABLE " + TABLE_CUSTOMER_FEEDBACK + "("+CL_feedback_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CL_DESCRIPTION+" TEXT,"+cust_id+" TEXT,"+FEEDBACK_TIME+" TEXT,"+CL_STATUS+" TEXT,"+CL_CAKE+" TEXT,"+CL_HOLL+" TEXT,"+CL_FOOD+" TEXT,"+CL_SERVICE+" TEXT,"+CL_FOOD_QUILITY+" TEXT,"+CL_CLEANLINESS+" TEXT,"+CL_VALUE_OF_MONEY+" TEXT,"+CL_RESPONCETIME+" TEXT)";
    private int  status;
    private String description_value,cust_id_value,feedback_time,cake,food,holl;
    private long feedback_Id_Value;
    private float food_quility;
    private  float service;
    private float cleanliness;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getDescription_value() {
        return description_value;
    }
    public void setDescription_value(String description_value) {
        this.description_value = description_value;
    }
    public String getCust_id_value() {
        return cust_id_value;
    }
    public void setCust_id_value(String cust_id_value) {
        this.cust_id_value = cust_id_value;
    }
    public String getFeedback_time() {
        return feedback_time;
    }
    public void setFeedback_time(String feedback_time) {
        this.feedback_time = feedback_time;
    }
    public String getCake() {
        return cake;
    }
    public void setCake(String cake) {
        this.cake = cake;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getHoll() {
        return holl;
    }
    public void setHoll(String holl) {
        this.holl = holl;
    }
    public long getFeedback_Id_Value() {
        return feedback_Id_Value;
    }
    public void setFeedback_Id_Value(long feedback_Id_Value) {
       this.feedback_Id_Value = feedback_Id_Value;
   }
    public float getFood_quility() {
        return food_quility;
    }
    public void setFood_quility(float food_quility) {
        this.food_quility = food_quility;
    }
    public float getService() {
        return service;
    }
    public void setService(float service) {
        this.service = service;
    }
    public float getCleanliness() {
        return cleanliness;
    }
    public void setCleanliness(float cleanliness) {
        this.cleanliness = cleanliness;
    }
    public float getValueformoney() {
        return valueformoney;
    }
    public void setValueformoney(float valueformoney) {
        this.valueformoney = valueformoney;
    }
    public float getResponcetime() {
        return responcetime;
    }
    public void setResponcetime(float responcetime) {
        this.responcetime = responcetime;
    }
    private   float valueformoney;
   private   float responcetime;


}
