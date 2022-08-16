import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER = "root";
        String PASS = "loinsfari123";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.driver");
        } catch (ClassNotFoundException e) {
            System.out.println(".......");
        }
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.execute("update employee_payroll set salary=160000 where name='Mark'");
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " +
                        resultSet.getString(2) + " " +
                        resultSet.getString(3) + " " +
                        resultSet.getDouble(4) + " " +
                        resultSet.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
