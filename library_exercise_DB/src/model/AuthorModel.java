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

public class AuthorModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection connection = ConfigDB.openConnection();
        Author author = (Author) object;

        try {
            String sql = "INSERT INTO author (name,nationality) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,author.getName());
            preparedStatement.setString(2,author.getNationality());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                author.setId(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Author successfully added!: " + author.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return author;
    }

    @Override
    public List<Object> read() {
        Connection connection = ConfigDB.openConnection();
        List<Object> authorList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM author LEFT JOIN book ON author.id = book.author_id;";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){

                Author author = new Author();

                author.setName(resultSet.getString("name"));
                author.setId(resultSet.getInt("id"));
                author.setNationality(resultSet.getString("nationality"));
                List<Book> bookList = new ArrayList<>();
                authorList.add(author);

                Book book = new Book();
                book.setAuthorId(resultSet.getInt("author_id"));

                if (book.getAuthorId() != 0){
                    book.setTitle(resultSet.getString("title"));
                    book.setPublication_date(resultSet.getInt("publication_date"));
                    book.setPrice(resultSet.getDouble("price"));
                    book.setId(resultSet.getInt("id"));
                    bookList.add(book);
                    author.setBookList(bookList);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong..." + e);
        }
        ConfigDB.closeConnection();
        return authorList;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();
        Author author = (Author) object;
        try {
            String sql = "UPDATE author SET name = '" + author.getName() + "' ,nationality = '" + author.getNationality() + "' WHERE id = " + author.getId();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                author.setId(resultSet.getInt("id"));
            }
            JOptionPane.showMessageDialog(null,"Author was successfully updated!: " + author.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return true;
    }
    public Object findById(int id){
        Connection connection = ConfigDB.openConnection();
        Author author = null;

        try {
            String sql = "SELECT * FROM author WHERE id =" + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setNationality(resultSet.getString("nationality"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
        return author;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConfigDB.openConnection();

        try{
            String sql = "DELETE FROM author WHERE id = " + id;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            int rowsAfeccted = preparedStatement.executeUpdate();
            if (rowsAfeccted > 0){
                JOptionPane.showMessageDialog(null, "Author deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null,"The author was not found or something went wrong...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Something went wrong... " + e);
        }
        ConfigDB.closeConnection();
    }
}
