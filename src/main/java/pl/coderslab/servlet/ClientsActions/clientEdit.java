package pl.coderslab.servlet.ClientsActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "clientEdit", urlPatterns = "/clientEdit")
public class clientEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("birthday");
        int id= Integer.parseInt(request.getParameter("id"));

        Customer customer = new Customer(firstname, lastname, date);
        customer.setId(id);
        CustomerDao.addOrUpdateCustomer(customer);

        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_edited.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Customer customer = CustomerDao.getCustomerById(id);

        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_edit.jsp").forward(request, response);

    }
}
