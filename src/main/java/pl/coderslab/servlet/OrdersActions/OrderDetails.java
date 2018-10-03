package pl.coderslab.servlet.OrdersActions;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetails", urlPatterns = "/orderDetails")
public class OrderDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = OrderDao.getOrderById(orderId);

        System.out.println(order);
        request.setAttribute("order", order);

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders_actions/orders_details.jsp").forward(request,response);

    }
}