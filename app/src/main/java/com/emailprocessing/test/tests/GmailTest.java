package com.emailprocessing.test.tests;

import com.emailprocessing.email.factories.EmailFactory;
import com.emailprocessing.email.factories.EmailsFactory;
import com.emailprocessing.email.factories.EmailsFactoryImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Zubair on 4/17/2016.
 */
public class GmailTest {
    EmailsFactory factory;

    @BeforeMethod
    public void setUp() throws Exception {
        factory = EmailsFactoryImpl.getInstance();
    }

    @Test
    public void testTestEmail() throws Exception {
        String email = EmailFactory.getEmail("private");
        System.out.println("The Address is " + email);

    }
}
