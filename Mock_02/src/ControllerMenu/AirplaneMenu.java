package ControllerMenu;

import Controller.AirplaneController;

import javax.swing.*;

public class AirplaneMenu {
    public void Menu(){
        AirplaneController airplaneController = new AirplaneController();
        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Airplane Menu.
                        Please choose an option:
                        1. Add an airplane.
                        2. Show the airplanes.
                        3. Update an airplane.
                        4. Find an airplane by Id.
                        5. Delete an airplane.
                        6. EXIT.
                        """);
                switch (option){
                    case "1":
                        airplaneController.addAirplane();
                        break;
                    case "2":
                        if (airplaneController.isEmpty()) return;
                        JOptionPane.showMessageDialog(null,airplaneController.showAirplanes());
                        break;
                    case "3":
                        airplaneController.updateAirplane();
                        break;
                    case "4":
                        airplaneController.filterById();
                        break;
                    case "5":
                        airplaneController.deleteAirplane();
                        break;
                    case "6":
                        JOptionPane.showMessageDialog(null,"Closing the airplanes menu...");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong... try again." + e);
            }
        }while (!option.equals("6"));
    }
}
