package com.emailprocessing.email.factories;


import com.emailprocessing.email.domain.Contact;

import java.util.Date;

/**
 * Created by Zubair on 4/22/2016.
 */
public class ContactFactory {

    private static ContactFactory factory = null;

    private  ContactFactory() {
    }
    public static ContactFactory getInstance(){
        if(factory ==null)
            factory = new ContactFactory();
        return factory;
    }

    public Contact createMailEntry(String address, String nickname, Date lastSeen) {
        Contact contact = new Contact
                .Builder()
                .address(address)
                .nickname(nickname)
                .lastSeen(lastSeen)
                .build();

        return contact;
    }
}
