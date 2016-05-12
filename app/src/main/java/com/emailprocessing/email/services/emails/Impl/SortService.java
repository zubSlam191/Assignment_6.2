package com.emailprocessing.email.services.emails.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.emailprocessing.email.conf.util.App;
import com.emailprocessing.email.domain.GMail;
import com.emailprocessing.email.domain.MailEntry;
import com.emailprocessing.email.factories.ContactFactory;
import com.emailprocessing.email.factories.EmailsFactoryImpl;
import com.emailprocessing.email.factories.MailEntryFactory;
import com.emailprocessing.email.respository.settings.EmailsRespository;
import com.emailprocessing.email.respository.settings.Impl.EmailsRespositoryImpl;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zubair on 5/12/2016.
 */
public class SortService extends Service {
    private static final String DEBUG_TAG = "" + "SortService";
    private static final String EXTRA_ADD = "com.emailprocessing.email.services.emails.Impl.extra.ADD";
    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private EmailsRespository repository = null;

    private static SortService service = null;

    public SortService() {
        repository = new EmailsRespositoryImpl(App.getAppContext());
    }

    public static SortService getInstance() {
        if (service == null)
            service = new SortService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return localBinder;
    }


    public String sortEmail() {
        try {
            GMail mail = (GMail) EmailsFactoryImpl.getInstance().createEmail("","");
            ArrayList<MailEntry> arr = null;
            arr.add(MailEntryFactory.getInstance().createMailEntry("test", ContactFactory.getInstance().createMailEntry("abcd", null, null), false, new Date(2016,2,11)));
            arr.add(MailEntryFactory.getInstance().createMailEntry("test2", ContactFactory.getInstance().createMailEntry("abacd", null, null), false, new Date(2013,2,11)));

            mail.setEntries(new ArrayList<MailEntry>());

            mail.sortMailByContact(mail);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "SORTED";
    }

    public class ActivateServiceLocalBinder extends Binder {
        public SortService getService() {
            return SortService.this;
        }
    }
}
