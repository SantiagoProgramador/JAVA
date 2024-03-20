import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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
                        new AuthorMenu();
                        break;
                    case "2":
                        new BooksMenu();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,"Thanks for using your online library :D!");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Something went wrong, please try again...");
            }
        }while (!option.equals("3"));

    }
}

class AuthorMenu{
    String optionAuthorMenu;
    public  AuthorMenu(){
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
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,"Closing the Authors menu...");
                    break;
            }
        } while (!optionAuthorMenu.equals("5"));
    }
}

class BooksMenu{
    String optionBookMenu;
    public  BooksMenu(){
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
