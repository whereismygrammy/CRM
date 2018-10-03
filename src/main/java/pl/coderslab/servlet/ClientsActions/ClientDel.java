package pl.coderslab.servlet.ClientsActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientDel", urlPatterns = "/clientDel")
public class ClientDel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int delId = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomerById(delId);
        getServletContext().getRequestDispatcher("/WEB-INF/views/client_actions/client_del.jsp").forward(request, response);

    }
}
