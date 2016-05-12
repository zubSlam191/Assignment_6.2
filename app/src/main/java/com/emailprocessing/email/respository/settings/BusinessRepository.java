package com.emailprocessing.email.respository.settings;

import android.database.Cursor;

import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.Repository;

import java.util.ArrayList;

/**
 * Created by Zubair on 5/12/2016.
 */
public interface BusinessRepository extends Repository<Email,Long> {

    public ArrayList<Cursor> getData(String Query);
}

