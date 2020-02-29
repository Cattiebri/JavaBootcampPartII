package lv.accenture.bootcamp.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExamples {

    public static void main(String[] args) throws ParseException {
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(0));

        Date currentDate = new Date();
        System.out.println("currentDate = " + currentDate);

        Date nextDayDate = new Date(System.currentTimeMillis() + (24 * 60* 60 * 1000));
        System.out.println("nextDayDate = " + nextDayDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String formatted = simpleDateFormat.format(nextDayDate);
        System.out.println("formatted = " + formatted);

        Date parsedDate = simpleDateFormat.parse(formatted);
        long timeMsec = parsedDate.getTime();

    }

}
