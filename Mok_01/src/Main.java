import Database.ConfigDB;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Model.Appointment_model;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Appointment_model appointmentModel = new Appointment_model();

        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        WELCOME TO THE ONLINE HOSPITAL SERVICE
                        Please choose an option:
                        1. Add a specialty.
                        2, Add a doctor.
                        3. Register a patient.
                        4. Schedule an appointment.
                        5. EXIT
                        """);
                switch (option){
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null,"Thanks for using our services come back soon :D4");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Something went wrong... please try again.");
            }
        } while (!option.equals("5"));
    }
}