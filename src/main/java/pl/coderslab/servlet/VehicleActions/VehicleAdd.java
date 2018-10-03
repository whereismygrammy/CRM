package pl.coderslab.servlet.VehicleActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VehicleAdd", urlPatterns = "/vehicleAdd")
public class VehicleAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String productionYear = request.getParameter("productionYear");
        String licensePlate = request.getParameter("licensePlate");
        String nextTechnicalInspection = request.getParameter("nextTechnicalInspection");
        Vehicle vehicle = new Vehicle(customerId, model, brand, productionYear, licensePlate, nextTechnicalInspection);
        VehicleDao.addVehicle(vehicle);
        request.setAttribute("customerId", customerId);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle_actions/vehicle_added.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");
        request.setAttribute("customerId", customerId);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle_actions/vehicle_add.jsp").forward(request, response);
    }
}

