package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Entity.Specialty;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Appointment_model implements CRUD {
    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Appointment appointment = (Appointment) object;

        try {
            String sql = "INSERT INTO appointments (date_appointment,time_appointment,motive,id_doctor,id_patient) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setDate(1, Date.valueOf(appointment.getDate()));
            preparedStatement.setTime(2,Time.valueOf(appointment.getHour()));
            preparedStatement.setString(3,appointment.getMotive());
            preparedStatement.setInt(4,appointment.getDoctor().getId());
            preparedStatement.setInt(5,appointment.getPatient().getId());

            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                appointment.setId(resultSet.getInt("id_appointment"));
            }
            JOptionPane.showMessageDialog(null,"Appointment booked successfully" + appointment.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return appointment;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> Appointment_list = new ArrayList<>();

        try{

            String sql = "SELECT * FROM `appointments` JOIN doctors ON doctors.id_doctor = appointments.id_doctor JOIN patients ON patients.id_patient = appointments.id_patient";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()){
                Appointment appointment = new Appointment();
                Patient patient = new Patient();
                Doctor doctor = new Doctor();

                patient.setId(resultSet.getInt("id_patient"));
                patient.setName(resultSet.getString("patients.name"));
                patient.setSurname(resultSet.getString("patients.surname"));
                patient.setBirthdate(resultSet.getDate("patients.birthdate").toLocalDate());
                patient.setIdentification_document(resultSet.getString("patients.identification_document"));

                doctor.setId(resultSet.getInt("id_doctor"));
                doctor.setName(resultSet.getString("doctors.name"));
                doctor.setSurname(resultSet.getString("doctors.surname"));

                appointment.setId(resultSet.getInt("id_appointment"));
                appointment.setDate(resultSet.getDate("date_appointment").toLocalDate());
                appointment.setHour(resultSet.getTime("time_appointment").toLocalTime());
                appointment.setMotive(resultSet.getString("motive"));

                appointment.setDoctor(doctor);
                appointment.setPatient(patient);

                Appointment_list.add(appointment);

                patient.setAppointment_list(Appointment_list);
                doctor.setAppointment_list(Appointment_list);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return Appointment_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Appointment appointment = (Appointment) object;

        try{
            String sql = "UPDATE  appointments SET date_appointment = '" + appointment.getDate() + "' ,time_appointment = '" +   appointment.getHour() + "' ,motive ='"+ appointment.getMotive()+ "'WHERE id_appointment = " + appointment.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                appointment.setId(resultSet.getInt("id_appointment"));
            }
            JOptionPane.showMessageDialog(null,"Appointment updated successfully!" + appointment.toString());
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
            String sql = "DELETE FROM appointments WHERE id_appointment = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAfeccted = preparedStatement.executeUpdate();
            if (rowsAfeccted > 0){
                JOptionPane.showMessageDialog(null, "Appointment deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The Appointment was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
    }


    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Appointment appointment = null;
        List<Object> Appointment_list = new ArrayList<>();

        try {
          String sql = "SELECT * FROM appointments JOIN doctors ON doctors.id_doctor = appointments.id_doctor JOIN patients ON patients.id_patient = appointments.id_patient WHERE appointments.id_appointment = " + id;
          PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

          ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
          while (resultSet.next()){
              appointment = new Appointment();
              appointment.setId(resultSet.getInt("id"));
              appointment.setMotive(resultSet.getString("motive"));
              appointment.setDate(resultSet.getDate("date_appointment").toLocalDate());
              appointment.setHour(resultSet.getTime("time_appointment").toLocalTime());

              Patient patient = new Patient();
              patient.setId(resultSet.getInt("id_patient"));
              patient.setBirthdate(resultSet.getDate("patients.birthdate").toLocalDate());
              patient.setName(resultSet.getString("patients.name"));
              patient.setSurname(resultSet.getString("patients.surname"));
              patient.setIdentification_document(resultSet.getString("patients.identification_document"));

              Doctor doctor = new Doctor();
              doctor.setId(resultSet.getInt("id_doctor"));
              doctor.setName(resultSet.getString("doctors.name"));
              doctor.setSurname(resultSet.getString("doctors.surname"));

              appointment.setPatient(patient);
              appointment.setDoctor(doctor);
              Appointment_list.add(appointment);
              patient.setAppointment_list(Appointment_list);
              doctor.setAppointment_list(Appointment_list);
          }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();

        return appointment;
    }
}
