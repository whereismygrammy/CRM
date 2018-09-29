package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderAdd", urlPatterns = "/orderAdd")
public class orderAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployee = EmployeeDao.getAllEmployee();

        List<Vehicle> vehicles = VehicleDao.getAllVehicle();

        request.setAttribute("allEmployee", allEmployee);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("status", Status.values());

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_add.jsp").forward(request, response);
    }
}
