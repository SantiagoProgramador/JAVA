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
        String bookList = "Below the current books: \n";

        for (Object object : this.bookModel.read()){
            Book book = (Book) object;
            bookList += book.toString() + "\n";
        }
        return bookList;
    }
    public void deleteBook(){
        String bookList = showBooks();
        int option = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(bookList + "\nType the id of the book you want to delete"));
        option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this book?");
        if (option == 0) this.bookModel.delete(idDelete);
    }
    public void updateBook(){
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

    }
}
