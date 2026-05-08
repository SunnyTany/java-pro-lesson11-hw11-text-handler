package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    // Takes a path string, creates a file, and returns the result
    public String createFile(String path) {
        Path newFile;
        try {
            // Use Paths.get() or Path.of() to create a Path object
            newFile = Files.createFile(Paths.get(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    // Writes content to the file at the specified Path
    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    // Reads content from a file and returns it as a string
    public String readFromFile(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
    }
}