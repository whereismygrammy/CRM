package pl.coderslab.servlet.Raports;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "raportsMain", urlPatterns = "/raportsMain")
public class raportsMain extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployee = EmployeeDao.getAllEmployee();
        request.setAttribute("employeers", allEmployee);


        // TO JEST TO JEBANE QUERY ++++++++
        String sql = "select employee.id, name, surname, sum(numberOfHours) from orders join employee on orders.employee_id = employee.id where dateOfStart > \"1000-10-01\" and dateOfStart < \"2020-02-02\"  GROUP BY employee.id ;s";

        getServletContext().getRequestDispatcher("/WEB-INF/views/raports/raports.jsp").forward(request, response);
    }
}
