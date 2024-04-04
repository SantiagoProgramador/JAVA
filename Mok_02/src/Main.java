import ControllerMenu.AirplaneMenu;
import ControllerMenu.FlightMenu;
import ControllerMenu.PassengerMenu;
import ControllerMenu.ReservationMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String option = null;
        do {
            try {
                option = JOptionPane.showInputDialog("""
                        Welcome to the Airline Menu :D!
                        Please choose an option:
                        1. Airplanes Menu.
                        2. Flights Menu.
                        3. Passengers Menu.
                        4. Reservations Menu.
                        5. EXIT.
                        """);
                switch (option){
                    case "1":
                        AirplaneMenu airplaneMenu = new AirplaneMenu();
                        airplaneMenu.Menu();
                        break;
                    case "2":
                        FlightMenu flightMenu = new FlightMenu();
                        flightMenu.Menu();
                        break;
                    case "3":
                        PassengerMenu passengerMenu = new PassengerMenu();
                        passengerMenu.Menu();
                        break;
                    case "4":
                        ReservationMenu reservationMenu = new ReservationMenu();
                        reservationMenu.Menu();
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null,"Thanks for using your Airline menu :D, come back later!");
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong... try again." + e);
            }
        }while (!option.equals("5"));
    }
}