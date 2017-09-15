package nikam.com.demo_redvelvet;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import  nikam.com.demo_redvelvet.database.Family_Table;

import java.util.ArrayList;
import java.util.Calendar;

public class Family_details extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_MOBILE = "mobileno";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mobileno;
    private String mParam2;
    private ListView listView;
    private Button btnaddnew;
    private Button next;
    private ArrayList<Family_Table> familylist= new ArrayList<Family_Table>();
    public Family_details() {
     }
    // TODO: Rename and change types and number of parameters
    public static Family_details newInstance(String mobile) {
        Family_details fragment = new Family_details();
        Bundle args = new Bundle();
        args.putString(ARG_MOBILE, mobile);
 //       args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mobileno = getArguments().getString(ARG_MOBILE);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_family_details, container, false);
        listView=(ListView)rootview.findViewById(R.id.familymemberlist);
        btnaddnew=(Button)rootview.findViewById(R.id.btnskip);
        Button btnadd=(Button)rootview.findViewById(R.id.btnaddfab);
        btnaddnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment feedBack_details=FeedBack_Details.newInstance(mobileno,familylist);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentview,feedBack_details);
                ft.commit();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(getActivity());
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.addfamilyinfo);
                Button no = (Button) dialog1.findViewById(R.id.cancle);
                Button yes = (Button) dialog1.findViewById(R.id.ok);
                final TextView name=(TextView) dialog1.findViewById(R.id.customer_name);
                final Button customer_dob=(Button) dialog1.findViewById(R.id.customer_dob);
                final Spinner relation=(Spinner) dialog1.findViewById(R.id.relation);
                relation.setPrompt("Relation...");
                dialog1.show();
                customer_dob.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        CustomCalender cal= new CustomCalender(getActivity()) {
                            @Override
                            public void onDateSet(int year, int monthOfYear, int dayOfMonth) {
                                customer_dob.setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                            }
                        };

                        cal.show();
                    }
                });
                relation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=true;
                        Family_Table person=new Family_Table();
                        if(name.getText().toString().equalsIgnoreCase(""))
                        {
                            result=false;
                            name.setError("Enter Name...");
                        }
                        if (customer_dob.getText().toString().equalsIgnoreCase(""))
                        {
                            result=false;
                            customer_dob.setError("select Birth Date");
                        }
                        if(result)
                        {
                            person.setName_value(name.getText().toString());
                            person.setDoB_value(customer_dob.getText().toString());
                            person.setRelation_value(relation.getSelectedItem().toString());
                            familylist.add(person);
                            FamilyAdapter  adapter=new FamilyAdapter(getActivity(),R.layout.rowfamily,familylist);
                            listView.setAdapter(adapter);
                            btnaddnew.setText("Next");
                            dialog1.dismiss();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    dialog1.dismiss();
                    }
                });
            }
        });

        return rootview;
    }
    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        Button view;
        SelectDateFragment(Button view)
        {
            this.view=view;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        private void populateSetDate(int year, int month, int day) {
            view.setText(month+"/"+day+"/"+year);
        }

    }

 }
