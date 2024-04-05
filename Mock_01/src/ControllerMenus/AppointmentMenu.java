package ControllerMenus;

import Controller.Appointment_controller;

import javax.swing.*;

public class AppointmentMenu {

    public void  menu(){
        Appointment_controller appointmentController = new Appointment_controller();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Appointment menu, Please choose an option:
                        1. Add an appointment.
                        2. Show the appointments.
                        3. Delete an appointment.
                        4. Filter an appointment by patient, doctor or id.
                        5. Update an appointment.
                        6. EXIT.
                        """);
                switch (option) {
                    case "1":
                        appointmentController.addAppointment();
                        break;
                    case "2":
                        if (appointmentController.isEmpty())return;
                        JOptionPane.showMessageDialog(null,appointmentController.showAppointments().get(0));
                        break;
                    case "3":
                        appointmentController.deleteAppointment();
                        break;
                    case "4":
                        appointmentController.filterById();
                        break;
                    case "5":
                        appointmentController.UpdateAppointment();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null, "Closing the appointments menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("6"));
    }
}
