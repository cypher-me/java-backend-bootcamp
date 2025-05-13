package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, List<Book>> booksByGenre;
    
    public Library() {
        booksByGenre = new HashMap<>();
        // Initialize with supported genres
        booksByGenre.put("Fiction", new ArrayList<>());
        booksByGenre.put("Non-Fiction", new ArrayList<>());
    }
    
    public void addBook(String genre, Book book) {
        if (!booksByGenre.containsKey(genre)) {
            throw new IllegalArgumentException("Unsupported genre: " + genre);
        }
        booksByGenre.get(genre).add(book);
    }
    
    public boolean removeBook(String genre, String bookName) {
        if (!booksByGenre.containsKey(genre)) {
            return false;
        }
        
        List<Book> genreBooks = booksByGenre.get(genre);
        return genreBooks.removeIf(book -> book.getName().equalsIgnoreCase(bookName));
    }
    
    public List<Book> getBooksByGenre(String genre) {
        return new ArrayList<>(booksByGenre.getOrDefault(genre, new ArrayList<>()));
    }
    
    public Map<String, List<Book>> getAllBooks() {
        Map<String, List<Book>> copy = new HashMap<>();
        booksByGenre.forEach((genre, books) -> copy.put(genre, new ArrayList<>(books)));
        return copy;
    }
}