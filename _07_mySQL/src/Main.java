import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CoderController coderController = new CoderController();

        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. List coders.
                    2. Add Coder.
                    3. Update Coder.
                    4. Delete Coder.
                    5. Get coder by name.
                    6. EXIT.
                    Choose an option:
                    """);
            switch (option){
                case "1":
                    coderController.getAll();
                    break;

                case "2":
                    coderController.addCoder();
                    break;

                case "5":
                    String coderName = JOptionPane.showInputDialog("Type the name of the Coder you are looking for:");
                    coderController.getCoder(coderName);

                    break;
            }

        } while (!option.equals("6"));
    }
}
