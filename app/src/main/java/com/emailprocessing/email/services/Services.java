package com.emailprocessing.email.services;

import java.util.Set;

/**
 * Created by Zubair on 5/11/2016.
 */

public interface Services<E, ID> {

    E findById(ID id);

    E save(E entity);

    Set<E> findAll();
}
