package com.emailprocessing.email.domain;

import java.util.ArrayList;

/**
 * Created by student on 2016/04/04.
 */
public class EmailContainer {
    private ArrayList<Email> emails;

    public void printAllEmails(){ for(Email email: emails){
        System.out.println(email.getDescription() + '\n');
    }}

}
