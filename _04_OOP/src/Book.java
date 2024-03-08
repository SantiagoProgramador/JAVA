public class Book {

    private String title;
    private String author;
    private String publicationDate;
    private boolean isBooked;

    public Book(String title, String author, String publicationDate, boolean isBooked) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isBooked = isBooked;
    }

    public String getTitle(){return this.title;}
    public String getAuthor(){return  this.author;}
    public String getPublicationDate(){return this.publicationDate;}
    public boolean getIsBooked(){return this.isBooked;}
    // another way
    public void changeState(){
        this.isBooked = !this.isBooked;
        System.out.println("State of the book changed correctly.");
    }

    public void setTitle(String title){this.title = title;}
    public void setAuthor(String author){this.author = author;}
    public void setPublicationDate(String publicationDate){this.publicationDate = publicationDate;}
    public void setIsBooked(boolean isBooked ){this.isBooked = isBooked;}

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}
