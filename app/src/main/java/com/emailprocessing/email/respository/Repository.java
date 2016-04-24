package com.emailprocessing.email.respository;

import com.emailprocessing.email.domain.Email;

import java.util.Set;

/**
 * Created by student on 2016/04/17.
 */
public interface Repository<E, ID> {

    E findById(long id);

    E save(Email entity);

    E update(Email entity);

    E delete(Email entity);

    Set<E> findAll();

    int deleteAll();
}
