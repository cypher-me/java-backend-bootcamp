import java.io.*;
import java.util.*;

public class FileWordCounter {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner input = new Scanner(System.in);
        
        System.out.println("--- Simple Word Counter ---");
        System.out.print("Enter file path: ");
        String filePath = input.nextLine();
        
        try {
            // Count words in the file
            int count = countWords(filePath);
            System.out.println("This file contains " + count + " words.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error reading the file!");
        } finally {
            input.close();
        }
    }
    
    public static int countWords(String filePath) throws IOException {
        int wordCount = 0;
        Scanner fileScanner = new Scanner(new File(filePath));
        
        // Count words one by one
        while (fileScanner.hasNext()) {
            fileScanner.next(); // Move to next word
            wordCount++;
        }
        
        fileScanner.close();
        return wordCount;
    }
}