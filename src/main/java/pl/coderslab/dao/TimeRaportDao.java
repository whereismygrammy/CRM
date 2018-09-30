package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.TimeRaport;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeRaportDao {

    public static List<String[]> getTimeRaport(TimeRaport timeRaport) {
        String sql = "select employee.id, name, surname, sum(numberOfHours) from orders join employee on orders.employee_id = employee.id" +
                " where dateOfStart > ? and dateOfStart < ?  GROUP BY employee.id";
        List<String[]> timeRaportList = new ArrayList<>();

        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, timeRaport.getStart().toString());
            preparedStatement.setString(2, timeRaport.getEnd().toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String fullName = resultSet.getString("name") + " " + resultSet.getString("surname");
                String[] temp = new String[2];
                temp[0] = fullName;
                temp[1] = resultSet.getString("sum(numberOfHours)");
                timeRaportList.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeRaportList;
    }


}
