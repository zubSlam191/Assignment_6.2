package com.emailprocessing.email.services.emails.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.emailprocessing.email.conf.util.App;
import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.settings.EmailsRespository;
import com.emailprocessing.email.respository.settings.Impl.EmailsRespositoryImpl;

/**
 * Created by Zubair on 5/12/2016.
 */
public class EmailBoundService extends Service {
    private static final String DEBUG_TAG = "EmailBoundService";
    private static final String EXTRA_ADD = "com.emailprocessing.email.services.emails.Impl.extra.ADD";
    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private EmailsRespository repository = null;

    private static EmailBoundService service = null;

    public EmailBoundService() {
        repository = new EmailsRespositoryImpl(App.getAppContext());
    }

    public static EmailBoundService getInstance() {
        if (service == null)
            service = new EmailBoundService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {

        return localBinder;
    }



    public String addEmail(Email email) {
        try {
            repository.save(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "SAVED";
    }

    public class ActivateServiceLocalBinder extends Binder {
        public EmailBoundService getService() {
            return EmailBoundService.this;
        }
    }


}
