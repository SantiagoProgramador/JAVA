package Entity;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private Passenger passenger;
    private Flight flight;
    private LocalDate booking_date;
    private String seat;

    public Reservation(int id, Passenger passenger, Flight flight, LocalDate booking_date, String seat) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
        this.booking_date = booking_date;
        this.seat = seat;
    }
    public Reservation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDate booking_date) {
        this.booking_date = booking_date;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", passenger=" + passenger.getName() +
                ", flight=" + flight.getId() +
                ", booking_date=" + booking_date +
                ", seat='" + seat + '\'' +
                '}';
    }
}
