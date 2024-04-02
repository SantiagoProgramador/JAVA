package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection connection = null;
    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bkvtfutdokhfsayrjdq2-mysql.services.clever-cloud.com:3306/bkvtfutdokhfsayrjdq2";
            String user = "ucbjxkrbjudebzyu";
            String password = "B174yRrEFbKLPUjsISLe";

            connection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.print("Connection made successfully");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("Error >> " + e);
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed successfully!");
            } else {
                System.out.println("NO CONNECTION OPEN");
            }
        } catch (SQLException e) {
            System.out.print("Error >> " + e);
        }

    }
}
