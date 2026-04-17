package fileHandlings;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileCreate {
    public static void main(String[] args) {
        File file = new File("sample.txt"); // Create a File object
        
        if (file.exists()) { // Check if the file exists
            System.out.println("The file exists"); // Print file properties
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File size: " + file.length() + " bytes");
        } else {
            System.out.println("The file doesn't exist");
            
            // Create the file automatically
            try {
                if (file.createNewFile()) {
                    System.out.println("File created successfully: " + file.getName());
                    
                    // Optionally write some content to the file
                    FileWriter writer = new FileWriter(file);
                    writer.write("Hello, World!");
                    writer.close();
                    System.out.println("Sample content written to file.");
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }
}