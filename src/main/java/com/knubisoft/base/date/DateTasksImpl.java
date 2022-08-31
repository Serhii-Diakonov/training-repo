package com.knubisoft.base.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String dateString) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        return date.plusDays(1).toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.
                ofPattern("EEE, dd MMM yyyy", Locale.ENGLISH));
        return localDate.getMonthValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt1 = LocalDateTime.parse(date1, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(date2, formatter);
        LocalDateTime dt3 = LocalDateTime.parse(date3, formatter);
        return getBiggestDateTime(dt1, getBiggestDateTime(dt2, dt3)).format(formatter);
    }

    private LocalDateTime getBiggestDateTime(LocalDateTime dt1, LocalDateTime dt2){
        return dt1.compareTo(dt2) > 0 ? dt1 : dt2;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate dt = LocalDate.parse(date);
        return dt.with(lastDayOfMonth()).toString();
    }

    @Override
    public String sumTimes(String time1, String time2) {
        LocalTime tm1 = LocalTime.parse(time1, DateTimeFormatter.ISO_TIME);
        LocalTime tm2 = LocalTime.parse(time2, DateTimeFormatter.ISO_TIME);
        tm1 = tm1.plusHours(tm2.getHour());
        tm1 = tm1.plusMinutes(tm2.getMinute());
        tm1 = tm1.plusSeconds(tm2.getSecond());
        return tm1.format(DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        return LocalDate.parse(date).plusWeeks(2).toString();
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        return -1;
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        return null;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        return -1;
    }
}
