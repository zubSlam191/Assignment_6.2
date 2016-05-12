package services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.ServiceTestCase;

import org.junit.Assert;

import com.emailprocessing.email.conf.util.App;
import com.emailprocessing.email.factories.EmailsFactoryImpl;
import com.emailprocessing.email.respository.settings.EmailsRespository;
import com.emailprocessing.email.services.emails.Impl.ConfirmSortingBusinessService;
import com.emailprocessing.email.services.emails.Impl.ConfirmSortingGmailService;
import com.emailprocessing.email.services.emails.Impl.ConfirmSortingOutlookService;
import com.emailprocessing.email.services.emails.Impl.EmailBoundService;
import com.emailprocessing.email.services.emails.Impl.EmailDeletedService;
import com.emailprocessing.email.services.emails.Impl.EmailFoundService;
import com.emailprocessing.email.services.emails.Impl.EmailSavedService;
import com.emailprocessing.email.services.emails.Impl.EmailsCountService;
import com.emailprocessing.email.services.emails.Impl.MailEntryAddService;
import com.emailprocessing.email.services.emails.SortService;


/**
 * Created by Zubair on 5/12/2016.
 */
public class Tests extends ServiceTestCase {

    private EmailBoundService activateService;
    private EmailsRespository emailRepo;
    private SortService sortService;

    private boolean isBound;


    public Tests() {
        super(ServiceTestCase.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EmailBoundService.ActivateServiceLocalBinder binder
                    = (EmailBoundService.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;

            String activate = activateService.addEmail(EmailsFactoryImpl.getInstance().createEmail("example@exmaple.com", "awd"));
            Assert.assertEquals("ACTIdfgdfgsVATED", activate);


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

   /* private ServiceConnection connection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            sortService.ActivateServiceLocalBinder binder
                    = (EmailBoundService.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;


            String activate = activateService.addEmail(EmailsFactoryImpl.getInstance().createEmail("example@exmaple.com", "awd"));
            Assert.assertEquals("ACTIdfgdfgsVATED", activate);


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };*/

    public void testIntentService() {
        Intent intent = new Intent(getContext(), ConfirmSortingBusinessService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }
    public void testIntentService2() {
        Intent intent = new Intent(getContext(), ConfirmSortingGmailService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }
    public void testIntentService3() {
        Intent intent = new Intent(getContext(), ConfirmSortingOutlookService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }

    public void testIntentService4() {
        Intent intent = new Intent(getContext(), EmailDeletedService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }
    public void testIntentService5() {
        Intent intent = new Intent(getContext(), EmailFoundService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }
    public void testIntentService6() {
        Intent intent = new Intent(getContext(), EmailSavedService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }

    public void testIntentService7() {
        Intent intent = new Intent(getContext(), EmailsCountService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }
    public void testIntentService8() {
        Intent intent = new Intent(getContext(), MailEntryAddService.class);
        startService(intent);
        Assert.assertNotNull(intent);
    }


}
