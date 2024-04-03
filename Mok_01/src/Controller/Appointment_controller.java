package Controller;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Entity.Specialty;
import Model.Appointment_model;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment_controller {
    Appointment_model appointmentModel = new Appointment_model();
    Patient_controller patientController = new Patient_controller();
    Doctor_controller doctorController = new Doctor_controller();

    public boolean isEmpty(){
        if (appointmentModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no appointments to show!");
            return true;
        }
        return false;
    }
    public void addAppointment(){
        Appointment appointment = new Appointment();

        int patientId = Integer.parseInt(JOptionPane.showInputDialog(patientController.showPatients().get(1) +"Type the Id of the patient"));
        Patient patient = (Patient) patientController.patientModel.findById(patientId);
        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found, Type an existing Id!");
            return;
        }
        int doctorId = Integer.parseInt(JOptionPane.showInputDialog(doctorController.showDoctors().get(1) +"Type the Id of the doctor"));
        Doctor doctor = (Doctor) doctorController.doctorModel.findById(doctorId);
        if (doctor == null) {
            JOptionPane.showMessageDialog(null, "Doctor not found, Type an existing Id!");
            return;
        }
        String motive = JOptionPane.showInputDialog("Type the motive of the appointment");
        String date = JOptionPane.showInputDialog("Type the date of the appointment (YYYY-MM-DD)");
        String hour = JOptionPane.showInputDialog("Type the hour of the appointment (HH:MM)");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setMotive(motive);
        appointment.setDate(LocalDate.parse(date));
        appointment.setHour(LocalTime.parse(hour));
        appointmentModel.create(appointment);
    }
    public List<String> showAppointments(){
        String AppointmentInfo = "Appointments: \n";
        String AppointmentNameId = "";

        for (Object appointmentObj : appointmentModel.read()){
            Appointment appointment = (Appointment) appointmentObj;

            AppointmentInfo += "-> " + appointment.getId() + ", Date: " +appointment.getDate() + " "+ appointment.getHour() +", Doctor: "+appointment.getDoctor().getName()+", Patient: "+appointment.getPatient().getName()+ ", Motive: "+appointment.getMotive() +"\n";
            AppointmentNameId += "-> " +appointment.getId() + ", Date: " +appointment.getDate() + " "+ appointment.getHour() +", Doctor: "+appointment.getDoctor().getName()  + "\n";
        }
        List<String> list = new ArrayList<>();
        list.add(AppointmentInfo);
        list.add(AppointmentNameId);
        return  list;
    }
    public void deleteAppointment(){
        if(isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showAppointments().get(1)+"Type the id of the doctor you want to delete"));
        Appointment appointment = (Appointment) appointmentModel.findById(id);
        if (appointment == null){
            JOptionPane.showMessageDialog(null,"Appointment not found, type an existing Id!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Appointment?");
        if (question == 0){
            appointmentModel.delete(id);
        }

    }
    public void filterById(){
        if(isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showAppointments().get(1)+"Type the id of the appointment you want to search"));
        Appointment appointment = (Appointment) appointmentModel.findById(id);
        if (appointment == null){
            JOptionPane.showMessageDialog(null,"Appointment not found, type an existing Id!");
            return;
        }
        JOptionPane.showMessageDialog(null,appointment.toString());

    }
    public void UpdateAppointment(){
        if(isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showAppointments().get(1)+"Type the id of the appointment you want to update"));
        Appointment appointment = (Appointment) appointmentModel.findById(id);
        if (appointment == null){
            JOptionPane.showMessageDialog(null,"Appointment not found, type an existing Id!");
            return;
        }
        int patientId = Integer.parseInt(JOptionPane.showInputDialog(patientController.showPatients().get(1) +"Type the Id of the patient"));
        Patient patient = (Patient) patientController.patientModel.findById(patientId);
        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found, Type an existing Id!");
            return;
        }
        int doctorId = Integer.parseInt(JOptionPane.showInputDialog(doctorController.showDoctors().get(1) +"Type the Id of the doctor"));
        Doctor doctor = (Doctor) doctorController.doctorModel.findById(doctorId);
        if (doctor == null) {
            JOptionPane.showMessageDialog(null, "Doctor not found, Type an existing Id!");
            return;
        }
        String motive = JOptionPane.showInputDialog("Type the motive of the appointment");
        String date = JOptionPane.showInputDialog("Type the date of the appointment (YYYY-MM-DD)");
        String hour = JOptionPane.showInputDialog("Type the hour of the appointment (HH:MM)");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setMotive(motive);
        appointment.setDate(LocalDate.parse(date));
        appointment.setHour(LocalTime.parse(hour));
        appointmentModel.update(appointment);
    }
}
