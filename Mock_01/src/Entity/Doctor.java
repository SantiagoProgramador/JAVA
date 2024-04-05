package Entity;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    //Attributes
    private int id;
    private String name;
    private String surname;
    private List<Object> Appointment_list = new ArrayList<>();
    private Specialty specialty;

    //Constructors
    public Doctor(int id, String name, String surname, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        Appointment_list = new ArrayList<>();
        this.specialty = specialty;
    }

    public Doctor(){}

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

    public List<Object> getAppointment_list() {
        return Appointment_list;
    }

    public void setAppointment_list(List<Object> appointment_list) {
        Appointment_list = appointment_list;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    //ToString

    @Override
    public String toString() {
        String list = this.Appointment_list.isEmpty() ? "The doctor " + this.name + " does not have appointments scheduled" : this.Appointment_list.toString();
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Appointment_list=" + list +
                ", specialty=" + specialty.toString() +
                '}';
    }
}
