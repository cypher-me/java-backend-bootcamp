package week3;

import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class LibraryApp {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books by Genre");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addBookMenu();
                    break;
                case 2:
                    removeBookMenu();
                    break;
                case 3:
                    viewBooksByGenre();
                    break;
                case 4:
                    viewAllBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    private static void addBookMenu() {
        System.out.println("\nAdd Book");
        System.out.print("Enter genre (Fiction/Non-Fiction): ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        try {
            Book book;
            if (genre.equalsIgnoreCase("Fiction")) {
                System.out.print("Enter sub-genre: ");
                String subGenre = scanner.nextLine();
                book = new FictionBook(name, author, subGenre);
            } else if (genre.equalsIgnoreCase("Non-Fiction")) {
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine();
                book = new NonFictionBook(name, author, subject);
            } else {
                throw new IllegalArgumentException("Invalid genre");
            }
            
            library.addBook(genre, book);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void removeBookMenu() {
        System.out.println("\nRemove Book");
        System.out.print("Enter genre (Fiction/Non-Fiction): ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter book name to remove: ");
        String name = scanner.nextLine();
        
        if (library.removeBook(genre, name)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found or genre invalid!");
        }
    }
    
    private static void viewBooksByGenre() {
        System.out.print("\nEnter genre to view (Fiction/Non-Fiction): ");
        String genre = scanner.nextLine();
        
        List<Book> books = library.getBooksByGenre(genre);
        if (books.isEmpty()) {
            System.out.println("No books found in this genre!");
        } else {
            System.out.println("\nBooks in " + genre + ":");
            books.forEach(System.out::println);
        }
    }
    
    private static void viewAllBooks() {
        Map<String, List<Book>> allBooks = library.getAllBooks();
        if (allBooks.values().stream().allMatch(List::isEmpty)) {
            System.out.println("No books in the library!");
        } else {
            allBooks.forEach((genre, books) -> {
                System.out.println("\n" + genre + ":");
                books.forEach(System.out::println);
            });
        }
    }
}

