package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public static void addOrUpdateCustomer(Customer customer) {
        if (customer.getId() == 0) {

            String sql = "INSERT INTO customer (name, surname, birthday) VALUES (?, ?, ?)";
            try {
                // TO DO POPRAWYs TODO
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getBirthDay());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE customer SET name = ?, surname = ?, birthday = ? WHERE id = ?";
            try {
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getBirthDay());
                preparedStatement.setInt(4, customer.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setId(resultSet.getInt("id"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Customer> getAllCustomer() {
        String sql = "SELECT * FROM customer";
        ArrayList<Customer> customersList = new ArrayList<>();

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setId(resultSet.getInt("id"));
                customersList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customersList;
    }

    public static void deleteCustomer(Customer customer) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


