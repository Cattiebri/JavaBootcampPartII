package lv.accenture.bootcamp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonAddressInserter {

    public static void main(String[] args) throws Exception {
        Connection connection = DBUtil.acquireConnection();

        String insertAddressSql = "insert into address(country, city, street, house) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertAddressSql, Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, "Latvia");
        preparedStatement.setString(2, "Jurmala");
        preparedStatement.setString(3, "Jomas");
        preparedStatement.setInt(4, 123);
        preparedStatement.executeUpdate();

        Long generatedAddressId = null;
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            generatedAddressId = generatedKeys.getLong(1);
        } else {
            throw new RuntimeException("Failed to get ID from inserted address!");
        }

        String insertPersonSql = "insert into person(code, first_name, " +
                "last_name, birth_date, employed, height, address_fk) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement personPreparedStatement = connection.prepareStatement(insertPersonSql);
        personPreparedStatement.setString(1, "221222-12345");
        personPreparedStatement.setString(2, "Peteris");
        personPreparedStatement.setString(3, "Kruminsh");
        java.sql.Date birthDate = new java.sql.Date(System.currentTimeMillis());
        personPreparedStatement.setDate(4, birthDate);
        personPreparedStatement.setBoolean(5, false);
        personPreparedStatement.setInt(6, 159);
        personPreparedStatement.setLong(7, generatedAddressId);
        personPreparedStatement.executeUpdate();

        connection.close();
    }

}
