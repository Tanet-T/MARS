package com.mars.submission.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.LocalDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {

    public static Date getCurrentDate() {

        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTimeToDate(localDateTime);
    }

    // Convert Joda-Time LocalDateTime to java.util.Date
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        DateTime dateTime = localDateTime.toDateTime();
        return dateTime.toDate();
    }
}