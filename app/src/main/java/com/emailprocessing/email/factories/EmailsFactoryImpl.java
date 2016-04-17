package com.emailprocessing.email.factories;

import com.emailprocessing.email.domain.Email;

/**
 * Created by student on 2016/04/04.
 */
public class EmailsFactoryImpl implements EmailsFactory {

    private static EmailsFactoryImpl factory = null;

    private  EmailsFactoryImpl() {
    }
    public static EmailsFactoryImpl getInstance(){
        if(factory ==null)
            factory = new EmailsFactoryImpl();
        return factory;
    }

    @Override
    public Email createEmail(String address, String description) {
        Email mail = new Email
                .Builder()
                .address(address)
                .description(description)
                .build();

        return mail;
    }
}
