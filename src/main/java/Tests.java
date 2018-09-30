
import pl.coderslab.dao.*;
import pl.coderslab.model.*;
import pl.coderslab.utils.StatusWriter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tests {

    public static void main(String[] args) {


        CashRaport cashRaport = new CashRaport("2010-10-04", "2019-10-30");
        cashRaport.setCash();


    }


}
