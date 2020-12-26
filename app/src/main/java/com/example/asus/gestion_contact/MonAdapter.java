package com.example.asus.gestion_contact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    Context c;
    ArrayList<Contact>d;
    public MonAdapter(Context c, ArrayList<Contact> d) {
        this.c=c;
        this.d=d;
    }

    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(c);
        tv.setText(d.get(position).toString());
        return tv;
    }
}
