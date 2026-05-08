package app;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String newFileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + newFileName + ".txt";

        try {
            handler.createFile(path);
            handler.writeToFile(path, content);

            String fileContent = handler.readFromFile(path);
            System.out.println("CONTENT: " + fileContent);

        } catch (FileProcessingException e) {
            System.out.println("Application error: " + e.getMessage());
        }
    }
}