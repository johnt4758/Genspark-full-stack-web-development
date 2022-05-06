package genspark.john_manuel.backend.models;

import javax.persistence.Entity;

@Entity
public class Book extends Product{
    
    private long id;
    private String genre;
    private String author;
    private int publishedDate;
    
    public Book(){}
    
    public Book(String genre, String author, int publishedDate){
        this.genre = genre;
        this.author = author;
        this.publishedDate = publishedDate;
    }
    
    public Book(long id, String name, Double price, String pictureUrl, String genre, String author, int publishedDate){
        super(id, name, price, pictureUrl);
        this.genre = genre;
        this.author = author;
        this.publishedDate = publishedDate;
    }
    
    public String getGenre(){return genre;}
    public String getAuthor(){return author;}
    public int getPublishedDate(){return publishedDate;}
    
    public void setGenre(String genre){this.genre = genre;}
    public void setAuthor(String author){this.author = author;}
    public void setPublishedDate(int publishedDate){this.publishedDate = publishedDate;}
}
