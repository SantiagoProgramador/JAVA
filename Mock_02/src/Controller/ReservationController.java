package Controller;

import Entity.Flight;
import Entity.Passenger;
import Entity.Reservation;
import Model.ReservationModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    ReservationModel reservationModel = new ReservationModel();
    FlightController flightController = new FlightController();
    PassengerController passengerController = new PassengerController();
    public boolean isEmpty(){
        if (reservationModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no reservations to show!");
            return true;
        }
        return false;
    }
    public void addReservation(){
        Reservation reservation = new Reservation();

        int flightId = Integer.parseInt(JOptionPane.showInputDialog(flightController.showFlights().get(1)+ "Type the the id of the flight"));
        int passengerId = Integer.parseInt(JOptionPane.showInputDialog(passengerController.showPassengers().get(1)+"Type the Id of the passenger you want to book the flight"));

        Flight flight = (Flight) flightController.flightModel.findById(flightId);
        if (flight == null){
            JOptionPane.showMessageDialog(null,"Flight not found, please type an existing Id!");
            return;
        }
        Passenger passenger = (Passenger) passengerController.passengerModel.findById(passengerId);
        if (passenger == null){
            JOptionPane.showMessageDialog(null,"Passenger not found, please type an existing Id!");
            return;
        }
        reservation.setBooking_date(LocalDate.now());
        String seat = JOptionPane.showInputDialog("Type the seat you want to book in the plane");
        reservation.setSeat(seat);
        reservationModel.create(reservation);

    }
    public List<String> showReservations(){
        List<String> list = new ArrayList<>();
        String reservationInfo = "Reservations: \n";
        String reservationIdDate = "";

        for (Object reservationObj : reservationModel.read()){
            Reservation reservation = (Reservation) reservationObj;
            reservationInfo += "Id: " + reservation.getId() + ", Passenger: " + reservation.getPassenger().getName() + ", Seat: " + reservation.getSeat() + ", Date: " + reservation.getBooking_date()+ ", Destination: "+ reservation.getFlight().getDestination() + "\nFlight: " + reservation.getFlight().getId() + " Hour: " +reservation.getFlight().getDeparture_time() + " Plane: " +reservation.getFlight().getAirplane().toString()  + "\n\n";
            reservationIdDate += "Id: " + reservation.getId() + ", Passenger: " + reservation.getPassenger().getName() + ", Seat: " + reservation.getSeat() + ", Date: " + reservation.getBooking_date();
        }

        list.add(reservationInfo);
        list.add(reservationIdDate);
        return list;
    }
    public void deleteReservation(){
        if (isEmpty()) return;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(showReservations().get(1)+"\n Type the id of the reservation you want to delete"));
        Reservation reservation = (Reservation) reservationModel.findById(idDelete);
        if (reservation == null){
            JOptionPane.showMessageDialog(null,"Reservation not found, type an existing id!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this reservation?");
        if (question== 0){
            reservationModel.delete(idDelete);
        }

    }
    public void filterById(){
        if (isEmpty()) return;
        int idSearch = Integer.parseInt(JOptionPane.showInputDialog(showReservations().get(1)+"\n Type the id of the reservation you want to search"));
        Reservation reservation = (Reservation) reservationModel.findById(idSearch);
        if (reservation == null){
            JOptionPane.showMessageDialog(null,"Reservation not found, type an existing id!");
            return;
        }
        String info = "Id: " + reservation.getId() + ", Passenger: " + reservation.getPassenger().getName() + ", Seat: " + reservation.getSeat() + ", Date: " + reservation.getBooking_date()+ ", Destination: "+ reservation.getFlight().getDestination() + "\nFlight: " + reservation.getFlight().getId() + " Hour: " +reservation.getFlight().getDeparture_time() + " Plane: " +reservation.getFlight().getAirplane().toString()  + "\n\n";
        JOptionPane.showMessageDialog(null,info);

    }
    public void updateReservation(){
        if (isEmpty()) return;
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(showReservations().get(1)+"\n Type the id of the reservation you want to update"));
        Reservation reservation = (Reservation) reservationModel.findById(idUpdate);
        if (reservation == null){
            JOptionPane.showMessageDialog(null,"Reservation not found, type an existing id!");
            return;
        }
        int flightId = Integer.parseInt(JOptionPane.showInputDialog(flightController.showFlights().get(1)+ "Type the the id of the flight"));
        int passengerId = Integer.parseInt(JOptionPane.showInputDialog(passengerController.showPassengers().get(1)+"Type the Id of the passenger you want to book the flight"));

        Flight flight = (Flight) flightController.flightModel.findById(flightId);
        if (flight == null){
            JOptionPane.showMessageDialog(null,"Flight not found, please type an existing Id!");
            return;
        }
        Passenger passenger = (Passenger) passengerController.passengerModel.findById(passengerId);
        if (passenger == null){
            JOptionPane.showMessageDialog(null,"Passenger not found, please type an existing Id!");
            return;
        }
        reservation.setBooking_date(LocalDate.now());
        String seat = JOptionPane.showInputDialog("Type the seat you want to book in the plane");
        reservation.setSeat(seat);
        reservationModel.update(reservation);
    }
}
