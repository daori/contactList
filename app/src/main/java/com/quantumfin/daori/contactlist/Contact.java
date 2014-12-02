package com.quantumfin.daori.contactlist;

import android.widget.Adapter;

/**
 * Created by daori on 12/2/14.
 */
public class Contact {
    private String contactName;
    private String contactPhoneNumber;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
