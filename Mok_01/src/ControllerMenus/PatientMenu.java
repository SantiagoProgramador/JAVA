package ControllerMenus;

import javax.swing.*;

public class PatientMenu {
    public void menu(){
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Appointment menu, Please choose an option:
                        1. Add a patient.
                        2. Show the patients.
                        3. Delete a patient.
                        4. Filter a patient by Id.
                        5. EXIT.
                        """);
                switch (option) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null, "Closing the patients menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("5"));
    }
}
