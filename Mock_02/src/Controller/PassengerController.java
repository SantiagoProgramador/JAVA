package Controller;

import Entity.Airplane;
import Entity.Passenger;
import Model.AirplaneModel;
import Model.PassengerModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerController {
    PassengerModel passengerModel = new PassengerModel();

    public boolean isEmpty(){
        if (passengerModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null, "There is no passengers to show");
            return true;
        }
        return false;
    }
    public void addPassenger(){
        Passenger passenger = new Passenger();

        String name = JOptionPane.showInputDialog("Type the name of the passenger ");
        String surname = JOptionPane.showInputDialog("Type the surname of the passenger ");
        String identification_document = JOptionPane.showInputDialog("Type the id of the passenger ");
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setIdentification_document(identification_document);
        passengerModel.create(passenger);
    }
    public List<String> showPassengers(){
        List<String> list = new ArrayList<>();
        String passengerInfo = "Passengers: \n";
        String passengerNameId = "";
        for (Object passengerObj : passengerModel.read()){
            Passenger passenger = (Passenger) passengerObj;
            passengerInfo += "Id: " + passenger.getId() + ", name: " + passenger.getName() + ", last name: " + passenger.getSurname() + ", Identification document: " + passenger.getIdentification_document() + "\n" + ", Reservation/s: " + passenger.getReservation_list() + "\n";
            passengerNameId +=  "Id: " + passenger.getId() + ", name: " + passenger.getName() + ", last name: " + passenger.getSurname() + "\n";
        }
        list.add(passengerInfo);
        list.add(passengerNameId);
        return list;
    }
    public void deletePassenger(){
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(showPassengers().get(1)+"\nType the id of the Passenger you want to delete"));

        Passenger passenger = (Passenger) passengerModel.findById(idDelete);
        if (passenger == null){
            JOptionPane.showMessageDialog(null,"Passenger not found!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this passenger? " + passenger.toString());
        if (question == 0){
            passengerModel.delete(idDelete);
        }
    }
    public void filterById(){
        int idSearch = Integer.parseInt(JOptionPane.showInputDialog(showPassengers().get(1)+"\nType the id of the passenger you want to search"));

        Passenger passenger = (Passenger) passengerModel.findById(idSearch);
        if (passenger == null){
            JOptionPane.showMessageDialog(null,"Passenger not found!");
            return;
        }
        JOptionPane.showMessageDialog(null,passenger.toString());
    }
    public void updatePassenger(){
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(showPassengers().get(1)+"\nType the id of the passenger you want to update"));

        Passenger passenger = (Passenger) passengerModel.findById(idUpdate);
        if (passenger == null){
            JOptionPane.showMessageDialog(null,"Passenger not found!");
            return;
        }
        String newName = JOptionPane.showInputDialog("Type the new name of the passenger");
        String newSurname = JOptionPane.showInputDialog("Type the new surname of the passenger");
        String newIdentification_document = JOptionPane.showInputDialog("Type the new identification document of the passenger");
        passenger.setName(newName);
        passenger.setSurname(newSurname);
        passenger.setIdentification_document(newIdentification_document);
        passengerModel.update(passenger);
    }
}
