package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleDao {


    public static void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO test_veh (model, brand, productionYear, licensePlate, nextTechnicalInspection) VALUES (?, ?, ?, ?, ?)";
        try {

            Connection connection = DbUtil.getConn();

//
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
//                            + "crm?useSSL=false",
//                    "root",
//                    "coderslab");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vehicle.getModel());
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.setString(3, vehicle.getProductionYear());
            preparedStatement.setString(4, vehicle.getLicensePlate());
            preparedStatement.setString(5, vehicle.getNextTechnicalInspection());
            preparedStatement.executeUpdate();

            System.out.println(preparedStatement);

            System.out.println("Dodano pojazd " + vehicle.getModel() + " do bazy danych");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }


//    public Vehicle getVehicleByLicensePlate(String licensePlate){
//        String sql = "SELECT * FROM ";
//
//    }
}
