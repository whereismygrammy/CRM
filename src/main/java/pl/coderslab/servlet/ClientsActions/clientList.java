package pl.coderslab.servlet.ClientsActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "clientList", urlPatterns = "/clientList")
public class clientList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> allCustomer = CustomerDao.getAllCustomer();
        request.setAttribute("customers", allCustomer);
        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_list.jsp").forward(request, response);
    }
}
