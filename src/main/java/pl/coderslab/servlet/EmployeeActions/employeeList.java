package pl.coderslab.servlet.EmployeeActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeList", urlPatterns = "/employeeList")
public class employeeList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployee = EmployeeDao.getAllEmployee();
        request.setAttribute("employeers", allEmployee);

        getServletContext().getRequestDispatcher("/WEB-INF/views/employee_actions/employee_list.jsp").forward(request, response);
    }
}
