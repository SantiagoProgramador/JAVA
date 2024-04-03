package ControllerMenus;

import javax.swing.*;

public class AppointmentMenu {

    public void  menu(){
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Appointment menu, Please choose an option:
                        1. Add an appointment.
                        2. Show the appointments.
                        3. Delete an appointment.
                        4. Filter an appointment by patient, doctor or id.
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
                        JOptionPane.showMessageDialog(null, "Closing the appointments menu...");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("5"));
    }
}
