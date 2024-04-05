package Controller;

import Entity.Doctor;
import Entity.Patient;
import Entity.Specialty;
import Model.Doctor_model;

import javax.print.Doc;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Doctor_controller {
    Doctor_model doctorModel = new Doctor_model();
    Specialty_controller specialtyController = new Specialty_controller();

    public boolean isEmpty(){
        if (doctorModel.read().isEmpty()) {
            JOptionPane.showMessageDialog(null,"There is no doctors to show!");
            return true;
        }
        return false;
    }
    public void addDoctor(){
        if (isEmpty()) return;
        Doctor doctor = new Doctor();
        String name = JOptionPane.showInputDialog("Type the name of the doctor");
        String surname = JOptionPane.showInputDialog("Type the surname of the doctor");
        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog(specialtyController.showSpecialties().get(1) +"Type the Id of the specialty of the doctor"));
        Specialty specialty = (Specialty) specialtyController.specialtyModel.findById(specialtyId);
        if (specialty == null){
            JOptionPane.showMessageDialog(null,"Specialty not found, Type an existing Id!");
        } else {
            doctor.setName(name);
            doctor.setSurname(surname);
            doctor.setSpecialty(specialty);
            doctorModel.create(doctor);
        }
    }
    public List<String> showDoctors(){

        String doctorInfo = "Doctors: \n";
        String doctorNameId = "";

        for (Object doctorObj : doctorModel.read()){
            Doctor doctor = (Doctor) doctorObj;

            doctorInfo += "-> " + doctor.getName() + " " + doctor.getSurname() +" -Id: " + doctor.getId()+ "  Specialty: " + doctor.getSpecialty() +"\n";
            doctorNameId += "-> " + doctor.getName() +" "+doctor.getSurname() + " -Id: " + doctor.getId()+"\n";
        }
        List<String> list = new ArrayList<>();
        list.add(doctorInfo);
        list.add(doctorNameId);
        return  list;
    }
    public void deleteDoctor(){
        if(isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showDoctors().get(1)+"Type the id of the doctor you want to delete"));
        Doctor doctor = (Doctor) doctorModel.findById(id);
        if (doctor == null){
            JOptionPane.showMessageDialog(null,"Doctor not found, type an existing Id!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this doctor?");
        if (question == 0){
            doctorModel.delete(id);
        }
    }
    public void filterById(){
        if (isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showDoctors().get(1)+"Type the id of the doctor you want to search"));
        Doctor doctor = (Doctor) doctorModel.findById(id);
        if (doctor == null){
            JOptionPane.showMessageDialog(null,"Doctor not found, type an existing Id!");
        }else{
            JOptionPane.showMessageDialog(null,doctor.toString());
        }
    }
    public void updateDoctor(){
        if (isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showDoctors().get(1)+"Type the id of the doctor you want to update"));
        Doctor doctor = (Doctor) doctorModel.findById(id);
        if (doctor == null){
            JOptionPane.showMessageDialog(null,"Doctor not found, type an existing Id!");
            return;
        }
        String newName = JOptionPane.showInputDialog("Type the new name of the doctor");
        String newSurname = JOptionPane.showInputDialog("Type the new surname of the doctor");
        int newSpecialtyId = Integer.parseInt(JOptionPane.showInputDialog(specialtyController.showSpecialties().get(1) +"Type the Id of the specialty of the doctor"));
        Specialty specialty = (Specialty) specialtyController.specialtyModel.findById(newSpecialtyId);
        if (specialty == null){
            JOptionPane.showMessageDialog(null,"Specialty not found, Type an existing Id!");
        } else {
            doctor.setName(newName);
            doctor.setSurname(newSurname);
            doctor.setSpecialty(specialty);
            doctorModel.update(doctor);
        }
    }
}
