package org.sanelib.ils.common.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    /** Pattern to use for String representation of Dates/Times. */
    private static final String dateTimeFormatPattern = "yyyy-MM-dd HH:mm:ss z";
    private static final String dateFormatPattern = "yyyy-MM-dd";

    public static Date fromDateTimeString(String dateTimeString) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        final LocalDate date = LocalDate.parse(dateTimeString, formatter);
        final ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date fromDateString(String dateString) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);
        final LocalDate date = LocalDate.parse(dateString, formatter);
        final ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static String toDateTimeString(Date dateTime){
        final Instant instant = dateTime.toInstant();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    public static String toDateString(Date date){
        final Instant instant = date.toInstant();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    public static Date constructDate(int year, int month, int day) {
        // Fill Test Created Date Property using TestDataHelper
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        cal.set( Calendar.HOUR_OF_DAY, 0 );
        cal.set( Calendar.MINUTE, 0 );
        cal.set( Calendar.SECOND, 0 );
        cal.set( Calendar.MILLISECOND, 0 );
        return cal.getTime();
    }
}
