package week3;
public class NonFictionBook extends Book {
    private String subject; // e.g., History, Science
    
    public NonFictionBook(String name, String author, String subject) {
        super(name, author);
        this.subject = subject;
    }
    
    @Override
    public String getGenreDescription() {
        return String.format("Non-Fiction (%s)", subject);
    }
}