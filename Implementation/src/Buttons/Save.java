package Buttons;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Save {
    private Button save;
    public Group group;
    public Stage stage;
    public ObservableList<String> items;

    public void init(Group group, Stage stage, ObservableList<String> items) {
        this.group = group;
        this.stage = stage;
        this.items = items;
        save = new Button();
        save.setText("Save memory");
        save.setLayoutX(240);
        save.setLayoutY(600);
        this.group.getChildren().add(save);
    }

    public void handleSave(File file, ObservableList<String> items) throws IOException {


            FileOutputStream fos= new FileOutputStream(file);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            ArrayList<String> arrayList = new ArrayList(items);
            oos.writeObject(arrayList);
            oos.close();
            fos.close();

    }

    public void setButton(Group g, Stage s, ObservableList<String> i) {
        init(g, s, i);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select memory file");
                File file = null;
                file = fileChooser.showSaveDialog(stage);
                if(file != null) {
                    try {
                        handleSave(file,items);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
