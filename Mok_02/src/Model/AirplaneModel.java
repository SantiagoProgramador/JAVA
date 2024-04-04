package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Airplane;
import Entity.Passenger;
import Entity.Reservation;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Airplane airplane = (Airplane) object;

        try {
            String sql = "Insert INTO Plane (model,capacity) VALUES (?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,airplane.getModel());
            preparedStatement.setInt(2,airplane.getCapacity());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                airplane.setId(resultSet.getInt(1));

            }
            JOptionPane.showMessageDialog(null,"Airplane added Successfully!" + airplane.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return airplane;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> airplanes_list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Plane";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("id_plane"));
                airplane.setModel(resultSet.getString("model"));
                airplane.setCapacity(resultSet.getInt("capacity"));

                airplanes_list.add(airplane);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return airplanes_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Airplane airplane = (Airplane) object;

        try {
            String sql = "UPDATE Plane SET model = '" + airplane.getModel() + "' ,capacity = '" + airplane.getModel() + "' WHERE id_plane = " + airplane.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                airplane.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Airplane updated successfully!" + airplane.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }


        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM Plane WHERE plane.id_plane = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null,"Airplane deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The airplane was not found");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Airplane airplane = null;

        try {
            String sql = "SELECT * FROM Plane WHERE id_plane = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                airplane = new Airplane();
                airplane.setId(resultSet.getInt("id_plane"));
                airplane.setCapacity(resultSet.getInt("capacity"));
                airplane.setModel(resultSet.getString("model"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }


        ConfigDB.closeConnection();
        return airplane;
    }
}
