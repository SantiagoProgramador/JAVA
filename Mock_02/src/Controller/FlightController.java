package Controller;

import Entity.Airplane;
import Entity.Flight;
import Model.FlightModel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightController {
    FlightModel flightModel = new FlightModel();
    AirplaneController airplaneController = new AirplaneController();
    public boolean isEmpty(){
        if (flightModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no flight to show");
            return true;
        }
        return false;
    }
    public void addFlight(){

        Flight flight = new Flight();
        int idPlane = Integer.parseInt(JOptionPane.showInputDialog(airplaneController.showAirplanes()+"\n Type the id of the plane you want to add to the flight"));
        Airplane airplane = (Airplane) airplaneController.airplaneModel.findById(idPlane);
        if (airplane == null){
            JOptionPane.showMessageDialog(null,"Airplane not found, type an existing Id!");
            return;
        }
        String destination = JOptionPane.showInputDialog("Type the destination of the flight");
        String departure_date = JOptionPane.showInputDialog("Type the date of the flight (YYYY-MM-DD)");
        String departure_time = JOptionPane.showInputDialog("Type the hour of the flight (HH:MM)");

        flight.setDestination(destination);
        flight.setDeparture_date(LocalDate.parse(departure_date));
        flight.setDeparture_time(LocalTime.parse(departure_time));
        flight.setAirplane(airplane);
        flightModel.create(flight);

    }
    public List<String> showFlights(){
        List<String> list = new ArrayList<>();
        String flightInfo = "Flights: \n";
        String flightNameId = "";

        for (Object flightObj : flightModel.read()){
            Flight flight = (Flight) flightObj;
            flightInfo += "Id: " + flight.getId() + ", Destination: " + flight.getDestination() + ", Departure time: " + flight.getDeparture_date() + flight.getDeparture_time() + "\n Plane: " + flight.getAirplane().toString() + "\n Reservations: " + (flight.getReservations_list().isEmpty() ? " No reservations yet ":flight.getReservations_list().toString()) + "\n\n";
            flightNameId += "Id: " + flight.getId() + ", Destination: " + flight.getDestination() + ", Departure time: " + flight.getDeparture_date() + flight.getDeparture_time() + "\n";
        }


        list.add(flightInfo);
        list.add(flightNameId);
        return list;
    }
    public void deleteFlight(){
        if (isEmpty())return;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(showFlights().get(1)+"Type the id of the flight you want to delete"));
        Flight flight = (Flight) flightModel.findById(idDelete);
        if (flight == null){
            JOptionPane.showMessageDialog(null,"Flight not found, type an existing id!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this flight?");
        if (question == 0){
            flightModel.delete(idDelete);
        }
    }
    public void filterById(){
        if (isEmpty())return;
        int idSearch = Integer.parseInt(JOptionPane.showInputDialog(showFlights().get(1)+"Type the id of the flight you want to search"));
        Flight flight = (Flight) flightModel.findById(idSearch);
        if (flight == null){
            JOptionPane.showMessageDialog(null,"Flight not found, type an existing id!");
            return;
        }
        JOptionPane.showMessageDialog(null,flight.toString());
    }
    public void updateFlight(){
        if (isEmpty())return;

        int idSearch = Integer.parseInt(JOptionPane.showInputDialog(showFlights().get(1)+"Type the id of the flight you want to search"));
        Flight flight = (Flight) flightModel.findById(idSearch);
        if (flight == null){
            JOptionPane.showMessageDialog(null,"Flight not found, type an existing id!");
            return;
        }
        int idPlane = Integer.parseInt(JOptionPane.showInputDialog(airplaneController.showAirplanes()+"\n Type the id of the plane you want to add to the flight"));
        Airplane airplane = (Airplane) airplaneController.airplaneModel.findById(idPlane);
        if (airplane == null){
            JOptionPane.showMessageDialog(null,"Airplane not found, type an existing Id!");
            return;
        }
        String destination = JOptionPane.showInputDialog("Type the new destination of the flight");
        String departure_date = JOptionPane.showInputDialog("Type the new date of the flight (YYYY-MM-DD)");
        String departure_time = JOptionPane.showInputDialog("Type the new hour of the flight (YYYY-MM-DD)");

        flight.setDestination(destination);
        flight.setDeparture_date(LocalDate.parse(departure_date));
        flight.setDeparture_time(LocalTime.parse(departure_time));
        flight.setAirplane(airplane);
        flightModel.update(flight);
    }

}
