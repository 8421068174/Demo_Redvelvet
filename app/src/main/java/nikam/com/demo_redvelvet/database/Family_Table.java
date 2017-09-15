package nikam.com.demo_redvelvet.database;

/**
 * Created by Geneka Technologies2 on 7/9/2017.
 */

public class Family_Table {

    public static final String TABLE_FAMIlY = "Family_Table";
    public static final String CL_FNAME="F_Name",CL_DOB="DOB",RELATION="ralation",FEEDBACK_ID="feedback_id";

    public static final String CREATE_FEEDBACKTABLE="CREATE TABLE " + TABLE_FAMIlY + "("+CL_FNAME+" TEXT,"+CL_DOB+" TEXT,"+RELATION+" TEXT,"+FEEDBACK_ID+" TEXT)";

String name_value;
    String DoB_value;
    String relation_value;

    public String getName_value() {
        return name_value;
    }

    public void setName_value(String name_value) {
        this.name_value = name_value;
    }

    public String getDoB_value() {
        return DoB_value;
    }

    public void setDoB_value(String doB_value) {
        DoB_value = doB_value;
    }

    public String getRelation_value() {
        return relation_value;
    }

    public void setRelation_value(String relation_value) {
        this.relation_value = relation_value;
    }

    public String getFeedback_value() {
        return feedback_value;
    }

    public void setFeedback_value(String feedback_value) {
        this.feedback_value = feedback_value;
    }

    String feedback_value;



}
