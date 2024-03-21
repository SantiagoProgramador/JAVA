import controller.AuthorController;
import database.ConfigDB;
import helpers.Authormenu;
import helpers.Bookmenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Authormenu authormenu = new Authormenu();
        Bookmenu bookmenu = new Bookmenu();
        String option = "";
        do {
            try{
                option = JOptionPane.showInputDialog("""
                        Welcome to your online library :D
                        Menu:
                        1. Authors Menu.
                        2. Books menu.
                        3. Exit.
                        Please select an option:
                        """);
                switch (option){
                    case "1":
                        authormenu.AuthorMenu();
                        break;
                    case "2":
                        bookmenu.BooksMenu();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,"Thanks for using your online library :D!");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again..." + e);
            }
        }while (!option.equals("3"));

    }
}
