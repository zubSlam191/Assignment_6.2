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
    private long id;

    public void testCreateReadUpdateDelete() throws Exception {
        EmailsRespository repo = new EmailsRespositoryImpl(this.getContext());

        Email createEmail = new Email
                .Builder()
                .address("example.com")
                .description("private account")
                .build();

        Email insertedEntity = repo.save(createEmail);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

       Email createEmailTwo = new Email
                .Builder()
                .address("examplTwo.com")
                .description("private account")
                .build();

        Email insertedEntityTwo  = repo.save(createEmailTwo);
        id = insertedEntityTwo.getId();
        Assert.assertNotNull(TAG + " CREATE", createEmailTwo);

        Email createEmailThree = new Email
                .Builder()
                .address("exampleThree.com")
                .description("private account")
                .build();

        Email insertedEntityThree = repo.save(createEmailThree);
        id = insertedEntityThree.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntityThree);

        //READ ALL
        Set<Email> settings = repo.findAll();

        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
       Email entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY " + "id = " + entity.getId() + "\n" + "address =  " + entity.getAddress() + "\n" + "desc = " + entity.getDescription(), entity);



        //UPDATE ENTITY
        Email updateEntity = new Email
                .Builder()
                .copy(entity)
                .description("different")
                .build();
        System.out.println(entity.getAddress() + " " + entity.getDescription() + "\n" + entity.getAddress() + " " + entity.getDescription());
        repo.update(updateEntity);
        Email newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","different",newEntity.getDescription());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Email deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        //DELETE ALL ENTITIES
        int rowsAfter = repo.deleteAll();
        settings = repo.findAll();
        int allRows = settings.size();
        Assert.assertEquals(TAG + " DELETE ALL ENTITIES",allRows, 0);

    }

}
