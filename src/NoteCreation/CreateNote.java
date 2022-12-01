package NoteCreation;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
// import Frames.*;
// import Views.AddNote;
// import javafx.scene.control.TextField;
import java.util.HashMap;

public class CreateNote {
    public String NoteName;
    private boolean success;
    final HashMap<String, String> notes = new HashMap<>();

    public CreateNote(String fn, String txt) {
        createNewFile(fn, txt);
        notes.put(fn, txt);
    }

    public HashMap<String, String> getHashMap() {
        return this.notes;
    }

    public boolean isSuccessful() {
        return success;
    }

    void createNewFile(String fn, String txt) {
        try {
            File myObj = new File(fn + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                setNote(myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter(myObj.getName());
                    myWriter.write(txt);
                    myWriter.close();
                    setNote(myObj.getName());
                    System.out.println("Successfully wrote to the file.");
                    this.success = true;
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    this.success = false;
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
                this.success = false;

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            this.success = false;

            e.printStackTrace();
        }
    }

    public void setNote(String note) {
        this.NoteName = note;
    }

    public String getNote() {
        return this.NoteName;
    }

    public void addText() {

    }

    // public TextField getfilename() {
    // return fileName;
    // }
}
