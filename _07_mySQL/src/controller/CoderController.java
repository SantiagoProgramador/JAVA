package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;

public class CoderController {
    CoderModel coderModel = new CoderModel();
    public CoderController(){
        //Create an instance of the model
        this.coderModel = new CoderModel();
    }

    //Method to list all the coders.
    public void getAll(){
        String coderList = "List of the current coders:\n";

        if (this.coderModel.findAll().isEmpty()){
            JOptionPane.showMessageDialog(null,"Theres is no coders to show!");
            return;
        }

        for (Object coderData : this.coderModel.findAll()){
            Coder coder = (Coder) coderData;

            coderList += coder.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null,coderList);
    }

    public void getCoder(String name){
        String coderList = "List of the current coders:\n";

        if (this.coderModel.findByName(name).isEmpty()){
            JOptionPane.showMessageDialog(null,"Theres is no coders with the characters " + name);
            return;
        }

        for (Object coderData : this.coderModel.findByName(name)){
            Coder coder = (Coder) coderData;

            coderList += coder.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null,coderList);

    }

    public void addCoder(){
        Coder coder = new Coder();

        String name = JOptionPane.showInputDialog("Type the name of the new coder: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Type his age: "));
        String clan = JOptionPane.showInputDialog("Type his clan: ");

        coder.setName(name);
        coder.setAge(age);
        coder.setClan(clan);

        coder = (Coder) this.coderModel.insert(coder);

        JOptionPane.showMessageDialog(null, coder.toString());
    }
}
