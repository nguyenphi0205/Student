package com.example.nguyenphi.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nguyenphi on 19/04/2017.
 */

public class studentadapter extends BaseAdapter {
    Context contet;
    List<Student> list;

    public studentadapter(Context contet, List<Student> list) {
        this.contet = contet;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater lay = (LayoutInflater) contet.getSystemService(contet.LAYOUT_INFLATER_SERVICE);
            convertView = lay.inflate(R.layout.item_student, parent, false);

        }
        TextView lblID=(TextView) convertView.findViewById(R.id.lblID);
        TextView lblname=(TextView) convertView.findViewById(R.id.lblName);
        TextView lblemail=(TextView) convertView.findViewById(R.id.lblEmail);
        Student st=list.get(position);
        lblID.setText(st.getId());
        lblname.setText(st.getName());
        lblemail.setText(st.getEmail());
        return convertView;
    }


}
