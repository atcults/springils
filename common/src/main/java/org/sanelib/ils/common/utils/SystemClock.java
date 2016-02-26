package org.sanelib.ils.common.utils;

import java.util.Calendar;
import java.util.Date;

public class SystemClock implements Clock {

    @Override
    public Date now() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    @Override
    public Date today() {
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.HOUR_OF_DAY, 0 );
        cal.set( Calendar.MINUTE, 0 );
        cal.set( Calendar.SECOND, 0 );
        cal.set( Calendar.MILLISECOND, 0 );

        return cal.getTime();
    }
}