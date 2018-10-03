package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDel", urlPatterns = "/orderDel")
public class OrderDel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int delId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao.deleteOrderById(delId);
        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/order_del.jsp").forward(request, response);


    }
}
