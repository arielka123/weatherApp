package pl.weatherApp.model.utils;

import pl.weatherApp.model.objects.collections.DaysWeek;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateManager {
    private static String dayOfWeek;

    private static Date convertStringToDate(String strDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(strDate);
    }

    private static void setDayOfWeek(String strDate) throws ParseException {
        Date date = convertStringToDate(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek=DaysWeek.mapCodes(dayWeek);
    }

    public static String getDayOfWeek(String date) throws ParseException {
        DateManager.setDayOfWeek(date);
        return dayOfWeek;
    }

}
