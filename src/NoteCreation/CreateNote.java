package NoteCreation;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import Frames.*;
import Views.AddNote;
import javafx.scene.control.TextField;

public class CreateNote {

    public CreateNote(String fn) {
        createNewFile(fn);
    }

    void createNewFile(String fn) {
        try {
            File myObj = new File(fn + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addText() {

    }

    // public TextField getfilename() {
    // return fileName;
    // }
}
