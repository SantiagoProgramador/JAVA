package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Specialty;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
