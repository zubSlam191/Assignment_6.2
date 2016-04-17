package com.emailprocessing.email.domain;

import java.util.Comparator;

/**
 * Created by student on 2016/04/04.
 */
public class ContactComparator implements Comparator<MailEntry> {
    @Override
    public int compare(MailEntry t0, MailEntry t1) {
        return t0.getContact().getAddress().compareTo(t1.getContact().getAddress());
    }
}
