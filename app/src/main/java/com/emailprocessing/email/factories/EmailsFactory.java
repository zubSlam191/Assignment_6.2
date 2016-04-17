package com.emailprocessing.email.factories;

import com.emailprocessing.email.domain.Email;

/**
 * Created by student on 2016/04/04.
 */
public interface EmailsFactory  {
    Email createEmail(String address, String description);
}
