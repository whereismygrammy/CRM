
import pl.coderslab.dao.*;
import pl.coderslab.model.*;
import pl.coderslab.utils.StatusWriter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tests {

    public static void main(String[] args) {


//        CashRaport cashRaport = new CashRaport("2010-10-04", "2019-10-30");
//        cashRaport.setCash();

        System.out.println(getCurrentDate());




    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }


}
