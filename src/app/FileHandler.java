package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    // Takes a path string, creates a file
    public void createFile(String pathStr) {
        try {
            Files.createFile(Path.of(pathStr));
            System.out.println("Created " + pathStr);
        } catch (IOException e) {
            System.out.println("Error creating a file by path: " + pathStr);
            throw new FileProcessingException(e);
        }
    }

    // Writes content to the file at the specified Path
    public void writeToFile(String pathStr, String content) {
        try {
            Files.writeString(Path.of(pathStr), content);
            System.out.println("Recorded in " + pathStr);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + pathStr);
            throw new FileProcessingException(e);
        }
    }

    // Reads content from a file and returns it as a string
    public String readFromFile(String pathStr) {
        try {
            return Files.readString(Path.of(pathStr));
        } catch (IOException e) {
            System.out.println("Error reading file: " + pathStr);
            throw new FileProcessingException(e);
        }
    }
}