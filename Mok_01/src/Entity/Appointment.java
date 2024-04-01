package Entity;

public class Appointment {
    //Attributes
    private int id;
    private int date;
    private int hour;
    private String motive;
    private Patient patient;
    private Doctor doctor;

    //Constructor
    public Appointment(int id, int date, int hour, String motive, Patient patient, Doctor doctor) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
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
