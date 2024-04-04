package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Airplane;
import Entity.Flight;
import Entity.Passenger;
import Entity.Reservation;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerModel implements CRUD {
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Passenger passenger = (Passenger) object;

        try {
            String sql = "Insert INTO Passenger (first_name,last_name,identification_document) VALUES (?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,passenger.getName());
            preparedStatement.setString(2,passenger.getSurname());
            preparedStatement.setString(3,passenger.getIdentification_document());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                passenger.setId(resultSet.getInt(1));

            }
            JOptionPane.showMessageDialog(null,"Passenger added Successfully!" + passenger.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return passenger;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> passengers_list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Passenger JOIN Reservation ON Reservation.id_passenger = Passenger.id_passenger JOIN Flight ON Flight.id_flight = Reservation.id_flight JOIN Plane ON Plane.id_plane = Flight.id_plane";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){

                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getInt("id_passenger"));
                passenger.setName(resultSet.getString("first_name"));
                passenger.setSurname(resultSet.getString("last_name"));
                passenger.setIdentification_document(resultSet.getString("identification_document"));
                passengers_list.add(passenger);

                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("Plane.id_plane"));
                airplane.setModel(resultSet.getString("Plane.model"));
                airplane.setCapacity(resultSet.getInt("Plane.capacity"));

                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id_flight"));
                flight.setAirplane(airplane);
                flight.setDestination(resultSet.getString("Flight.destination"));
                flight.setDeparture_date(resultSet.getDate("Flight.departure_date").toLocalDate());
                flight.setDeparture_time(resultSet.getTime("Flight.departure_time").toLocalTime());

                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("Reservation.id_reservation"));
                reservation.setPassenger(passenger);
                reservation.setSeat(resultSet.getString("Reservation.seat"));
                reservation.setBooking_date(resultSet.getDate("Reservation.reservation_date").toLocalDate());
                reservation.setFlight(flight);

                passenger.addReservation(reservation);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return passengers_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Passenger passenger = (Passenger) object;

        try {
            String sql = "UPDATE Passenger SET first_name = '" + passenger.getName() + "' ,last_name = '" + passenger.getSurname() + "' ,identification_document = '" + passenger.getIdentification_document()  +  "' WHERE id_passenger = " + passenger.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                passenger.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Airplane updated successfully!" + passenger.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }


        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM Passenger WHERE Passenger.id_passenger = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null,"Passenger deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The Passenger was not found");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Passenger passenger = null;

        try {
            String sql = "SELECT * FROM Passenger WHERE id_passenger = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                passenger = new Passenger();
                passenger.setId(resultSet.getInt("id_passenger"));
                passenger.setName(resultSet.getString("first_name"));
                passenger.setSurname(resultSet.getString("last_name"));
                passenger.setIdentification_document(resultSet.getString("identification_document"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }


        ConfigDB.closeConnection();
        return passenger;
    }
}
