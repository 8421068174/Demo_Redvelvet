package nikam.com.demo_redvelvet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import nikam.com.demo_redvelvet.database.Customer_Table_Helper;
import nikam.com.demo_redvelvet.database.Custumor_Table;


public class FragmentMobileVerify extends Fragment {
    String city;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootview=inflater.inflate(R.layout.fragment_fragment_mobile_verify,
                container, false);

        final EditText etmobile=(EditText)rootview.findViewById(R.id.etmobileno);
        final RadioGroup btnradiogroup=(RadioGroup)rootview.findViewById(R.id.btnradiogroup);
        Button btnnext=(Button)rootview.findViewById(R.id.btnNext);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (btnradiogroup.getCheckedRadioButtonId())
                {
                    case R.id.radiobtnyes:
                        city="Aurangabad";
                            break;

                    case R.id.radiobtnno:
                        city="no";
                        break;


                }
                if(city!=null)
                {

                    if (etmobile.getText().toString().length() == 10)
                    {

                        Custumor_Table customer = Customer_Table_Helper.getCustomerdata(getActivity(), etmobile.getText().toString());
                        if (customer == null)
                        {
                            FragmentManager fm = getFragmentManager();
                            Fragment fragment= Customer_Details.newInstance(etmobile.getText().toString(),city);
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragmentview,fragment);
                            ft.commit();

                        }
                        else
                        {
                            Fragment family_details=Family_details.newInstance(etmobile.getText().toString());
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.fragmentview,family_details);
                            ft.commit();
                        }
                    }
                    else
                    {
                        etmobile.setError("Please Enter 10 Digit mobile no");
                    }

                }
                else
                {

                    Toast.makeText(getActivity(),"Please Select your City..",Toast.LENGTH_LONG).show();
                }


            }
        });


        return rootview;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
