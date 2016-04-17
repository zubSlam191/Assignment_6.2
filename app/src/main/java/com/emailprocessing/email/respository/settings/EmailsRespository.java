package com.emailprocessing.email.respository.settings;

import android.database.Cursor;

import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.Repository;

import java.util.ArrayList;

/**
 * Created by student on 2016/04/17.
 */
public interface EmailsRespository extends Repository<Email,Long> {

    public ArrayList<Cursor> getData(String Query);
}
