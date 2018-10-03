package pl.coderslab.servlet.VehicleActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VehicleDetails", urlPatterns = "/vehicleDetails")
public class VehicleDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        Vehicle vehicle = VehicleDao.getVehicleById(vehicleId);
        request.setAttribute("vehicle", vehicle);

        List<Order> orders = OrderDao.getOrdersByVehicleId(vehicleId);
        request.setAttribute("orders", orders);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle_actions/vehicle_details.jsp").forward(request, response);

    }
}