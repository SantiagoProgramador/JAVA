package ControllerMenus;

import Controller.Patient_controller;

import javax.swing.*;

public class PatientMenu {
    public void menu(){
        Patient_controller patientController = new Patient_controller();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Patients menu, Please choose an option:
                        1. Add a patient.
                        2. Show the patients.
                        3. Delete a patient.
                        4. Filter a patient by Id.
                        5. Update a patient.
                        6. EXIT.
                        """);
                switch (option) {
                    case "1":
                        patientController.addPatient();
                        break;
                    case "2":
                        if (patientController.isEmpty()) return;
                        JOptionPane.showMessageDialog(null,patientController.showPatients().get(0));
                        break;
                    case "3":
                        patientController.deletePatient();
                        break;
                    case "4":
                        patientController.filterById();
                        break;
                    case "5":
                        patientController.updatePatient();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null, "Closing the patients menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again..." + e);
            }
        }while (!option.equals("6"));
    }
}
