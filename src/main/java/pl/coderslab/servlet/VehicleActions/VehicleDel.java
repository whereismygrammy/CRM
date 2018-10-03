package pl.coderslab.servlet.VehicleActions;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VehicleDel", urlPatterns = "/vehicleDel")
public class VehicleDel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        VehicleDao.deleteVehicleById(vehicleId);

        String customerId = request.getParameter("customerId");
        request.setAttribute("customerId", customerId);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle_actions/vehicle_del.jsp").forward(request, response);
    }
}

