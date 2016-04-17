package com.emailprocessing.email.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by student on 2016/04/04.
 */
public class BusinessMail extends Email  {

    private Forms businessForms;

    public BusinessMail() {
    }

    public void sortMailByDate(BusinessMail mail){

        System.out.println("Before Sorting:");
        printList(mail);

        ArrayList<MailEntry> mailList = mail.getEntries();

        Collections.sort(mailList, new DateComparator());
        mail.setEntries(mailList);

        System.out.println("After Sorting:");
        printList(mail);
    }

    @Override
    public void showEmailDetails() {

    }

    @Override
    public String handleRequest(String request){
        if(request == "business"){
            return "zuubear@yahoo.com";
        }else{
            if(nextEmail!=null){
                return nextEmail.handleRequest(request);
            }
            return "No Email";
        }
    }

}
