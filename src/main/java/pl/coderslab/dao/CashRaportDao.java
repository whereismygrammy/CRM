package pl.coderslab.dao;

import pl.coderslab.model.CashRaport;
import pl.coderslab.model.TimeRaport;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CashRaportDao {

    public static double getCashInTime(CashRaport cashRaport) {
        String sql = "SELECT SUM(costForClient) FROM crm.orders where stat = 'READY' and dateOfStart >= ? and dateOfStart < ?";
        double cash = 0;
        try {
            Connection connection = DbUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cashRaport.getStart().toString());
            preparedStatement.setString(2, cashRaport.getEnd().toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cash = resultSet.getDouble(1);

                System.out.println(cash);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cash;
    }


}
