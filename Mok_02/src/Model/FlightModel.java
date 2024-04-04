package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Airplane;
import Entity.Flight;
import Entity.Passenger;
import Entity.Reservation;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Flight flight = (Flight) object;

        try {
            String sql = "Insert INTO Flight (destination,departure_date,departure_time,id_plane) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,flight.getDestination());
            preparedStatement.setDate(2, Date.valueOf(flight.getDeparture_date()));
            preparedStatement.setTime(3,Time.valueOf(flight.getDeparture_time()));
            preparedStatement.setInt(4,flight.getAirplane().getId());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                flight.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Flight added Successfully!" + flight.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return flight;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> flights_list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Flight JOIN Plane ON Plane.id_plane = Flight.id_plane JOIN Reservation ON Reservation.id_flight = Flight.id_flight JOIN Passenger ON Passenger.id_passenger = Reservation.id_passenger";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id_flight"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDeparture_date(resultSet.getDate("departure_date").toLocalDate());
                flight.setDeparture_time(resultSet.getTime("departure_time").toLocalTime());

                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("Plane.id_plane"));
                airplane.setModel(resultSet.getString("Plane.model"));
                airplane.setCapacity(resultSet.getInt("Plane.capacity"));

                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getInt("Passenger.id_passenger"));
                passenger.setName(resultSet.getString("Passenger.first_name"));
                passenger.setSurname(resultSet.getString("Passenger.last_name"));
                passenger.setIdentification_document(resultSet.getString("Passenger.identification_document"));

                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("Reservation.id_reservation"));
                reservation.setFlight(flight);
                reservation.setSeat(resultSet.getString("Reservation.seat"));
                reservation.setBooking_date(resultSet.getDate("Reservation.reservation_date").toLocalDate());
                reservation.setPassenger(passenger);

                passenger.addReservation(reservation);
                flight.addReservation(reservation);
                flight.setAirplane(airplane);

                flights_list.add(flight);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
        return flights_list;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Airplane airplane = (Airplane) object;

        try {
            String sql = "UPDATE Plane SET model = '" + airplane.getModel() + "' ,capacity = '" + airplane.getModel() + "' WHERE id_plane = " + airplane.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                airplane.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Airplane updated successfully!" + airplane.toString());

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
            String sql = "DELETE FROM Plane WHERE plane.id_plane = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null,"Airplane deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The airplane was not found");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }

        ConfigDB.closeConnection();
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Airplane airplane = null;

        try {
            String sql = "SELECT * FROM Plane WHERE id_plane = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                airplane = new Airplane();
                airplane.setId(resultSet.getInt("id_plane"));
                airplane.setCapacity(resultSet.getInt("capacity"));
                airplane.setModel(resultSet.getString("model"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }


        ConfigDB.closeConnection();
        return airplane;
    }
}
