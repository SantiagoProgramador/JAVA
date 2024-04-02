package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Specialty;

import javax.naming.spi.ResolveResult;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Specialty_model implements CRUD{

    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Specialty specialty = (Specialty) object;

        try {
            String sql = "INSERT INTO specialities (name,description) VALUES (?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,specialty.getName());
            preparedStatement.setString(2,specialty.getDescription());

            preparedStatement.execute();
            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                specialty.setId(resultSet.getInt("id_speciality"));
            }
            JOptionPane.showMessageDialog(null,"Specialty created successfully " + specialty.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return specialty;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> Specialties_list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM specialities";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                Specialty specialty = new Specialty();
                specialty.setId(resultSet.getInt("id_speciality"));
                specialty.setName(resultSet.getString("name"));
                specialty.setDescription(resultSet.getString("description"));
                Specialties_list.add(specialty);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return Specialties_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Specialty specialty = (Specialty) object;

        try {
            String sql = "UPDATE specialities SET name = '" +specialty.getName() + "' ,description = '" + specialty.getDescription() + "' WHERE id_speciality =" + specialty.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                specialty.setId(resultSet.getInt("id_speciality"));
            }
            JOptionPane.showMessageDialog(null,"Specialty updated successfully! " + specialty.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();

        try{
            String sql = "DELETE FROM specialities WHERE id_speciality = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null,"The specialty was successfully deleted");
            }else {
                JOptionPane.showMessageDialog(null,"The specialty was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Specialty specialty = null;
        try{
            String sql = "SELECT * FROM specialities WHERE id_speciality = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                specialty = new Specialty();
                specialty.setId(resultSet.getInt("id_speciality"));
                specialty.setName(resultSet.getString("name"));
                specialty.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return specialty;
    }
}
