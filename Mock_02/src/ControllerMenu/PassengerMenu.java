package ControllerMenu;

import Controller.PassengerController;
import Entity.Passenger;

import javax.swing.*;

public class PassengerMenu {
    public void Menu(){
        PassengerController passengerController = new PassengerController();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Passenger Menu.
                        Please choose an option:
                        1. Add a passenger.
                        2. Show the passengers.
                        3. Update a passenger.
                        4. Find an passenger by Id.
                        5. Delete a passenger.
                        6. EXIT.
                        """);
                switch (option){
                    case "1":
                        passengerController.addPassenger();
                        break;
                    case "2":
                        if (passengerController.isEmpty())return;
                        JOptionPane.showMessageDialog(null,passengerController.showPassengers().get(0));
                        break;
                    case "3":
                        passengerController.updatePassenger();
                        break;
                    case "4":
                        passengerController.filterById();
                        break;
                    case "5":
                        passengerController.deletePassenger();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null,"Closing the passengers menu...");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong... try again." + e);
            }
        }while (!option.equals("6"));
    }
}
