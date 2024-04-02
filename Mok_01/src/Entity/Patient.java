package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    //Attributes
    private int id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String identification_document;
    private List<Object> Appointment_list;

    //Constructor

    public Patient(int id, String name, String surname, LocalDate birthdate, String identification_document) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.identification_document = identification_document;
        Appointment_list = new ArrayList<>();
    }

    public Patient(){}

    //Setters and getters
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdentification_document() {
        return identification_document;
    }

    public void setIdentification_document(String identification_document) {
        this.identification_document = identification_document;
    }

    public List<Object> getAppointment_list() {
        return Appointment_list;
    }

    public void setAppointment_list(List<Object> appointment_list) {
        Appointment_list = appointment_list;
    }

    //ToString
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", identification_document='" + identification_document + '\'' +
                ", Appointment_list=" + Appointment_list.toString() +
                '}';
    }
}
