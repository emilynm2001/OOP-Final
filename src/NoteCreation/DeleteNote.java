package NoteCreation;

import java.io.File; // Import the File class
// import Frames.*;
// import Views.AddNote;
// import javafx.scene.control.TextField;

public class DeleteNote {
    public String NoteName;
    private boolean success;

    public DeleteNote(String fn, String txt, CreateNote cNote) {
        deleteFile(fn, txt);
        cNote.getHashMap().remove(fn);
    }

    public boolean isSuccessful() {
        return success;
    }

    void deleteFile(String fn, String txt) {
        File myObj = new File(fn + ".txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file:  " + myObj.getName());
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
