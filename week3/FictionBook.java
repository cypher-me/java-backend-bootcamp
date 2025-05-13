package week3;

public class FictionBook extends Book {
    private String subGenre; // e.g., Fantasy, Sci-Fi
    
    public FictionBook(String name, String author, String subGenre) {
        super(name, author);
        this.subGenre = subGenre;
    }
    
    @Override
    public String getGenreDescription() {
        return String.format("Fiction (%s)", subGenre);
    }
}
