package com.emailprocessing.email.domain;

import java.util.Comparator;

public class TitleComparator implements Comparator<MailEntry> {
    @Override
    public int compare(MailEntry t0, MailEntry t1) {
        return t0.getTitle().compareTo(t1.getTitle());
    }
}
