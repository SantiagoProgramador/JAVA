import Database.ConfigDB;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Entity.Specialty;
import Model.Appointment_model;
import Model.Specialty_model;

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
                        1. Specialties menu.
                        2. Doctors menu.
                        3. Patients menu.
                        4. Appointments menu.
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