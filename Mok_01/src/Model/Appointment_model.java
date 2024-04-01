package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;

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
            Patient patient = new Patient();
            Doctor doctor = new Doctor();
            String sql = "SELECT * FROM `appointments` JOIN doctors ON doctors.id_doctor = appointments.id_doctor JOIN patients ON patients.id_patient = appointments.id_patient";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = (ResultSet) preparedStatement;

            while (resultSet.next()){
                patient.setId();
                patient.setName();
                patient.setSurname();
                patient.setBirthdate();


                appointment.setId(resultSet.getInt("id_appointment"));
                appointment.setDate(resultSet.getDate("date_appointment").toLocalDate());
                appointment.setHour(resultSet.getTime("time_appointment").toLocalTime());
                appointment.setMotive(resultSet.getString("motive"));

                appointment.setDoctor();
                appointment.setPatient();
            }
            patient.setAppointment_list(Appointment_list);

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
