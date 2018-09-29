package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static pl.coderslab.servlet.OrdersActions.orderAdd.createOrder;

@WebServlet(name = "orderEdit", urlPatterns = "/orderEdit")
public class orderEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        Order order = createOrder(request);
        order.setId(orderId);

        OrderDao.addOrUpdateOrder(order);

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_added.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = OrderDao.getOrderById(orderId);
        List<Employee> allEmployee = EmployeeDao.getAllEmployee();
        List<Vehicle> vehicles = VehicleDao.getAllVehicle();

        request.setAttribute("allEmployee", allEmployee);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("status", Status.values());

        request.setAttribute("order", order);


        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_edit.jsp").forward(request, response);

    }
}
