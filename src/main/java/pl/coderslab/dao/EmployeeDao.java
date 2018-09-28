package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static void addOrUpdateEmployee(Employee employee) {
        if (employee.getId() == 0) {
            String sql = "INSERT INTO employee (name, surname, adress, phone, note, costPerHour) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getAddress());
                preparedStatement.setString(4, employee.getPhone());
                preparedStatement.setString(5, employee.getNote());
                preparedStatement.setDouble(6, employee.getCostPerHour());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String sql = "UPDATE employee SET name = ?, surname = ?, adress = ?, phone=?, note=?, costPerHour =?  WHERE id = ?";
            try {
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getAddress());
                preparedStatement.setString(4, employee.getPhone());
                preparedStatement.setString(5, employee.getNote());
                preparedStatement.setDouble(6, employee.getCostPerHour());
                preparedStatement.setInt(7, employee.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("adress"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setCostPerHour(resultSet.getDouble("costPerHour"));
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getAllEmployee() {
        String sql = "SELECT * FROM employee";
        ArrayList<Employee> employeesList = new ArrayList<>();

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("adress"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setCostPerHour(resultSet.getDouble("costPerHour"));
                employeesList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }

    public static void deleteById(int id) {
        if (id != 0) {
            try {
                String sql = "DELETE FROM employee WHERE id = ?";
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


