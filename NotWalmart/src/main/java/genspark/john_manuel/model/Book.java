package genspark.john_manuel.model;

public class Book extends Product {

    public String genre;
    public String author;
    public String publications;

    public Book() {}

    public String getGenre() {return genre;}
    public String getAuthor() {return author;}
    public String getPublications() {return publications;}

    public void setGenre( String genre ) {this.genre = genre;}
    public void setAuthor( String author ) {this.author = author;}
    public void setPublications( String publications ) {this.publications = publications;}
    
    @Override
    public double getPrice(){
        return 0;
    }
}
