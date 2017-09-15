package nikam.com.demo_redvelvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import  nikam.com.demo_redvelvet.database.Family_Table;

import java.util.ArrayList;

/**
 * Created by Geneka Technologies2 on 7/15/2017.
 */

public class FamilyAdapter extends BaseAdapter {
      ArrayList<Family_Table> familylist;
    Context context;
    public FamilyAdapter(Context context, int resource,ArrayList<Family_Table> familyList) {
        //super(context, resource);
        this.familylist = familyList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return familylist.size();
    }

    @Override
    public Object getItem(int position) {
        return familylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoleder holder;
        Family_Table family=familylist.get(position);
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rowfamily, null);
            holder = new ViewHoleder();
            holder.nameofmenber = (TextView) convertView.findViewById(R.id.textName);
            holder.relation = (TextView) convertView.findViewById(R.id.relation);
            holder.dateofbirth=(TextView)convertView.findViewById(R.id.textbirthday);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHoleder) convertView.getTag();
        }
        holder.dateofbirth.setText(family.getDoB_value());
        holder.nameofmenber.setText(family.getName_value());

        holder.relation.setText(family.getRelation_value());
        return convertView;
    }

    private class ViewHoleder
    {
        TextView  nameofmenber,relation,dateofbirth;
    }
}
