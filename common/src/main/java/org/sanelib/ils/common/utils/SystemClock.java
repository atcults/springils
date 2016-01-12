package org.sanelib.ils.common.utils;

import java.util.Calendar;
import java.util.Date;

public class SystemClock implements Clock {

    @Override
    public Date now() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}