package pl.coderslab.servlet.EmployeeActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeDel", urlPatterns = "/employeeDel")
public class EmployeeDel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int delId = Integer.parseInt(request.getParameter("id"));
        EmployeeDao.deleteById(delId);
        getServletContext().getRequestDispatcher("/WEB-INF/views/employee_actions/employee_del.jsp").forward(request, response);

    }
}
