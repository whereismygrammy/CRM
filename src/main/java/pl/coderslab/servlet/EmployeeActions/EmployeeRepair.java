package pl.coderslab.servlet.EmployeeActions;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeRepair", urlPatterns = "/employeeRepair")
public class EmployeeRepair extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("empId"));

        System.out.println(empId);

        List<Order> ordersByEmploeerId = OrderDao.getActiveOrdersByEmploeerId(empId);

        for (Order o : ordersByEmploeerId) {
            System.out.println(o);
        }

        request.setAttribute("orders", ordersByEmploeerId);

        getServletContext().getRequestDispatcher("/WEB-INF/views/employee_actions/employee_repair.jsp").forward(request, response);


    }
}
