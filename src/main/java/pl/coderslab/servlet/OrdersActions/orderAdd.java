package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
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
        Order order = createOrder(request);
        OrderDao.addOrUpdateOrder(order);
        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_added.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployee = EmployeeDao.getAllEmployee();

        List<Vehicle> vehicles = VehicleDao.getAllVehicle();

        request.setAttribute("allEmployee", allEmployee);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("status", Status.values());

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_add.jsp").forward(request, response);
    }

    public static Order createOrder(HttpServletRequest request) throws ServletException, IOException {
        String dateOfAcceptance = request.getParameter("dateOfAcceptance");
        String dateOfPlanedStart = request.getParameter("dateOfPlanedStart");
        String dateOfStart = request.getParameter("dateOfStart");
        int employeeId = Integer.parseInt(request.getParameter("employee"));
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        String status = request.getParameter("status");
        int vehicleId = Integer.parseInt(request.getParameter("vehicle"));
        double costForClient = Double.parseDouble(request.getParameter("costForClient"));
        double partsCost = Double.parseDouble(request.getParameter("partsCost"));
        int numberOfHours = Integer.parseInt(request.getParameter("numberOfHours"));
        Order order = new Order(dateOfAcceptance, dateOfPlanedStart, dateOfStart, employeeId, problemDescription, repairDescription, status, vehicleId, costForClient, partsCost, numberOfHours);
        return order;
    }
}
