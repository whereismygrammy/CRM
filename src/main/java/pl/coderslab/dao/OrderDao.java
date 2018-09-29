package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public static void addOrUpdateOrder(Order order) {
        if (order.getId() == 0) {
            String sql = "INSERT INTO orders (employee_id, vehicle_id, dateOfAcceptance, dateOfPlanedStart, dateOfStart, " +
                    "problemDescription, repairDescription, stat, costForClient, partsCost, workCost, numberOfHours)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try {
                String[] generatedColumns = {"ID"};
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setInt(1, order.getEmployee().getId());
                preparedStatement.setInt(2, order.getVehicle().getId());
                preparedStatement.setString(3, order.getDateOfAcceptance().toString());
                preparedStatement.setString(4, order.getDateOfPlanedStart().toString());
                preparedStatement.setString(5, order.getDateOfStart().toString());
                preparedStatement.setString(6, order.getProblemDescription());
                preparedStatement.setString(7, order.getRepairDescription());
                preparedStatement.setString(8, order.getStatus().toString());
                preparedStatement.setDouble(9, order.getCostForClient());
                preparedStatement.setDouble(10, order.getPartsCost());
                preparedStatement.setDouble(11, order.getWorkCost());
                preparedStatement.setInt(12, order.getNumberOfHours());

                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    order.setId(rs.getInt(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String sql = "UPDATE orders SET employee_id = ?, vehicle_id = ?, dateOfAcceptance = ?, dateOfPlanedStart =?, dateOfStart=?," +
                    " problemDescription=?, repairDescription=?, stat=?, costForClient=?, partsCost=?, workCost=?, numberOfHours=? " +
                    "WHERE id = ?";
            try {
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, order.getEmployee().getId());
                preparedStatement.setInt(2, order.getVehicle().getId());
                preparedStatement.setString(3, order.getDateOfAcceptance().toString());
                preparedStatement.setString(4, order.getDateOfPlanedStart().toString());
                preparedStatement.setString(5, order.getDateOfStart().toString());
                preparedStatement.setString(6, order.getProblemDescription());
                preparedStatement.setString(7, order.getRepairDescription());
                preparedStatement.setString(8, order.getStatus().toString());
                preparedStatement.setDouble(9, order.getCostForClient());
                preparedStatement.setDouble(10, order.getPartsCost());
                preparedStatement.setDouble(11, order.getWorkCost());
                preparedStatement.setInt(12, order.getNumberOfHours());
                preparedStatement.setInt(13, order.getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = orderFromResultSet(resultSet);
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }


    public static Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Order order = orderFromResultSet(resultSet);
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Order> getOrdersByCustomerId(int id) {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM orders JOIN vehicle ON orders.vehicle_id=vehicle.id where customer_id = ?";

            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = orderFromResultSet(resultSet);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public static List<Order> getOrdersByVehicleId(int id) {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM orders WHERE vehicle_id = ?";

            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = orderFromResultSet(resultSet);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }


    private static Order orderFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setDateOfAcceptance(resultSet.getString("dateOfAcceptance"));
        order.setDateOfPlanedStart(resultSet.getString("dateOfPlanedStart"));
        order.setDateOfStart(resultSet.getString("dateOfStart"));
        order.setProblemDescription(resultSet.getString("problemDescription"));
        order.setRepairDescription(resultSet.getString("repairDescription"));
        order.setStatus(resultSet.getString("stat"));
        order.setCostForClient(resultSet.getDouble("costForClient"));
        order.setPartsCost(resultSet.getDouble("partsCost"));
        order.setWorkCost(resultSet.getDouble("workCost"));
        order.setNumberOfHours(resultSet.getInt("numberOfHours"));
        order.setEmployee(resultSet.getInt("employee_id"));
        order.setVehicle(resultSet.getInt("vehicle_id"));
        return order;
    }

    public static void deleteOrderById(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        if (id != 0) {
            try {
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nie ma takiego usera");
        }

    }

}
