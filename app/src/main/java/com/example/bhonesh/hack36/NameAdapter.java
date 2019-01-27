package com.example.bhonesh.hack36;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bhonesh on 25/1/19.
 */

public class NameAdapter extends ArrayAdapter<NameClass>{

    public NameAdapter(VolunteerSelection volunteerSelection, ArrayList<NameClass> nameClassArrayList)
    {
        super(volunteerSelection, 0, nameClassArrayList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.volunteer_item, parent, false);
        }

        NameClass currentName = getItem(position);

        TextView nameText = (TextView)listItemView.findViewById(R.id.volunteer_name);

        String name = currentName.getName();

        nameText.setText(name);

        return listItemView;
    }
}
