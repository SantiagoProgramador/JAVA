package Entity;

import java.util.ArrayList;

public class Doctor {
    //Attributes
    private int id;
    private String name;
    private String surname;
    private ArrayList<Appointment> Appointment_list;
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

    public ArrayList<Appointment> getAppointment_list() {
        return Appointment_list;
    }

    public void setAppointment_list(ArrayList<Appointment> appointment_list) {
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
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Appointment_list=" + Appointment_list.toString() +
                ", specialty=" + specialty.toString() +
                '}';
    }
}
