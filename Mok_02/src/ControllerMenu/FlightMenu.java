package ControllerMenu;

import Controller.FlightController;

import javax.swing.*;

public class FlightMenu {
    public void Menu(){
        FlightController flightController = new FlightController();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Flight Menu.
                        Please choose an option:
                        1. Add a flight.
                        2. Show the flights.
                        3. Update a flight.
                        4. Find a flight by Id.
                        5. Delete a flight.
                        6. EXIT.
                        """);
                switch (option){
                    case "1":
                        flightController.addFlight();
                        break;
                    case "2":
                        if (flightController.isEmpty())return;
                        JOptionPane.showMessageDialog(null,flightController.showFlights().get(0));
                        break;
                    case "3":
                        flightController.updateFlight();
                        break;
                    case "4":
                        flightController.filterById();
                        break;
                    case "5":
                        flightController.deleteFlight();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null,"Closing the flights menu...");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong... try again." + e);
            }
        }while (!option.equals("6"));
    }
}
