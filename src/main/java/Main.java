
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.*;
import pl.coderslab.utils.StatusWriter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static void main(String[] args) {


        List<Order> orderList = OrderDao.getOrdersByCustomerId(21);

        for (Order o : orderList) {
            System.out.println(o);
        }





    }
}
