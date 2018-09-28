import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

import java.util.List;

public class Main {

    public static void main(String[] args) {


//        Vehicle vehicle = new Vehicle("Civic", "Honda", "2016", "KCH-134", "28-02-2018");
//        VehicleDao.addVehicle(vehicle);


//        Employee emp = new Employee("1","2","3","4","5", 2);
//        Employee emp2 = new Employee("Tom","Dom","3","4","5",10);
//        Employee emp3 = new Employee("Dom","Dom","3","4","5",11);
//
//        EmployeeDao.addOrUpdateEmployee(emp);
//        EmployeeDao.addOrUpdateEmployee(emp2);
//        EmployeeDao.addOrUpdateEmployee(emp3);


        List<Employee> allEmployee = EmployeeDao.getAllEmployee();

        for (Employee emp : allEmployee) {
            System.out.println(emp);
        }

        EmployeeDao.deleteById(2);

        System.out.println("----------------");


        allEmployee = EmployeeDao.getAllEmployee();

        for (Employee emp : allEmployee) {
            System.out.println(emp);
        }
    }


}
