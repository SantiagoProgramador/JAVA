package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Doctor;
import Entity.Patient;
import Entity.Specialty;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Doctor_model implements CRUD {
    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Doctor doctor = (Doctor) object;

        try{
            String sql = "INSERT INTO doctors (name,surname,id_speciality) VALUES (?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.setString(2,doctor.getSurname());
            preparedStatement.setInt(3,doctor.getSpecialty().getId());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                doctor.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Doctor added successfully! " + doctor.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return doctor;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> Doctor_list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM doctors JOIN specialities ON doctors.id_speciality = specialities.id_speciality";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id_doctor"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSurname(resultSet.getString("surname"));
                Specialty specialty = new Specialty();
                specialty.setId(resultSet.getInt("specialities.id_speciality"));
                specialty.setName(resultSet.getString("specialities.name"));
                specialty.setDescription(resultSet.getString("specialities.description"));
                doctor.setSpecialty(specialty);
                Doctor_list.add(doctor);
                //THIS WAY IS TERRIBLE FOR THE PERFORMANCE
                //Specialty_model specialtyModel = New Specialty_model();
                //doctor.setSpecialty((Specialty)specialtyModel.findById(resulSet.getInt("id_specialty")));
                //FOR EACH ITERATION IN THE LOOP WHILE CREATES A CONNECTION TO THE DATABASE AND THEN CLOSE IT BECAUSE THE METHOD FINDBYID HAS CONFIGDB.OPENCONNECTION();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return Doctor_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Doctor doctor = (Doctor) object;

        try {
            String sql = "UPDATE doctors SET name = '" +doctor.getName()+ "' ,surname = '" +doctor.getSurname()+ "' ,id_speciality = '" +doctor.getSpecialty().getId() + "' WHERE id_doctor = " + doctor.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                doctor.setId(resultSet.getInt("id_doctor"));
            }
            JOptionPane.showMessageDialog(null,"Doctor updated successfully! " + doctor.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> "+ e);
        }

        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM doctors WHERE doctors.id_doctors = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null,"Doctor deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null,"Doctor was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Specialty_model specialtyModel = new Specialty_model();
        Doctor doctor = null;

        try {
            String sql = "SELECT * FROM doctors WHERE id_doctor = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){

                doctor = new Doctor();
                doctor.setId(resultSet.getInt("id_doctor"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSurname(resultSet.getString("surname"));
                doctor.setSpecialty((Specialty) specialtyModel.findById(resultSet.getInt("id_speciality")));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return doctor;
    }
}
