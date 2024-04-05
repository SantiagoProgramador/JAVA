package ControllerMenus;

import Controller.Doctor_controller;

import javax.swing.*;

public class DoctorMenu {
    public void menu(){
        Doctor_controller doctorController = new Doctor_controller();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Doctor menu, Please choose an option:
                        1. Add a doctor.
                        2. Show the doctors.
                        3. Delete a doctor.
                        4. Filter a doctor by Id.
                        5. Update a doctor.
                        6. EXIT.
                        """);
                switch (option) {
                    case "1":
                        doctorController.addDoctor();
                        break;
                    case "2":
                        if (doctorController.isEmpty()) return;
                        JOptionPane.showMessageDialog(null,doctorController.showDoctors().get(0));
                        break;
                    case "3":
                        doctorController.deleteDoctor();
                        break;
                    case "4":
                        doctorController.filterById();
                        break;
                    case "5":
                        doctorController.updateDoctor();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null, "Closing the doctors menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("6"));
    }
}
