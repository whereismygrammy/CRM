package pl.coderslab.servlet.Raports;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.CashRaport;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.TimeRaport;
import pl.coderslab.utils.CurrentDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

@WebServlet(name = "Raports", urlPatterns = "/raports")
public class Raports extends HttpServlet {
    final String TIME_START = "1970-01-01";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raportStart = request.getParameter("raportStart");
        String raportEnd = request.getParameter("raportEnd");

        TimeRaport timeRaport = new TimeRaport(raportStart, raportEnd);
        timeRaport.setList();

        CashRaport cashRaport = new CashRaport(raportStart, raportEnd);
        cashRaport.setCash();

        request.setAttribute("raportTimeCash", cashRaport);
        request.setAttribute("raport1", timeRaport.getList());
        getServletContext().getRequestDispatcher("/WEB-INF/views/raports/raports.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TimeRaport timeRaport = new TimeRaport(TIME_START, CurrentDate.getCurrentDate());
        timeRaport.setList();
        request.setAttribute("raport1", timeRaport.getList());

        CashRaport cashRaport = new CashRaport(TIME_START, CurrentDate.getCurrentDate());
        cashRaport.setCash();
        request.setAttribute("raportTimeCash", cashRaport);


        getServletContext().getRequestDispatcher("/WEB-INF/views/raports/raports.jsp").forward(request, response);
    }
}
