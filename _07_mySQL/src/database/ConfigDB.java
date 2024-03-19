package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable that gets the status of the connection
    static Connection connection = null;

    //Method to open the connection between Java and the database
    public static Connection openConnection(){
        try{
            //Brings a class without an importation above
            Class.forName("com.mysql.cj.jdbc.Driver");
            //VARIABLES WITH OUR DATABASE'S CREDENTIALS
            String url = "jdbc:mysql://localhost:3306/_07_jdbc";
            String user = "root";
            String password = "Rlwl2023.";

            //ESTABLISHING CONNECTION....
            connection = (Connection) DriverManager.getConnection(url,user,password);

            System.out.println("Connection made successfully!");

        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver not installed!");
        } catch (SQLException e) {
            System.out.println("Error >> Failed to establish a connection with the database!");
        }
        return connection;
    }

    //Method to close the connection between Java and the database.
    public static void closeConnection(){
        try {
            //If there is an active connection we close it.
            if (connection != null){
                connection.close();
                System.out.print("Connection closed successfully!");
            }

        } catch (SQLException e){
            System.out.println("Error >> " + e.getMessage());
        }
    }
}
