package com.example.genekatechnologies2.readvwlvet;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.genekatechnologies2.readvwlvet.database.Customer_Table_Helper;
import com.example.genekatechnologies2.readvwlvet.database.Custumor_Table;

public class Customer_Details extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String MOBILE_NO = "mobile";
    private static final String CITY = "city";

    // TODO: Rename and change types of parameters
    private String mobile_No,city;
    Custumor_Table customer;
    int buttonidentifier=0;
    EditText customer_name,customer_occupation;
    Button customer_anivarsary,customer_DOB;
    int year_b,month_b,day_b;
    public Customer_Details() {
        



    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Customer_Details.
     */
    // TODO: Rename and change types and number of parameters
    public static com.example.genekatechnologies2.readvwlvet.Customer_Details newInstance(String mobile_no, String city) {
        com.example.genekatechnologies2.readvwlvet.Customer_Details fragment = new com.example.genekatechnologies2.readvwlvet.Customer_Details();
        Bundle args = new Bundle();

        args.putString(MOBILE_NO, mobile_no);
        args.putString(CITY,city);

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mobile_No = getArguments().getString(MOBILE_NO);

            city = getArguments().getString(CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview=inflater.inflate(R.layout.fragment_customer__details, container, false);
        customer=new Custumor_Table();

        customer_name=(EditText) rootview.findViewById(R.id.customer_name);
        customer_DOB=(Button) rootview.findViewById(R.id.customer_dob);
        customer_anivarsary=(Button) rootview.findViewById(R.id.dateofanivarsary);
        customer_occupation=(EditText)rootview.findViewById(R.id.customer_occupation);
        Button btnNext=(Button)rootview.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(getCustomerData())
        {
   if( Customer_Table_Helper.insertCustomer(getActivity(),customer))
   {
       Fragment family_details=Family_details.newInstance(mobile_No);
       FragmentTransaction ft = getFragmentManager().beginTransaction();
       ft.replace(R.id.fragmentview,family_details);

       ft.commit();



   }
   else
    {

    }


}



            }
        });
        customer_DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonidentifier=1;

                CustomDatePickerDialog cl = new CustomDatePickerDialog(getActivity());
                cl.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                cl.show();
            }
        });

        customer_anivarsary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonidentifier=0;

                CustomDatePickerDialog cl = new CustomDatePickerDialog(getActivity());
                cl.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                cl.show();
            }
        });














        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event

    boolean getCustomerData()
    {

        boolean result=true;
        if(customer_name.getText().toString().length()>=0)
        {
            customer.setFNAME_VALUE(customer_name.getText().toString());
        }
        else
        {
            customer_name.setError("Please Enter Name");
            result=false;
        }
        if(customer_occupation.getText().toString().length()>=0)
        {
            customer.setOCUPETION_VALUE(customer_occupation.getText().toString());
        }
        else
        {
            customer_occupation.setError("Please Enter Name");
            result=false;
        }
        if(customer_DOB.getText().toString().equalsIgnoreCase(""))
        {
            result=false;
        }
        else
        {
             customer.setDOB_VALUE(customer_DOB.getText().toString());
        }
        if(customer_anivarsary.getText().toString().equalsIgnoreCase(""))
        {

            result=false;
        }
        else
        {

            customer.setAnivarsary_value(customer_anivarsary.getText().toString());
        }
        customer.setCITY_VALUE(city);
        customer.setMOBILE_VALUE(mobile_No);
return result;



    }

    class CustomDatePickerDialog extends CustomCalender
    {

        public CustomDatePickerDialog(Context context) {
            super(context);
        }

        @Override
        public void onDateSet(int year, int monthOfYear, int dayOfMonth)
        {

            year_b=year;
            month_b=monthOfYear;
            day_b=dayOfMonth;


            Integer month_b1=(monthOfYear);
            if(buttonidentifier==0)
            {
                customer_anivarsary.setText(day_b+"/"+month_b1+"/"+year_b);
            }
            else
            {
                customer_DOB.setText(day_b+"/"+month_b1+"/"+year_b);
            }

        }

    }



}
