package com.emailprocessing.email.domain;

import java.util.Comparator;

/**
 * Created by student on 2016/04/04.
 */
public class DateComparator implements Comparator<MailEntry> {
    @Override
    public int compare(MailEntry t0, MailEntry t1) {

        System.out.println(t0.getTitle()+" "+t1.getTitle());
        if (t0.getContact().getLastSeen() == null || t1.getContact().getLastSeen() == null)
            return 0;
        return t0.getContact().getLastSeen().compareTo(t1.getContact().getLastSeen());
    }
}

