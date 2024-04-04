package ControllerMenu;

import javax.swing.*;

public class ReservationMenu {
    public void Menu(){
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Reservation Menu.
                        Please choose an option:
                        1. Add a reservation.
                        2. Show the reservations.
                        3. Update a reservation.
                        4. Find a reservation by Id.
                        5. Delete a reservation.
                        6. EXIT.
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
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null,"Closing the reservations menu...");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong... try again." + e);
            }
        }while (!option.equals("6"));
    }
}
