package pl.coderslab.servlet.VehicleActions;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VehicleList", urlPatterns = "/vehicleList")
public class VehicleList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Vehicle> vehicleList = VehicleDao.getVehicleByCustomerId(id);
        request.setAttribute("vehicleList", vehicleList);
        request.setAttribute("customerId", id);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle_actions/vehicle_list.jsp").forward(request, response);

    }
}
