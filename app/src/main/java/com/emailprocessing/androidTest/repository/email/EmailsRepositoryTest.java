package com.emailprocessing.androidTest.repository.email;

import android.test.AndroidTestCase;
import junit.framework.Assert;

import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.settings.Impl.EmailsRespositoryImpl;
import com.emailprocessing.email.respository.settings.EmailsRespository;

import java.util.Set;

/**
 * Created by student on 2016/04/17.
 */
public class EmailsRepositoryTest extends AndroidTestCase {
    private static final String TAG="EMAILS TEST";
    private String id;

    public void testCreateReadUpdateDelete() throws Exception {
        EmailsRespository repo = new EmailsRespositoryImpl(this.getContext());

        Email createEmail = new Email
                .Builder()
                .address("asfd@gmail.com")
                .description("private account")
                .build();

        Email insertedEntity = repo.save(createEmail);
        id = insertedEntity.getAddress();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Email> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
       Email entity = repo.findByAddress(id);
        System.out.println(entity.getAddress().toString());
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Email updateEntity = new Email
                .Builder()
                .copy(entity)
                .description("different")
                .build();
        repo.update(updateEntity);
        Email newEntity = repo.findByAddress(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TEST487",newEntity.getDescription());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Email deletedEntity = repo.findByAddress(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
