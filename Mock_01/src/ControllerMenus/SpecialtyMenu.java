package ControllerMenus;

import Controller.Specialty_controller;

import javax.swing.*;

public class SpecialtyMenu {
    public void menu(){
        Specialty_controller specialtyController = new Specialty_controller();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Appointment menu, Please choose an option:
                        1. Add a specialty.
                        2. Show the specialties.
                        3. Delete a specialty .
                        4. Filter a specialty by Id.
                        5. Update a specialty.
                        6. EXIT.
                        """);
                switch (option) {
                    case "1":
                        specialtyController.AddSpecialty();
                        break;
                    case "2":
                        if (specialtyController.isEmpty()) return;
                        JOptionPane.showMessageDialog(null,specialtyController.showSpecialties().get(0));
                        break;
                    case "3":
                        specialtyController.deleteSpecialty();
                        break;
                    case "4":
                        specialtyController.filterById();
                        break;
                    case "5":
                        specialtyController.updateSpecialty();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null, "Closing the specialties menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again..." + e);
            }
        }while (!option.equals("6"));
    }
}
