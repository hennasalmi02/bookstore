package backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id

    private String isbn;

    private String title;
    private String author;
    private int publicationYear;
    private double price;

    public Book() { }

    public Book(String isbn, String title, String author, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() { 
        return title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getAuthor() { 
        return author; 
    }
    public void setAuthor(String author) { 
        this.author = author; 
    }

    public int getPublicationYear() { 
        return publicationYear; 
    }
    public void setPublicationYear(int publicationYear) { 
        this.publicationYear = publicationYear; 
    }

    public String getIsbn() { 
        return isbn; 
    }
    public void setIsbn(String isbn) { 
        this.isbn = isbn; 
    }

    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }

    @Override
    public String toString() {
        return "Title= " + title + ", author=" + author + ", Publication year=" + publicationYear + ", isbn=" + isbn + ", price=" + price;
    }
}
