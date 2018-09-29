package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {


    public static void addVehicle(Vehicle vehicle) {

        if (vehicle.getId() == 0) {
            String sql = "INSERT INTO vehicle (customer_id, model, brand, productionYear, licensePlate, nextTechnicalInspection) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                String[] generatedColumns = {"ID"};
                Connection connection = DbUtil.createConnection();


                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setInt(1, vehicle.getCustomer_id());
                preparedStatement.setString(2, vehicle.getModel());
                preparedStatement.setString(3, vehicle.getBrand());
                preparedStatement.setString(4, vehicle.getProductionYear());
                preparedStatement.setString(5, vehicle.getLicensePlate());
                preparedStatement.setString(6, vehicle.getNextTechnicalInspection());
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    vehicle.setId(rs.getInt(1));
                }


                System.out.println("Dodano pojazd " + vehicle.getModel() + " do bazy danych");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String sql = "UPDATE vehicle SET customer_id = ?, model = ?, brand = ?, productionYear = ?, licensePlate = ?, nextTechnicalInspection = ? WHERE id = ?)";
                Connection connection = DbUtil.createConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, vehicle.getModel());
                preparedStatement.setString(2, vehicle.getBrand());
                preparedStatement.setString(3, vehicle.getProductionYear());
                preparedStatement.setString(4, vehicle.getLicensePlate());
                preparedStatement.setString(5, vehicle.getNextTechnicalInspection());
                preparedStatement.setInt(6, vehicle.getCustomer_id());

                preparedStatement.executeUpdate();

                System.out.println("Dodano pojazd " + vehicle.getModel() + " do bazy danych");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id = ?";

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setLicensePlate(resultSet.getString("licensePlate"));
                vehicle.setNextTechnicalInspection(resultSet.getString("nextTechnicalInspection"));
                vehicle.setProductionYear(resultSet.getString("productionYear"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Vehicle> getVehicleByCustomerId(int customerId) {
        String sql = "SELECT * FROM vehicle WHERE customer_id = ?";
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setLicensePlate(resultSet.getString("licensePlate"));
                vehicle.setNextTechnicalInspection(resultSet.getString("nextTechnicalInspection"));
                vehicle.setProductionYear(resultSet.getString("productionYear"));
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteVehicleByCustomerId(int id) {
        String sql = "DELETE FROM vehicle WHERE customer_id = ?";
        if (id != 0) {
            try {
                List<Vehicle> vehicle = getVehicleByCustomerId(id);
                for (Vehicle v : vehicle) {
                    v.setId(0);
                }

                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteVehicleById(int id) {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        if (id != 0) {
            try {
                Vehicle vehicle = getVehicleById(id);
                Connection connection = DbUtil.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                vehicle.setId(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
