package entity;

import java.util.Date;

public class Book{
    private int id;
    private String title;
    private int publication_date;
    private double price;
    private int authorId;

    public Book(int id, String title, double price, int publication_date) {
        this.id = id;
        this.title = title;
        this.publication_date = publication_date;
        this.price = price;
    }
    public Book(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(int publication_date) {
        this.publication_date = publication_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publication_date=" + publication_date +
                ", price=" + price +
                '}';
    }
}
