package entities;

public class Book {

    String author;
    String name;
    String isbn;
    public Book(String isbn,String author, String name) {
        this.author = author;
        this.name = name;
        this.isbn =isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
