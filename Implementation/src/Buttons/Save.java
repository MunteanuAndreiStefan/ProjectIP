package Buttons;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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

    private void init(Group group, Stage stage, ObservableList<String> items) {
        this.group = group;
        this.stage = stage;
        this.items = items;
        save = new Button();
        save.setText("Save memory");
        save.setLayoutX(240);
        save.setLayoutY(600);
        this.group.getChildren().add(save);
    }

    private void handleSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select memory file");
        File file = null;
        file = fileChooser.showSaveDialog(stage);
        if(file != null) {
            try{
                FileOutputStream fos= new FileOutputStream(file.getAbsolutePath());
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(new ArrayList<>(items));
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public void setButton(Group g, Stage s, ObservableList<String> i) {
        init(g, s, i);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSave();
            }
        });
    }
}
