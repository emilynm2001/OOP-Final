package Frames;

import javafx.scene.layout.BorderPane;

public class mainPane extends BorderPane {
    SideMenu sideMenu;
    Content content = new Content();
    // public static ArrayList<String> NoteNames = new ArrayList<>();

    public mainPane(SideMenu sideMenu) {
        setStyles();
        this.sideMenu = sideMenu;
        setLeft(sideMenu);
        getState(0);
        // setCenter(content.getContent());
        setTop(sideMenu.getSeparator("h"));
        content.setSideMenu(this.sideMenu);

        // content.getContent().setAlign
    }

    void setStyles() {
        setStyle("-fx-border-color: #FDFFDF;");
    }

    public SideMenu getSideMenu() {
        return this.sideMenu;
    }

    public void getState(int x) {
        switch (x) {
            case 0: {
                content.setState("HomePage_View");
                setCenter(content.getContent());
                break;
            }
            case 1: {
                content.setState("AddNote_View");
                System.out.println("button clicked");
                setCenter(content.getContent());
                break;
            }
            case 2: {
                content.setState("ViewNote_View");
                setCenter(content.getContent());
                break;

            }
            case 3: {
                content.setState("EditNote_View");
                setCenter(content.getContent());
                break;

            }
            default: {
                content.setState("HomePage_View");
                setCenter(content.getContent());
            }
        }
    }

    public String getName() {
        return content.getName();

    }

    public void viewClass() {
        content.setState("ViewNote_View");
        setCenter(content.getContent());
        this.sideMenu.newNoteButton.setVisible(true);

    }
}
