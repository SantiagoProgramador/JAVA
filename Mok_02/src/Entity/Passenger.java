package Entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private int id;
    private String name;
    private String surname;
    private String identification_document;
    private ArrayList<Reservation> reservation_list = new ArrayList<>();

    public Passenger(int id, String name, String surname, String identification_document) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identification_document = identification_document;
        this.reservation_list = new ArrayList<>();
    }
    public Passenger(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentification_document() {
        return identification_document;
    }

    public void setIdentification_document(String identification_document) {
        this.identification_document = identification_document;
    }

    public ArrayList<Reservation> getReservation_list() {
        return reservation_list;
    }

    public void setReservation_list(ArrayList<Reservation> reservation_list) {
        this.reservation_list = reservation_list;
    }
    public void addReservation(Reservation reservation){
        this.reservation_list.add(reservation);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", identification_document='" + identification_document + '\'' +
                ", reservation_list=" + reservation_list +
                '}';
    }
}
