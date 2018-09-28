import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

public class Main {

    public static void main(String[] args) {


        Customer customer = new Customer("Tomasz", "JavaAddTest", "1989-01-10");
        CustomerDao.addCustomer(customer);

        // TUTAJ są te błędne metody:
//
//        Vehicle vehicle = new Vehicle("Civic", "Honda", "2016", "KCH-134", "28-02-2018");
//        VehicleDao.addVehicle(vehicle);
    }

}
