import ControllerMenus.AppointmentMenu;
import ControllerMenus.DoctorMenu;
import ControllerMenus.PatientMenu;
import ControllerMenus.SpecialtyMenu;
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
                        SpecialtyMenu specialtyMenu = new SpecialtyMenu();
                        specialtyMenu.menu();
                        break;
                    case "2":
                        DoctorMenu doctorMenu = new DoctorMenu();
                        doctorMenu.menu();
                        break;
                    case "3":
                        PatientMenu patientMenu = new PatientMenu();
                        patientMenu.menu();
                        break;
                    case "4":
                        AppointmentMenu appointmentMenu = new AppointmentMenu();
                        appointmentMenu.menu();
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null,"Thanks for using our services come back soon :D");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Something went wrong... please try again." + e);
            }
        } while (!option.equals("5"));
    }
}