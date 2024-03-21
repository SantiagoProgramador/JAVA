package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection connection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bydcls1ttzallpetyx0z-mysql.services.clever-cloud.com:3306/bydcls1ttzallpetyx0z";
            String user = "us7xxzf4uftdw4ou";
            String password = "Uu6PQYf8BIgljMHyoQvI";

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
            }
        } catch (SQLException e) {
            System.out.print("Error >> " + e);
        }

    }
}
