package lv.accenture.bootcamp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDBUpdater {

    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtil.acquireConnection();

        String deletePersonSql = "delete from person where person.code = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deletePersonSql);
        deleteStatement.setString(1, "111111-11111");
        deleteStatement.executeUpdate();

        String insertPersonSql = "insert into person(code, first_name, " +
                "last_name, birth_date, employed, height) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
        preparedStatement.setString(1, "111111-11111");
        preparedStatement.setString(2, "Berzs");
        preparedStatement.setString(3, "Janinsh");
        java.sql.Date birthDate = new java.sql.Date(System.currentTimeMillis());
        preparedStatement.setDate(4, birthDate);
        preparedStatement.setBoolean(5, false);
        preparedStatement.setInt(6, 222);
        preparedStatement.executeUpdate();




        connection.close();
    }

}
