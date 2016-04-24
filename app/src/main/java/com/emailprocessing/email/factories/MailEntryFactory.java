package com.emailprocessing.email.factories;

import com.emailprocessing.email.domain.Contact;
import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.domain.MailEntry;

import java.util.Date;

/**
 * Created by Zubair on 4/22/2016.
 */
public class MailEntryFactory {

    private static MailEntryFactory factory = null;

    private  MailEntryFactory() {
    }
    public static MailEntryFactory getInstance(){
        if(factory ==null)
            factory = new MailEntryFactory();
        return factory;
    }

    public MailEntry createMailEntry(String title, Contact contact, boolean wasSent, Date date) {
        MailEntry mail = new MailEntry
                .Builder()
                .title(title)
                .contact(contact)
                .wasSent(wasSent)
                .date(date)
                .build();

        return mail;
    }
}
