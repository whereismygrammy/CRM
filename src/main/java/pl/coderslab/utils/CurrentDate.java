package pl.coderslab.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
