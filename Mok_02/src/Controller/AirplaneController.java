package Controller;

import Entity.Airplane;
import Model.AirplaneModel;

import javax.swing.*;
import java.util.List;

public class AirplaneController {
    AirplaneModel airplaneModel = new AirplaneModel();

    public boolean isEmpty(){
        if (airplaneModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null, "There is no airplanes to show");
            return true;
        }
        return false;
    }
    public void addAirplane(){
        Airplane airplane = new Airplane();

        String model = JOptionPane.showInputDialog("Type the model of the airplane ");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("Type the capacity of the airplane"));
        airplane.setModel(model);
        airplane.setCapacity(capacity);
        airplaneModel.create(airplane);
    }
    public String showAirplanes(){
        String list = "Airplanes: \n";

        for (Object airplaneObj : airplaneModel.read()){
            Airplane airplane = (Airplane) airplaneObj;
            list += "Id: " + airplane.getId() + ", model: " + airplane.getModel() + ", capacity: " + airplane.getCapacity() + "\n";
        }

        return list;
    }
    public void deleteAirplane(){
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(showAirplanes()+"\nType the id of the airplane you want to delete"));

        Airplane airplane = (Airplane) airplaneModel.findById(idDelete);
        if (airplane == null){
            JOptionPane.showMessageDialog(null,"Airplane not found!");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this airplane? " + airplane.toString());
        if (question == 0){
            airplaneModel.delete(idDelete);
        }
    }
    public void filterById(){
        int idSearch = Integer.parseInt(JOptionPane.showInputDialog(showAirplanes()+"\nType the id of the airplane you want to search"));

        Airplane airplane = (Airplane) airplaneModel.findById(idSearch);
        if (airplane == null){
            JOptionPane.showMessageDialog(null,"Airplane not found!");
            return;
        }
        JOptionPane.showMessageDialog(null,airplane.toString());
    }
    public void updateAirplane(){
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(showAirplanes()+"\nType the id of the airplane you want to update"));

        Airplane airplane = (Airplane) airplaneModel.findById(idUpdate);
        if (airplane == null){
            JOptionPane.showMessageDialog(null,"Airplane not found!");
            return;
        }
        String newModel = JOptionPane.showInputDialog("Type the model of the airplane ");
        int newCapacity = Integer.parseInt(JOptionPane.showInputDialog("Type the capacity of the airplane"));
        airplane.setModel(newModel);
        airplane.setCapacity(newCapacity);
        airplaneModel.update(airplane);
    }

}
