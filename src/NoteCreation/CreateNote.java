package NoteCreation;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
// import Frames.*;
// import Views.AddNote;
// import javafx.scene.control.TextField;

public class CreateNote {
    public String NoteName;

    public CreateNote(String fn, String txt) {
        createNewFile(fn, txt);
    }

    void createNewFile(String fn, String txt) {
        try {
            File myObj = new File(fn + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter(myObj.getName());
                    myWriter.write(txt);
                    myWriter.close();
                    setNote(myObj.getName());
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setNote(String note) {
        NoteName = note;
    }

    public String getNote() {
        return NoteName;
    }

    public void addText() {

    }

    // public TextField getfilename() {
    // return fileName;
    // }
}
