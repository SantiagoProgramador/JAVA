package helpers;

import javax.swing.*;

public class Bookmenu {
    String optionBookMenu;
    public void  BooksMenu(){
        do {
            optionBookMenu = JOptionPane.showInputDialog("""
                    Book's Menu
                    1. Add a Book.
                    2. Show Books.
                    3. Search a book by: Id, title or author.
                    4. Update a book.
                    5. Delete a book.
                    6. EXIT.
                    Please select an option:
                    """);
            switch (optionBookMenu){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null,"Closing the Book's menu...");
                    break;
            }
        } while (!optionBookMenu.equals("6"));
    }
}
