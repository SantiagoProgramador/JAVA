package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Appointment;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Appointment_model implements CRUD {
    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> Appointment_list = new ArrayList<>();

        try{
            Appointment appointment = new Appointment();
            String sql = "SELECT * FROM Appointment";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = (ResultSet) preparedStatement;

            while (resultSet.next()){
                appointment.setId(resultSet.getInt("id_appointment"));
                appointment.setDate(resultSet.getInt("date_appointment"));
                appointment.setHour(resultSet.getInt("time_appointment"));
                appointment.setPatient();
                appointment.setDoctor();
                appointment.setMotive();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return Appointment_list;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
