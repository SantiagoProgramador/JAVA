package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection connection = null;
    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bvixb0hfu9azopyocucs-mysql.services.clever-cloud.com:3306/bvixb0hfu9azopyocucs";
            String user = "uhx7imxn7vsgza7w";
            String password = "uPNRc1srFrIIq5pqBpdf";

            connection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Connection open successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error >> " + e);
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if(connection != null){
                connection.close();
                System.out.println("Connection closed successfully");
            }else {
                System.out.println("NO CONNECTION OPEN");
            }
        } catch (SQLException e) {
            System.out.println("Error >> " + e);
        }
    }
}
