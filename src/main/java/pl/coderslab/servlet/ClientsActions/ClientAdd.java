package pl.coderslab.servlet.ClientsActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ClientAdd", urlPatterns = "/clientAdd")
public class ClientAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("birthday");

        Customer customer = new Customer(firstname, lastname, date);
        CustomerDao.addOrUpdateCustomer(customer);

        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_added.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_add.jsp").forward(request, response);

    }
}
