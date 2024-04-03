package ControllerMenus;

import javax.swing.*;

public class DoctorMenu {
    public void menu(){
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Doctor menu, Please choose an option:
                        1. Add a doctor.
                        2. Show the doctors.
                        3. Delete a doctor.
                        4. Filter a doctor by Id.
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
                        JOptionPane.showMessageDialog(null, "Closing the doctors menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("5"));
    }
}
