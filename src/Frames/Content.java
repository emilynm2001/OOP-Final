package Frames;

import javafx.scene.layout.AnchorPane;
import Views.AddNote;
import Views.EditNote;
import Views.HomePage;
import Views.ViewNote;

public class Content {
    private AddNote addNoteView;
    private HomePage homeView;
    private ViewNote viewNoteView;
    private EditNote editNoteView;
    public String name;
    private SideMenu sMenu;
    // String state = "List_View";
    public String state = "Home_View";
    // public IntegerProperty stateKey = new SimpleIntegerProperty(0);

    public Content() {
        addNoteView = new AddNote();
        homeView = new HomePage();
        viewNoteView = new ViewNote();
        editNoteView = new EditNote();
    }

    // void setStyles() {
    // setStyle("-fx-background-color: lightblue; -fx-border-color: black;");
    // }

    public AnchorPane getContent() {
        System.out.println("this is the state: " + state);
        if (state.equals("AddNote_View")) {
            addNoteView.getSaveButton().setOnMouseReleased(event -> {
                // CreateNote newNote = new CreateNote(addNoteView.getFileName(),
                addNoteView.onClick();
                // getNoteNames().add(addNoteView.getFileName());
                this.sMenu.addHBox(addNoteView.getNoteNames());
                // setName(addNoteView.getFileName());
                System.out.println("CONTENT");
                addNoteView.clearTxtFields();
            });
            // addNoteView.getCancelButton().setOnMouseReleased(event -> {
            // this.state = "HomePage_View";
            // getContent();
            // });

            return addNoteView;
        }
        if (state.equals("ViewNote_View")) {
            if (!(addNoteView.getNoteNames().isEmpty())) {
                System.out.println("**********************" + this.sMenu.getHashKey().equals(""));
                if (this.sMenu.getHashKey().equals("")) {
                    viewNoteView.noteSelectPrompt();
                } else {
                    viewNoteView.noteSpecifier(this.sMenu.getHashKey(), addNoteView.getCreateNote());
                    System.out.println("Viewing Note titled: " + this.sMenu.getHashKey());
                    viewNoteView.addEditAndDelete();
                }
            }
            return viewNoteView;
        }
        if (state.equals("HomePage_View")) {
            return homeView;
        }
        if (state.equals("EditNote_View")) {
            editNoteView.addNoteToView(viewNoteView.getKey(), viewNoteView.getNote(),
                    viewNoteView.getCreateNote());
            return editNoteView;
        }

        return homeView;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void addStyles() {
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSideMenu(SideMenu sMenu) {
        this.sMenu = sMenu;
    }

    public AddNote getAddNote() {
        return this.addNoteView;
    }
}
