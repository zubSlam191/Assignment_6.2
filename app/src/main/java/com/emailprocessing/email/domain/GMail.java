package com.emailprocessing.email.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by student on 2016/04/04.
 */
public class GMail extends Email {
    @Override
    public void showEmailDetails() {

    }

    @Override
    public String handleRequest(String request){
        if(request == "private"){
            return "numerousNines@gmail.com";
        }else{
            if(nextEmail!=null){
                return nextEmail.handleRequest(request);
            }
            return "No Email";
        }
    }

    public void sortMailByContact(Email mail){

        System.out.println("Before Sorting:");
        printList(mail);

        ArrayList<MailEntry> mailList = mail.getEntries();

        Collections.sort(mailList, new ContactComparator());
        mail.setEntries(mailList);

        System.out.println("After Sorting:");
        printList(mail);
    }
}
