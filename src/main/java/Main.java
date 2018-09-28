import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import java.util.List;

public class Main {

    public static void main(String[] args) {




        //ReadCustomer Test
       Customer customer = CustomerDao.getCustomerById(2);
//        System.out.println(customer);
//
//        customer.setSurname("DUPA_WOŁOWA");

        //LoadAllCustomerTest
        List<Customer> customerList = CustomerDao.getAllCustomer();

        for (Customer c : customerList) {
            System.out.println(c);
        }

        CustomerDao.deleteCustomer(customer);

        customerList = CustomerDao.getAllCustomer();

        for (Customer c : customerList) {
            System.out.println(c);
        }



        //AddCustomer Test
//        Customer customer = new Customer("s", "Jav12aAddTest", "1989-03-10");
//        CustomerDao.addOrUpdateCustomer(customer);




        // TUTAJ są te błędne metody:
//
//        Vehicle vehicle = new Vehicle("Civic", "Honda", "2016", "KCH-134", "28-02-2018");
//        VehicleDao.addVehicle(vehicle);
    }

}
