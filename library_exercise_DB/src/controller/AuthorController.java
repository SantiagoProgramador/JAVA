package controller;

import entity.Author;
import model.AuthorModel;

import javax.swing.*;

public class AuthorController {
    AuthorModel authorModel = new AuthorModel();
    public AuthorController(){
        this.authorModel = new AuthorModel();
    }

    public void addAuthor(){
        Author author = new Author();

        String authorName = JOptionPane.showInputDialog("Type the name of the author:");
        String authorNationality = JOptionPane.showInputDialog("Type the nationality of the author:");

        author.setName(authorName);
        author.setNationality(authorNationality);

        this.authorModel.create(author);

    }

    public String showAuthors(){
        if (this.authorModel.read().isEmpty()){
            return "There arent authors yet!";
        }
        String authorList = "Below the current Authors: \n";

        for (Object object : this.authorModel.read()){
            Author author = (Author) object;
            authorList += author.toString() + "\n";
        }

        return  authorList;
    }

    public void deleteAuthor(){
        if (this.authorModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nothing to delete!");
            return;
        }
        String authorList = showAuthors();
        int option = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(authorList + "\nType the id of the Author you want to delete"));
        option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the author?");

        if (option == 0) this.authorModel.delete(idDelete);

    }

    public void updateAuthor(){
        if (this.authorModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nothing to update!");
            return;
        }
        String authorList = showAuthors();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(authorList + "\nType the id of the Author you want to update:"));
        Author author = (Author) this.authorModel.findById(idUpdate);

        if (author == null){
            JOptionPane.showMessageDialog(null,"The author was not found!");
        } else {
            String name = JOptionPane.showInputDialog("Type the new name of the author: ");
            String nationality = JOptionPane.showInputDialog("Type the new nationality of the author: ");
            author = new Author(idUpdate,name,nationality);
            this.authorModel.update(author);
        }

    }
}
