package entity;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String name;
    private String nationality;
    private List<Book> bookList;

    public  Author(){

    }
    public Author(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.bookList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String strBookList = (this.bookList.isEmpty()) ? "The author doesn't have registered books at the moment" : bookList.toString();
        return "Author {" +
                "id= " + id +
                ", name=' " + name + '\'' +
                ", nationality=' " + nationality + '\'' +
                ", book List= " +  strBookList +
                '}';
    }
}
