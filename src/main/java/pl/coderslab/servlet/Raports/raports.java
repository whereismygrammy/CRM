package pl.coderslab.servlet.Raports;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.TimeRaport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "raports", urlPatterns = "/raports")
public class raports extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raportStart = request.getParameter("raportStart");
        String raportEnd = request.getParameter("raportEnd");

        TimeRaport timeRaport = new TimeRaport(raportStart, raportEnd);
        timeRaport.setList();

        request.setAttribute("raport1", timeRaport.getList());
        getServletContext().getRequestDispatcher("/WEB-INF/views/raports/raports.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        TimeRaport timeRaport = new TimeRaport("1970-01-01", "2200-01-01");
        timeRaport.setList();
        request.setAttribute("raport1", timeRaport.getList());
        getServletContext().getRequestDispatcher("/WEB-INF/views/raports/raports.jsp").forward(request, response);
    }
}
