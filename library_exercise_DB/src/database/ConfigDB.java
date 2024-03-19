package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection connection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "Rlwl2023.";

            connection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.print("Connection made successfully");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("Error >> " + e);
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.print("Error >> " + e);
        }

    }
}
