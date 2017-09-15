package com.example.genekatechnologies2.readvwlvet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.genekatechnologies2.readvwlvet.database.Customer_FeedBack;
import com.example.genekatechnologies2.readvwlvet.database.Family_Table;
import com.example.genekatechnologies2.readvwlvet.database.FeedBackHelper;

import java.util.ArrayList;


public class FeedBack_Details extends Fragment
{
    private static final String ARG_MOBILE = "mobile";
    private String mobile;
    static ArrayList<Family_Table> familylist;
    private CheckBox holl,food,cake;
    private RatingBar service,food_quility,cleanliness,value_of_money,response_time;
    private Button submit;
    private AutoCompleteTextView textAutocompleteView;
    private static final String[] SUGGSTIONS = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };


    public FeedBack_Details() {
        // Required empty public constructor
    }
    public static com.example.genekatechnologies2.readvwlvet.FeedBack_Details newInstance(String mobile, ArrayList<Family_Table> param2) {
        com.example.genekatechnologies2.readvwlvet.FeedBack_Details fragment = new com.example.genekatechnologies2.readvwlvet.FeedBack_Details();
        Bundle args = new Bundle();
        com.example.genekatechnologies2.readvwlvet.FeedBack_Details.familylist=param2;
        args.putString(ARG_MOBILE, mobile);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mobile = getArguments().getString(ARG_MOBILE);
       }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        final View  rootview=inflater.inflate(R.layout.fragment_feed_back__details, container, false);
        holl=(CheckBox)rootview.findViewById(R.id.holl);
        food=(CheckBox)rootview.findViewById(R.id.food);
        cake=(CheckBox)rootview.findViewById(R.id.cake);
        service=(RatingBar)rootview.findViewById(R.id.service);
        food_quility=(RatingBar)rootview.findViewById(R.id.food_quility);
        response_time=(RatingBar)rootview.findViewById(R.id.response_time);
        cleanliness=(RatingBar)rootview.findViewById(R.id.cleanliness);
        value_of_money=(RatingBar)rootview.findViewById(R.id.value_for_moeny);
        textAutocompleteView=(AutoCompleteTextView) rootview.findViewById(R.id.customer_occupation);
        submit=(Button)rootview.findViewById(R.id.btnNext);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, SUGGSTIONS);
        textAutocompleteView.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Customer_FeedBack feedback=new Customer_FeedBack();
                feedback.setHoll(holl.isChecked()+"");
                feedback.setFood(food.isChecked()+"");
                feedback.setCake(cake.isChecked()+"");
                feedback.setService(service.getRating());
                feedback.setFood_quility(food_quility.getNumStars());
                feedback.setResponcetime(response_time.getRating());
                feedback.setCleanliness(cleanliness.getRating());
                feedback.setValueformoney(value_of_money.getRating());
                feedback.setDescription_value(textAutocompleteView.getText().toString());
                feedback.setCust_id_value(mobile);
                if(FeedBackHelper.inserFeedBack(getActivity(),feedback))
                {
                    for (Family_Table family:familylist)
                    {
                        family.setFeedback_value(String.valueOf(feedback.getFeedback_Id_Value()));
                        com.example.genekatechnologies2.readvwlvet.database.Family_Table_Helper.inserFamily(getActivity(),family);
                    }
                    familylist=new ArrayList<Family_Table>();
                    FragmentManager fm = getFragmentManager();
                    Fragment fragment= ThankYou.newInstance();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentview,fragment);
                    ft.commit();
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(),"Error in feedback",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootview;
    }
}
