package Buttons;

import java.io.*;
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

    public void init(Group group, Stage stage, ObservableList<String> items) {
        this.group = group;
        this.stage = stage;
        this.items = items;
        load = new Button();
        load.setText("Load memory");
        load.setLayoutX(120);
        load.setLayoutY(600);
        this.group.getChildren().add(load);
    }

    public ObservableList<String> handleLoad(File file,ObservableList<String> items) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);
            ObservableList<String> readItems;
            readItems = FXCollections.observableList((List<String>)ois.readObject());
            items.clear();
            items.addAll(readItems);
            return items;

    }

    public void setButton(Group g, Stage s, ObservableList<String> i) {
        init(g, s, i);
        //Action
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select memory file");
                File file = null;
                file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    try {
                        items = handleLoad(file, items);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        }

}

