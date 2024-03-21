package helpers;

import controller.AuthorController;

import javax.swing.*;

public class Authormenu {
    String optionAuthorMenu;
    AuthorController authorController = new AuthorController();
    public void AuthorMenu(){
        do {
            optionAuthorMenu = JOptionPane.showInputDialog("""
                    Author's Menu
                    1. Add author.
                    2. Show authors.
                    3. Update an author.
                    4. Delete an author.
                    5. EXIT.
                    Please select an option:
                    """);
            switch (optionAuthorMenu){
                case "1":
                    authorController.addAuthor();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null,authorController.showAuthors());
                    break;
                case "3":
                    authorController.updateAuthor();
                    break;
                case "4":
                    authorController.deleteAuthor();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,"Closing the Authors menu...");
                    break;
            }
        } while (!optionAuthorMenu.equals("5"));
    }
}
