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
    public String state = "Home_View";

    public Content() {
        addNoteView = new AddNote();
        homeView = new HomePage();
        viewNoteView = new ViewNote();
        editNoteView = new EditNote();
    }

    public AnchorPane getContent() {
        if (state.equals("AddNote_View")) {
            addNoteView.getSaveButton().setOnMouseReleased(event -> {
                addNoteView.onClick();
                this.sMenu.addHBox(addNoteView.getNoteNames());
                addNoteView.clearTxtFields();
            });
            return addNoteView;
        }
        if (state.equals("ViewNote_View")) {
            if (!(addNoteView.getNoteNames().isEmpty())) {
                if (this.sMenu.getHashKey().equals("")) {
                    viewNoteView.noteSelectPrompt();
                } else {
                    viewNoteView.noteSpecifier(this.sMenu.getHashKey(), addNoteView.getCreateNote());
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

    public String getName() {
        return this.name;
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
