package pl.coderslab.servlet.ClientsActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ClientList", urlPatterns = "/clientList")
public class ClientList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        List<Customer> allCustomer = CustomerDao.getAllCustomer();

        List<Customer> searchedCustomers = new ArrayList<>();

        for (Customer c : allCustomer) {
            System.out.println(c);

            Pattern pattern = Pattern.compile(search);
            Matcher matcher = pattern.matcher(c.getSurname());
            boolean find = matcher.find();

            if (find) {
                searchedCustomers.add(c);
            }
        }

        request.setAttribute("customers", searchedCustomers);
        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_list.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> allCustomer = CustomerDao.getAllCustomer();
        request.setAttribute("customers", allCustomer);
        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_list.jsp").forward(request, response);
    }
}