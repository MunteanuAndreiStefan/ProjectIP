package Buttons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Load {
    private Button load;
    public Group group;
    public Stage stage;
    public ObservableList<String> items;

    private void init(Group group, Stage stage, ObservableList<String> items) {
        this.group = group;
        this.stage = stage;
        this.items = items;
        load = new Button();
        load.setText("Load memory");
        load.setLayoutX(120);
        load.setLayoutY(600);
        this.group.getChildren().add(load);
    }

    private void handleLoad(Stage stage, ObservableList<String> items) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select memory file");
        File file = null;
        file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            try {
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
                ObservableList<String> readItems;
                readItems = FXCollections.observableList((List<String>)ois.readObject());
                items.clear();
                items.addAll(readItems);
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
            catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
    }

    public void setButton(Group g, Stage s, ObservableList<String> i) {
        init(g, s, i);
        //Action
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLoad(stage, items);
            }
        });
    }

}
