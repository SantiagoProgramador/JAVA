package Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.spi.LocaleNameProvider;

public class Appointment {
    //Attributes
    private int id;
    private LocalDate date;
    private LocalTime hour;
    private String motive;
    private Patient patient;
    private Doctor doctor;

    //Constructor
    public Appointment(int id, LocalDate date, LocalTime hour, String motive, Patient patient, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.motive = motive;
        this.patient = patient;
        this.doctor = doctor;
    }
    public Appointment(){}

    //Setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    //ToString
    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", motive='" + motive + '\'' +
                ", patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                '}';
    }
}
