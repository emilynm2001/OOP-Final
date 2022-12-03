package NoteCreation;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
// import Frames.*;
// import Views.AddNote;
// import javafx.scene.control.TextField;

public class SaveEdittedNote {
    public String NoteName;
    private boolean success;

    public SaveEdittedNote(String fn, String txt, CreateNote cNote) {
        saveToFile(fn, txt);
        cNote.getHashMap().replace(fn, txt);
    }

    public boolean isSuccessful() {
        return success;
    }

    void saveToFile(String fn, String txt) {
        try {
            File myObj = new File(fn + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File Does Not exist: " + myObj.getName());
            } else {
                System.out.println("File exists.");
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(txt);
                myWriter.close();
                this.success = true;

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
