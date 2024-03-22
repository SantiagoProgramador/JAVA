package controller;

import entity.Author;
import entity.Book;
import model.AuthorModel;
import model.BookModel;

import javax.swing.*;
import java.util.ArrayList;

public class BookController {
    BookModel bookModel;
    AuthorModel authorModel;
    AuthorController authorController;

    public BookController(){
        this.bookModel = new BookModel();
        this.authorModel = new AuthorModel();
        this.authorController = new AuthorController();
    }
    public void addBook(){
        Book book;
        ArrayList<Book> bookList = new ArrayList<>();

        String bookTitle = JOptionPane.showInputDialog("Type the title of the book: ");
        int bookPublication_date = Integer.parseInt(JOptionPane.showInputDialog("Type the year of publication of the book: "));
        double bookPrice = Double.parseDouble(JOptionPane.showInputDialog("Type the price of the book: "));

        int idAuthor = Integer.parseInt(JOptionPane.showInputDialog(authorController.showAuthors() +"\nType the author's id of this book:"));
        Author author = (Author) authorModel.findById(idAuthor);
        if (author == null){
            JOptionPane.showMessageDialog(null,"The author was not found!");
        } else {
            book = new Book(bookTitle,bookPublication_date,bookPrice,idAuthor);
            this.bookModel.create(book);
            bookList.add(book);
            author.setBookList(bookList);
            JOptionPane.showMessageDialog(null,"Book added successfully!");
        }
    }
    public String showBooks(){
        if (this.bookModel.read().isEmpty()){
            return  "There arent books yet!";
        }
        String bookList = "Below the current books: \n";

        for (Object object : this.bookModel.read()){
            Book book = (Book) object;
            bookList += book.toString() + "\n";
        }
        return bookList;
    }
    public void deleteBook(){
        if (this.bookModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nothing to delete!");
            return;
        }
        String bookList = showBooks();
        int option = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(bookList + "\nType the id of the book you want to delete"));
        option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this book?");
        if (option == 0) this.bookModel.delete(idDelete);
    }
    public void updateBook(){
        if (this.bookModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nothing to update!");
            return;
        }
        String bookList = showBooks();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(bookList + "\nType the id of the book you want to update: "));
        Book book = (Book) this.bookModel.findById(idUpdate);

        if (book == null){
            JOptionPane.showMessageDialog(null,"The book was not found!");
        } else {
            String newTitle = JOptionPane.showInputDialog("Type the new title of the book:");
            int newPublicationDate = Integer.parseInt(JOptionPane.showInputDialog("Type the new year of publication of the book:"));
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Type the new price of the book:"));
            book = new Book(idUpdate,newTitle,newPrice,newPublicationDate);
            this.bookModel.update(book);
        }
    }
    public void searchBook(){
        if (this.bookModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nothing to search!");
            return;
        }
        String option = JOptionPane.showInputDialog("""
                Type 1 to search by id
                Type 2 to search by title
                Type 3 to search by author
                """);
        switch (option){
            case "1":
                int id = Integer.parseInt(JOptionPane.showInputDialog(showBooks() + " Type the id of the book"));
                if (this.bookModel.findById(id) == null){
                    JOptionPane.showMessageDialog(null,"The book is not in the library");
                }
                JOptionPane.showMessageDialog(null,"Below the book you want to search " + this.bookModel.findById(id).toString());
                break;
            case "2":
                String title = JOptionPane.showInputDialog(showBooks() + " Type the title of the book ");
                if (this.bookModel.findByTitle(title) == null){
                    JOptionPane.showMessageDialog(null,"There are no books in the library with the title: " + title);
                }
                JOptionPane.showMessageDialog(null,"Below the book you want to search " + this.bookModel.findByTitle(title).toString());
                break;
            case "3":
                String author = JOptionPane.showInputDialog(showBooks() + " Type the name of the author of the books you want to search");
                if (this.bookModel.findByAuthor(author) == null){
                    JOptionPane.showMessageDialog(null,"The book is not in the library");
                }
                JOptionPane.showMessageDialog(null,"Below the book you want to search " + this.bookModel.findByAuthor(author).toString());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please enter a valid option");
                break;
        }
    }
}
