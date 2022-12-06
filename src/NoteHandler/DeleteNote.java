package NoteHandler;

import java.io.File;

public class DeleteNote {
    public String NoteName;
    private boolean success;

    public DeleteNote(String fn, CreateNote cNote) {
        deleteFile(fn);
        cNote.getHashMap().remove(fn);
    }

    public boolean isSuccessful() {
        return success;
    }

    void deleteFile(String fn) {
        File myObj = new File(fn + ".txt");
        if (myObj.delete()) {
            this.success = true;
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
}
