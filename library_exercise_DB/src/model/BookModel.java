package model;

import database.CRUD;
import database.ConfigDB;
import entity.Author;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Book book = (Book) object;
        try {
            String sql = "INSERT INTO book (title,publication_date,price,author_id) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setInt(2,book.getPublication_date());
            preparedStatement.setDouble(3,book.getPrice());
            preparedStatement.setInt(4,book.getAuthorId());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                book.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Book successfully added!: " + book.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return book;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> bookList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM book;";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setId(resultSet.getInt("id"));
                book.setPublication_date(resultSet.getInt("publication_date"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthorId(resultSet.getInt("author_id"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong..." + e);
        }
        ConfigDB.closeConnection();
        return bookList;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Book book = (Book) object;
        try {
            String sql = "UPDATE book SET title = '" + book.getTitle() + "' ,publication_date = '" + book.getPublication_date() + "' ,price = '" + book.getPrice() + "' WHERE id = " + book.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                book.setId(resultSet.getInt("id"));
            }
            JOptionPane.showMessageDialog(null,"Book was successfully updated!: " + book.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();

        try{
            String sql = "DELETE FROM book WHERE id = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAfeccted = preparedStatement.executeUpdate();
            if (rowsAfeccted > 0){
                JOptionPane.showMessageDialog(null, "Book deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The book was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
    }

    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Book book = null;
        try {
            String sql = "SELECT * FROM book WHERE id =" + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setPublication_date(resultSet.getInt("publication_date"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return book;
    }
}
