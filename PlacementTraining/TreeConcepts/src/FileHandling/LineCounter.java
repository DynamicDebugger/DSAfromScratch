package FileHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) {
        // Replace with the path to your file
        String filePath = "D:/aptitude/basic.txt";

        int lineCount = 0;

        // Try with resources ensures the file is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read through the file line by line
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("The file '" + filePath + "' contains " + lineCount + " lines.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

