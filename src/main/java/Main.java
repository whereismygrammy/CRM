
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static void main(String[] args) {


//        Vehicle vehicle = new Vehicle("Civic", "Honda", "2016", "KCH-134", "28-02-2018");
//        VehicleDao.addVehicle(vehicle);


        LocalDate date = LocalDate.parse("2000-02-28");
        LocalDate date2 = LocalDate.parse("2000-02-13");


        long daysBetween = ChronoUnit.DAYS.between(date, date2);


        System.out.println(daysBetween);


    }
}
