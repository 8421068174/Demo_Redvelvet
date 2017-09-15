package com.example.genekatechnologies2.readvwlvet.database;

/**
 * Created by Geneka Technologies2 on 7/9/2017.
 */

public class feedback_product {

    public static final String TABLE_PRODUCT_DETAILS = "Feedback_Product_Details";
    public static final String CL_feedback_id="feedback_id",CL_PRODUCT_VALUE="product_value";

    public static final String CREATE_FEEDBACK_PRODUCT_DETAILS="CREATE TABLE " + TABLE_PRODUCT_DETAILS + "("+CL_feedback_id+" TEXT)";

  private  long feedbackid;


    public long getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(long feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getProduct_VALUE() {
        return Product_VALUE;
    }

    public void setProduct_VALUE(String product_VALUE) {
        Product_VALUE = product_VALUE;
    }

   private String Product_VALUE;

}
