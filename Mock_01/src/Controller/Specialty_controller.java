package Controller;

import Entity.Specialty;
import Model.Specialty_model;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Specialty_controller {
    Specialty_model specialtyModel = new Specialty_model();

    public boolean isEmpty(){
        if (specialtyModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no Specialties to show!");
            return true;
        }
        return false;
    }
    public void AddSpecialty(){
        Specialty specialty = new Specialty();

        String specialtyName = JOptionPane.showInputDialog("Type the name of the specialty");
        String specialtyDescription = JOptionPane.showInputDialog("Type the description of " + specialtyName);
        specialty.setName(specialtyName);
        specialty.setDescription(specialtyDescription);

        specialtyModel.create(specialty);
    }
    public List<String> showSpecialties(){

        String specialtyInfo = "Specialties: \n";
        String specialtyNameId = "";


        for (Object specialtyObj : specialtyModel.read()){
            Specialty specialty = (Specialty) specialtyObj;

            specialtyInfo += "-> " + specialty.getName() + " -Id: " + specialty.getId()+ ", -Description: " + specialty.getDescription() + "\n";
            specialtyNameId += "-> " + specialty.getName() + " -Id: " + specialty.getId()+"\n";
        }
        List<String> list = new ArrayList<>();
        list.add(specialtyInfo);
        list.add(specialtyNameId);
        return  list;
    }
    public void deleteSpecialty(){
        if (isEmpty()) return;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(showSpecialties().get(1) + "\n Type the id of the Specialty you want to delete"));

        if (specialtyModel.findById(idDelete) == null){
            JOptionPane.showMessageDialog(null,"Specialty not found, type an existing Id!");
            return;
        }

        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Specialty? \n" + specialtyModel.findById(idDelete).toString());
        if (question == 0){
            specialtyModel.delete(idDelete);
        }
    }
    public void filterById(){
        if (isEmpty()) return;

        int id = Integer.parseInt(JOptionPane.showInputDialog(showSpecialties().get(1)+ "Type the id of the specialty you want to search"));
        Specialty specialty = (Specialty) specialtyModel.findById(id);
        if(specialty == null){
            JOptionPane.showMessageDialog(null,"Specialty not found, type an existing Id!");
        } else {
            JOptionPane.showMessageDialog(null,specialty.toString());
        }
    }
    public void updateSpecialty(){
        if (isEmpty())return;
        int id = Integer.parseInt(JOptionPane.showInputDialog(showSpecialties().get(1)+"Type the id of the specialty you want to update"));
        Specialty specialty = (Specialty) specialtyModel.findById(id);
        if(specialty == null){
            JOptionPane.showMessageDialog(null,"Specialty not found, type an existing Id!");
        } else {
            String newName = JOptionPane.showInputDialog("Type the new name");
            String description = JOptionPane.showInputDialog("Type a new description");
            specialty.setName(newName);
            specialty.setDescription(description);
            specialtyModel.update(specialty);
        }
    }
}
