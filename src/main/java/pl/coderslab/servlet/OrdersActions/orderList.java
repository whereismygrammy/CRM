package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderList", urlPatterns = "/orderList")
public class orderList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        List<Order> orders = null;
        if (idStr == null) {
            orders = OrderDao.getAllOrders();
        } else {
            int id = Integer.parseInt(idStr);
            orders = OrderDao.getOrdersByCustomerId(id);
        }
        request.setAttribute("orders", orders);


        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/orders_list.jsp").forward(request, response);
    }
}