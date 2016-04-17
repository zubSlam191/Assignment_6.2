package com.emailprocessing.email.factories;

import com.emailprocessing.email.domain.*;

/**
 * Created by student on 2016/04/04.
 */
public class EmailFactory {

    public static String getEmail(String value){
        Email chain = setupChain();
        return chain.handleRequest(value);
    }

    public static Email setupChain(){
        Email a = new BusinessMail();
        Email b = new GMail();
        Email c = new OutlookMail();
        a.setNextEmail(b);
        b.setNextEmail(c);
        return a;
    }
}
