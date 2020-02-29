package lv.accenture.bootcamp.db;

import java.sql.*;

public class PersonDBLauncher {

    public static void main(String[] args) throws Exception {
        Connection connection = DBUtil.acquireConnection();
        Statement statement = connection.createStatement();

        String allPersonSQL = "select * from person";
        ResultSet allPersons = statement.executeQuery(allPersonSQL);
        while(allPersons.next()) {
            printPerson(allPersons);
        }
        allPersons.close();

        /* Simple statement*/
        String companyName = "Accenture";
        String allAccentureEmployeesSQL = "select person.* from person \n" +
                "    join company_employee on person.code = company_employee.PERSON_CODE\n" +
                "    join company on company.REG_NR = company_employee.REG_NR\n" +
                "        where company.NAME = '" + companyName + "' ";

        statement = connection.createStatement();
        allPersons = statement.executeQuery(allAccentureEmployeesSQL);
        while(allPersons.next()) {
            //printPerson(allPersons);
        }
        allPersons.close();

        System.out.println("----------------------------------------------");

        /* Prepared statement*/
        allAccentureEmployeesSQL = "select person.* from person \n" +
                "    join company_employee on person.code = company_employee.PERSON_CODE\n" +
                "    join company on company.REG_NR = company_employee.REG_NR\n" +
                "        where company.NAME = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(allAccentureEmployeesSQL);
        preparedStatement.setString(1, "Accenture");

        allPersons = preparedStatement.executeQuery();
        while(allPersons.next()) {
            //printPerson(allPersons);
        }
        allPersons.close();




        connection.close();

    }

    private static void printPerson(ResultSet allPersons) throws SQLException {
        String code = allPersons.getString("code");
        String firstName = allPersons.getString("first_name");
        String lastName = allPersons.getString("last_name");
        java.sql.Date birthDate = allPersons.getDate("birth_date");
        //long birthDateMsec = birthDate.getTime();
        boolean employed = allPersons.getBoolean("employed");
        int heightCm = allPersons.getInt("height");

        long addressId = allPersons.getLong("address_fk");
        boolean addressIsNull = allPersons.wasNull();
        String addr = addressIsNull ? "Bezpajumtieks" : String.valueOf(addressId);

        System.out.println(code + " | " + firstName + " | " + lastName + " | "
                + birthDate + " | " + employed + " | " + heightCm + " | " + addr);

    }

}
