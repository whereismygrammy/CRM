
import pl.coderslab.dao.*;
import pl.coderslab.model.*;
import pl.coderslab.utils.StatusWriter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static void main(String[] args) {


        TimeRaport timeRaport = new TimeRaport("1000-10-01", "2020-02-02");
        timeRaport.setList();

        for (String[] arr : timeRaport.getList()) {
            System.out.println(arr[0] + " " + arr[1]);
        }

    }
}
