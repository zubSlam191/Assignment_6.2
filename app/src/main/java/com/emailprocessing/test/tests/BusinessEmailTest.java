package com.emailprocessing.test.tests;

import com.emailprocessing.email.domain.BusinessMail;
import com.emailprocessing.email.domain.Contact;
import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.domain.MailEntry;
import com.emailprocessing.email.factories.EmailFactory;
import com.emailprocessing.email.factories.EmailsFactory;
import com.emailprocessing.email.factories.EmailsFactoryImpl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zubair on 4/17/2016.
 */
public class BusinessEmailTest {
    EmailsFactory factory;

    @BeforeMethod
    public void setUp() throws Exception {
        factory = EmailsFactoryImpl.getInstance();
    }

    @Test
    public void testTestEmail() throws Exception {
        String email = EmailFactory.getEmail("business");
        System.out.println("The Address is " + email);

    }

    @Test
    public void testEmailUpdate() throws Exception {
        Email email = factory.createEmail("giantYetiMeme@aol.net", "System Administrator");
        Assert.assertEquals(email.getDescription(), "System Administrator");

        Email updateEmail = new Email.Builder()
                .copy(email)
                .description("Giant Yeti")
                .build();

        Assert.assertEquals(updateEmail.getDescription(), "Giant Yeti");
    }

    @Test
    public void testBusinessSort() throws Exception {

        ArrayList<MailEntry> emails = new ArrayList<>();
        BusinessMail business = new BusinessMail();
        MailEntry a = new MailEntry();
        MailEntry b = new MailEntry();
        a.setTitle("Batman97");
        a.setContact(new Contact("55nd Street", "RDaws", new Date(2007, 11, 5)));
        emails.add(a);
        b.setTitle("Joker06");
        b.setContact(new Contact("Avenue X", "Harvey", new Date(2003, 5, 3)));
        emails.add(b);

        business.setEntries(emails);

        business.sortMailByDate(business);

        Assert.assertEquals(business.getEntries().get(1).getContact().toString(), new Contact("55nd Street", "RDaws", new Date(2007, 11, 5)).toString());

    }
}
