package week3;
public abstract class Book {
    private String name;
    private String author;
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    
    // Getters and setters
    public String getName() { return name; }
    public String getAuthor() { return author; }
    
    // Abstract method for genre-specific info
    public abstract String getGenreDescription();
    
    @Override
    public String toString() {
        return String.format("%s by %s", name, author);
    }
}