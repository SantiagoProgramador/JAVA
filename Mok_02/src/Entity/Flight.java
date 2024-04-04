package Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {
    private int id;
    private String destination;
    private LocalTime departure_time;
    private LocalDate departure_date;
    private Airplane airplane;
    private ArrayList<Reservation> reservations_list = new ArrayList<>();

    public Flight(int id, String destination, LocalTime departure_time, LocalDate departure_date, Airplane airplane) {
        this.id = id;
        this.destination = destination;
        this.departure_time = departure_time;
        this.departure_date = departure_date;
        this.airplane = airplane;
        this.reservations_list = new ArrayList<>();
    }
    public Flight(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public ArrayList<Reservation> getReservations_list() {
        return reservations_list;
    }

    public void setReservations_list(ArrayList<Reservation> reservations_list) {
        this.reservations_list = reservations_list;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", departure_time=" + departure_time +
                ", departure_date=" + departure_date +
                ", airplane=" + airplane +
                ", reservations_list=" + reservations_list +
                '}';
    }
}
