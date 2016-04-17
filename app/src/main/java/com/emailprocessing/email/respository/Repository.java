package com.emailprocessing.email.respository;

import com.emailprocessing.email.domain.Email;

import java.util.Set;

/**
 * Created by student on 2016/04/17.
 */
public interface Repository<E, ID> {

    Email findByAddress(String Address);

    Email save(Email entity);

    Email update(Email entity);

    Email delete(Email entity);

    Set<Email> findAll();

    int deleteAll();
}
