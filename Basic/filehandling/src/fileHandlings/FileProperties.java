package fileHandlings;
import java.io.File;

public class FileProperties {
    public static void main(String[] args) {
        File file = new File("sample.txt"); // Create a File object
        
        if (file.exists()) { // Check if the file exists
            System.out.println("The file exists"); // Print file properties
            System.out.println("file name is : " + file.getName()); 
            System.out.println("Absolute path: " + file.getAbsolutePath()); // Print absolute path
            System.out.println("Writable: " + file.canWrite()); // Check if the file is writable
            System.out.println("Readable: " + file.canRead()); // Check if the file is readable
            System.out.println("File size: " + file.length() + " bytes"); // Print file size
        } else {
            System.out.println("The file doesn't exist"); // Print message if the file does not exist
        }
    }
}