package nikam.com.demo_redvelvet;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by India on 29/08/2016.
 */
public abstract class CustomCalender extends Dialog implements View.OnClickListener
    {
        View tmpview,tmpviewday;
        boolean btnok1=false,btnok2=false;
        String day=null;
        int month_b1 = 0;
        int day_b1=0;
        String date="dd/mm/yy";
        Button jan,feb,march,april,may,june,july,aug,sep,oct,nov,dec,ok;
        Button d1,d2,d3,d4,d5,d8,d6,d7,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31;
        public Context c;
        public CustomCalender(Context context) {
        super(context);
            c=context;




    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.customcalender);
            initializeComponent();




        }

        private void initializeComponent()
       {

       //month
            jan=(Button)findViewById(R.id.jan);
            feb=(Button)findViewById(R.id.feb);
            march=(Button)findViewById(R.id.march);
            april=(Button)findViewById(R.id.april);
            may=(Button)findViewById(R.id.may);
            june=(Button)findViewById(R.id.june);
            july=(Button)findViewById(R.id.july);
            aug=(Button)findViewById(R.id.aug);
            sep=(Button)findViewById(R.id.sep);
            oct=(Button)findViewById(R.id.oct);
            nov=(Button)findViewById(R.id.nov);
            dec=(Button)findViewById(R.id.dec);

            jan.setOnClickListener(this);
            feb.setOnClickListener(this);
            march.setOnClickListener(this);
            april.setOnClickListener(this);
            may.setOnClickListener(this);
            june.setOnClickListener(this);
            july.setOnClickListener(this);
            aug.setOnClickListener(this);
            sep.setOnClickListener(this);
            oct.setOnClickListener(this);
            nov.setOnClickListener(this);
            dec.setOnClickListener(this);

           d1=(Button)findViewById(R.id.d1);
           d2 =(Button)findViewById(R.id.d2);
           d3 =(Button)findViewById(R.id.d3);
           d4 =(Button)findViewById(R.id.d4);
           d5 =(Button)findViewById(R.id.d5);
           d8 =(Button)findViewById(R.id.d8);
           d6 =(Button)findViewById(R.id.d6);
           d7 =(Button)findViewById(R.id.d7);
           d9 =(Button)findViewById(R.id.d9);
           d10=(Button)findViewById(R.id.d10);
           d11=(Button)findViewById(R.id.d11);
           d12=(Button)findViewById(R.id.d12);
           d13=(Button)findViewById(R.id.d13);
           d14=(Button)findViewById(R.id.d14);
           d15=(Button)findViewById(R.id.d15);
           d16=(Button)findViewById(R.id.d16);
           d17=(Button)findViewById(R.id.d17);
           d18=(Button)findViewById(R.id.d18);
           d19=(Button)findViewById(R.id.d19);
           d20=(Button)findViewById(R.id.d20);
           d21=(Button)findViewById(R.id.d21);

           d22=(Button)findViewById(R.id.d22);
           d23=(Button)findViewById(R.id.d23);
           d24=(Button)findViewById(R.id.d24);
           d25=(Button)findViewById(R.id.d25);
           d26=(Button)findViewById(R.id.d26);
           d27=(Button)findViewById(R.id.d27);
           d28=(Button)findViewById(R.id.d28);
           d29=(Button)findViewById(R.id.d29);
           d30=(Button)findViewById(R.id.d30);
           d31=(Button)findViewById(R.id.d31);

            d1.setOnClickListener(this);
           d2.setOnClickListener(this);
            d3.setOnClickListener(this);
            d4.setOnClickListener(this);
            d5.setOnClickListener(this);
            d6.setOnClickListener(this);
            d7.setOnClickListener(this);
            d8.setOnClickListener(this);
            d9.setOnClickListener(this);
            d10.setOnClickListener(this);
            d11.setOnClickListener(this);
            d12.setOnClickListener(this);
            d13.setOnClickListener(this);
           d14.setOnClickListener(this);
           d15.setOnClickListener(this);
           d16.setOnClickListener(this);
           d17.setOnClickListener(this);
           d18.setOnClickListener(this);
           d19.setOnClickListener(this);
           d20.setOnClickListener(this);
           d21.setOnClickListener(this);
           d22.setOnClickListener(this);
           d23.setOnClickListener(this);
           d24.setOnClickListener(this);
           d25.setOnClickListener(this);
           d26.setOnClickListener(this);
           d27.setOnClickListener(this);
           d28.setOnClickListener(this);
           d29.setOnClickListener(this);
           d30.setOnClickListener(this);
           d31.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            TextView tv_month=(TextView)findViewById(R.id.dd);

            switch(v.getId())
            {

                case R.id.jan:
                    day="Jan";
                    month_b1=1;
                    setBackgroundMonth(v);

                    break;
                case R.id.feb:
                    day="Feb";
                    month_b1=2;
                    setBackgroundMonth(v);
                    break;
                case R.id.march:
                    day="March";
                    month_b1=3;
                    setBackgroundMonth(v);
                    break;
                case R.id.april:
                    day="April";
                    month_b1=4;
                    setBackgroundMonth(v);
                    break;
                case R.id.may:
                    day="May";
                    month_b1=5;
                    setBackgroundMonth(v);
                    break;
                case R.id.june:
                    day="June";
                    month_b1=6;
                    setBackgroundMonth(v);
                    break;
                case R.id.july:
                    day="July";
                    month_b1=7;
                    setBackgroundMonth(v);
                    break;
                case R.id.aug:
                    day="August";
                    month_b1=8;
                    setBackgroundMonth(v);
                    break;
                case R.id.sep:
                    day="Sep";
                    setBackgroundMonth(v);
                    month_b1=9;
                    break;
                case R.id.oct:
                    day="Oct";
                    month_b1=10;
                    setBackgroundMonth(v);

                    break;
                case R.id.nov:
                    day="Nov";
                    month_b1=11;
                    setBackgroundMonth(v);
                    break;
                case R.id.dec:

                    month_b1=12;
                    day="Dec";
                    setBackgroundMonth(v);
                    break;

                case R.id.d1:
                    day_b1=1;
                    setBackgroundDay(v);
                    break;
                case R.id.d2:
                    day_b1=2;
                    setBackgroundDay(v);
                    break;
                case R.id.d3:
                    day_b1=3;
                    setBackgroundDay(v);
                    break;
                case R.id.d4:
                    day_b1=4;
                    setBackgroundDay(v);
                    break;
                case R.id.d5:
                    day_b1=5;
                    setBackgroundDay(v);
                    break;
                case R.id.d6:
                    day_b1=6;
                    setBackgroundDay(v);
                    break;
                case R.id.d7:
                    day_b1=7;
                    setBackgroundDay(v);
                    break;
                case R.id.d8:
                    day_b1=8;
                    setBackgroundDay(v);
                    break;
                case R.id.d9:
                    day_b1=9;
                    setBackgroundDay(v);
                    break;
                case R.id.d10:
                    day_b1=10;
                    setBackgroundDay(v);

                    break;
                case R.id.d11:
                    day_b1=11;
                    setBackgroundDay(v);
                    break;
                case R.id.d12:
                    day_b1=12;
                    setBackgroundDay(v);
                    break;
                case R.id.d13:
                    day_b1=13;
                    setBackgroundDay(v);
                    break;
                case R.id.d14:
                    day_b1=14;
                    setBackgroundDay(v);
                    break;
                case R.id.d15:
                    day_b1=15;
                    setBackgroundDay(v);
                    break;
                case R.id.d16:
                    day_b1=16;
                    setBackgroundDay(v);
                    break;
                case R.id.d17:
                    day_b1=17;
                    setBackgroundDay(v);
                    break;
                case R.id.d18:
                    day_b1=18;
                    setBackgroundDay(v);
                    break;
                case R.id.d19:
                    day_b1=19;
                    setBackgroundDay(v);

                    break;
                case R.id.d20:
                    day_b1=20;
                    setBackgroundDay(v);
                    break;
                case R.id.d21:
                    day_b1=21;
                    setBackgroundDay(v);
                    break;
                case R.id.d22:
                    day_b1=22;
                    setBackgroundDay(v);
                    break;
                case R.id.d23:
                    day_b1=23;
                    setBackgroundDay(v);
                    break;
                case R.id.d24:
                    day_b1=24;
                    setBackgroundDay(v);
                    break;

                case R.id.d25:
                    day_b1=25;
                    setBackgroundDay(v);
                    break;
                case R.id.d26:
                    day_b1=26;
                    setBackgroundDay(v);
                    break;
                case R.id.d27:
                    day_b1=27;
                    setBackgroundDay(v);
                    break;
                case R.id.d28:
                    day_b1=28;
                    setBackgroundDay(v);
                    break;
                case R.id.d29:
                    day_b1=29;
                    setBackgroundDay(v);

                    break;
                case R.id.d30:

                    day_b1=30;
                    setBackgroundDay(v);
                    break;
                case R.id.d31:
                    day_b1=31;
                    setBackgroundDay(v);
                    break;

            }
            tv_month.setText(day_b1+"/"+day);
            if(btnok2 && btnok1)
            {

                onDateSet(0000,month_b1,day_b1);
                dismiss();
            }



        }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
private void setBackgroundDay(View v)
{
    if(tmpviewday!=null)
    {
        tmpviewday.setBackgroundColor(c.getResources().getColor(R.color.btnBack));

    }
    v.setBackground(c.getResources().getDrawable(R.drawable.btnborder));
    tmpviewday=v;
    btnok2=true;

}
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
private void setBackgroundMonth(View v)
{

    if(tmpview!=null) {

        tmpview.setBackgroundColor(c.getResources().getColor(R.color.btnBack));

    }
    v.setBackground(c.getResources().getDrawable(R.drawable.btnborder));
    tmpview = v;
    btnok1 = true;


}
        public abstract void onDateSet(int year, int monthOfYear, int dayOfMonth);




    }