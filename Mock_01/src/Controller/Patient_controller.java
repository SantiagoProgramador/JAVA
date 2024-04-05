package Controller;

import Entity.Patient;
import Entity.Specialty;
import Model.Patient_model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient_controller {
    Patient_model patientModel = new Patient_model();

    public Boolean isEmpty(){
        if (patientModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no patients to show!");
            return true;
        }
        return false;
    }
    public void addPatient(){
        Patient patient = new Patient();

        String name = JOptionPane.showInputDialog("Type the name of the patient");
        String surname = JOptionPane.showInputDialog("Type the surname of the patient");
        String id = JOptionPane.showInputDialog("Type the identification document of the patient");
        String birthdate = JOptionPane.showInputDialog("Type the birthdate of the patient (YYYY-MM-DD)");
        patient.setName(name);
        patient.setSurname(surname);
        patient.setBirthdate(LocalDate.parse(birthdate));
        patient.setIdentification_document(id);

        patientModel.create(patient);
    }
    public List<String> showPatients(){

        String patientInfo = "Patients: \n";
        String patientNameId = "";


        for (Object patientObj : patientModel.read()){
            Patient patient = (Patient) patientObj;

            patientInfo += "-> " + patient.getName() + " " + patient.getSurname() +" -Id: " + patient.getId()+ ", -Birthdate: " + patient.getBirthdate() + " -Document: " +patient.getIdentification_document() +"\n";
            patientNameId += "-> " + patient.getName() +" "+patient.getSurname() + " -Id: " + patient.getId()+"\n";
        }
        List<String> list = new ArrayList<>();
        list.add(patientInfo);
        list.add(patientNameId);
        return  list;
    }
    public void deletePatient(){
        if (isEmpty()) return;
        int id = Integer.parseInt(JOptionPane.showInputDialog(showPatients().get(1)+"Type the id of the patient you want to delete"));
        Patient patient = (Patient) patientModel.findById(id);
        if (patient == null){
            JOptionPane.showMessageDialog(null,"Patient not found, Type an existing id!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete this patient?");
        if (question == 0){
            patientModel.delete(id);
        }
    }
    public void filterById(){
        if (isEmpty()) return;
        int id = Integer.parseInt(JOptionPane.showInputDialog(showPatients().get(1)+"Type the id of the patient you want to search"));
        Patient patient = (Patient) patientModel.findById(id);
        if (patient == null){
            JOptionPane.showMessageDialog(null,"Patient not found, Type an existing Id!");
        } else {
            JOptionPane.showMessageDialog(null,patient.toString());
        }
    }
    public void updatePatient(){
        if (isEmpty())return;
        int id = Integer.parseInt(JOptionPane.showInputDialog(showPatients().get(1)+"Type the id of the patient you want to update"));
        Patient patient = (Patient) patientModel.findById(id);
        if (patient == null){
            JOptionPane.showMessageDialog(null,"Patient not found, Type an existing Id!");
        } else {
            String newName = JOptionPane.showInputDialog("Type the new name");
            String newSurname = JOptionPane.showInputDialog("Type the new surname");
            String newBirthdate = JOptionPane.showInputDialog("Type the new Birthdate (YYYY-MM-DD)");
            String newId = JOptionPane.showInputDialog("Type the new identification document of the patient");
            patient.setName(newName);
            patient.setSurname(newSurname);
            patient.setBirthdate(LocalDate.parse(newBirthdate));
            patient.setIdentification_document(newId);
            patientModel.update(patient);
        }
    }
}
