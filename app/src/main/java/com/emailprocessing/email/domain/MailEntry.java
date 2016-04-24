package com.emailprocessing.email.domain;

import com.emailprocessing.email.factories.MailEntryFactory;

import java.util.Date;

/**
 * Created by student on 2016/04/04.
 */
public class MailEntry {
    String title;
    Contact contact;
    boolean wasSent;
    Date date;

    private MailEntry(Builder value) {
        this.title = value.title;
        this.contact = value.contact;
        this.wasSent = value.wasSent;
        this.date = value.date;
    }

    public MailEntry() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean isWasSent() {
        return wasSent;
    }

    public void setWasSent(boolean wasSent) {
        this.wasSent = wasSent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Builder{
        String title;
        Contact contact;
        boolean wasSent;
        Date date;

        public Builder title(String value){
            this.title = value;
            return this;
        }

        public Builder contact(Contact value){
            this.contact = value;
            return this;
        }

        public Builder wasSent(boolean value){
            this.wasSent = value;
            return this;
        }

        public Builder date(Date value){
            this.date = value;
            return this;
        }

        public Builder copy(MailEntry value) {
            this.title = value.getTitle();
            this.contact = value.getContact();
            this.wasSent = value.isWasSent();
            this.date = value.getDate();
            return this;
        }

        public MailEntry build() {
            return new MailEntry(this) {
            };
        }
    }
}
