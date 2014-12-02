package com.quantumfin.daori.contactlist;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by daori on 12/2/14.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    private int rowView;
    private Activity activity;
    private List<Contact> items;
    private Contact contact;

    public ContactAdapter(Activity act, int row, List<Contact> items) {
        super(act, row, items);
        this.activity = act;
        this.rowView = row;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if(view == null){
                        LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(rowView, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((items == null) || ((position + 1) > items.size())) {
            return view;
        }

        contact = items.get(position);

        holder.contactName = (TextView) view.findViewById(R.id.contact_name);
        holder.contactNumber= (TextView) view.findViewById(R.id.contact_phone_number);

        if(holder.contactName != null && contact.getContactName() != null &&
                contact.getContactName().trim().length() > 0){
            holder.contactName.setText(Html.fromHtml(contact.getContactName()));
        }

        if(holder.contactNumber != null && contact.getContactPhoneNumber() != null &&
                contact.getContactPhoneNumber().trim().length() > 0){
            holder.contactNumber.setText(Html.fromHtml(contact.getContactPhoneNumber()));
        }

        return view;
    }

    public class ViewHolder {
        public TextView contactName, contactNumber;
    }
}
