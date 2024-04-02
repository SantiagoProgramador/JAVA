package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Patient;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Patient_model implements CRUD{
    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Patient patient = (Patient) object;

        try{
            String sql = "INSERT INTO patients (name,surname,birthdate,identification_document) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,patient.getName());
            preparedStatement.setString(2,patient.getSurname());
            preparedStatement.setDate(3, Date.valueOf(patient.getBirthdate()));
            preparedStatement.setString(4,patient.getIdentification_document());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                patient.setId(resultSet.getInt("id_patient"));
            }
            JOptionPane.showMessageDialog(null, "Patient added successfully!" + patient.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return patient;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> Patient_list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM patients";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("id_patient"));
                patient.setName(resultSet.getString("name"));
                patient.setSurname(resultSet.getString("surname"));
                patient.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
                patient.setIdentification_document(resultSet.getString("identification_document"));
                Patient_list.add(patient);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return Patient_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Patient patient = (Patient) object;

        try{
            String sql = "UPDATE patients SET name = '" +patient.getName()+ "' ,surname = '" +patient.getSurname()+ "', birthdate = '" +patient.getBirthdate()+ "' ,identification_document = '" +patient.getIdentification_document()+ "' WHERE id_patient = " + patient.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                patient.setId(resultSet.getInt("id_patient"));
            }
            JOptionPane.showMessageDialog(null,"Patient updated successfully!" + patient.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " +  e);
        }

        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();
        try{
            String sql = "DELETE FROM patients WHERE patients.id_patient = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Patient deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null,"Patient was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Patient patient = null;

        try{
            String sql = "SELECT * FROM patients WHERE id_patient = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
                patient = new Patient();
                patient.setId(resultSet.getInt("id_patient"));
                patient.setName(resultSet.getString("name"));
                patient.setSurname(resultSet.getString("surname"));
                patient.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
                patient.setIdentification_document(resultSet.getString("identification_document"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return patient;
    }
}
