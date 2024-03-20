package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {
        //1. Open connection
        Connection connection = ConfigDB.openConnection();
        //2. Spell the object
        Coder coder = (Coder) object;
        try {
            String sql = "INSERT INTO coder (name,age,clan) VALUES(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //Assign ? signs to the values we want
            preparedStatement.setString(1,coder.getName());
            preparedStatement.setInt(2,coder.getAge());
            preparedStatement.setString(3,coder.getClan());
            preparedStatement.execute();

            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                coder.setId(resultSet.getInt(1));
            }
            preparedStatement.close();
            JOptionPane.showMessageDialog(null,"Coder was successfully added!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error >> " + e);
        }
        ConfigDB.closeConnection();
        return coder;
    }

    @Override
    public boolean update(Object object) {
        //1. Open connection
        Connection connection = ConfigDB.openConnection();
        //2. Spell the object
        Coder coder = (Coder) object;
        try {
            String sql = "UPDATE coder SET name = ?, age = ?, clan = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement.setString(1,coder.getName());
            preparedStatement.setInt(2,coder.getAge());
            preparedStatement.setString(3,coder.getClan());
            preparedStatement.setInt(4,coder.getId());
            preparedStatement.execute();
            ResultSet resultSet = (ResultSet) preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                coder.setId(resultSet.getInt(1));
            }
            preparedStatement.close();
            JOptionPane.showMessageDialog(null,"Coder was successfully updated! " + coder.toString());

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public boolean delete(Object object) {
        Connection connection = ConfigDB.openConnection();
        Coder coder = (Coder) object;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM coder WHERE coder.id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,coder.getId());
            int RowsAffected = preparedStatement.executeUpdate();

            if (RowsAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The coder was deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null,"Something went wrong, try again!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error >> " + e);
        }
        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        //1. OPEN  THE CONNECTION
        Connection connection = ConfigDB.openConnection();
        //2. Start the list where the registers will be saved.
        List<Object> listCoder = new ArrayList<>();

        try {
            //3. Write the SQL sentence
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4. Use PrepareStatement
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            //5. Execute query / prepare
            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();

            //6. Get results
            while (resultSet.next()){
                Coder coder = new Coder();
                coder.setId(resultSet.getInt("id"));
                coder.setName(resultSet.getString("name"));
                coder.setAge(resultSet.getInt("age"));
                coder.setClan(resultSet.getString("clan"));

                listCoder.add(coder);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data acquisition error" + e);
        }
        //7. Close the connection.
        ConfigDB.closeConnection();

        return listCoder;
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Coder coder = null;

        try{
            String sql = "SELECT * FROM coder WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                coder = new Coder();
                coder.setId(resultSet.getInt("id"));
                coder.setName(resultSet.getString("name"));
                coder.setAge(resultSet.getInt("age"));
                coder.setClan(resultSet.getString("clan"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error >> " + e);
        }
        ConfigDB.closeConnection();
        return coder;
    }

    public List<Object> findByName(String name){
        Connection connection = ConfigDB.openConnection();
        List<Object> listCoder = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE coder.name LIKE '%" + name + "%'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {
                Coder coder = new Coder();
                coder.setId(resultSet.getInt("id"));
                coder.setName(resultSet.getString("name"));
                coder.setAge(resultSet.getInt("age"));
                coder.setClan(resultSet.getString("clan"));

                listCoder.add(coder);
            }
        } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data acquisition error" + e);
            }
            ConfigDB.closeConnection();

        return listCoder;
    }
}
