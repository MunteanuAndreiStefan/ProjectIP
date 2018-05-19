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

    public void handler(Stage stage,ObservableList<String> items) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select memory file");
        File file = null;
        file = fileChooser.showSaveDialog(stage);
        if(file != null) {
            try {
                FileOutputStream fos= new FileOutputStream(file.getAbsolutePath());
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(new ArrayList<>(items));
                oos.close();
                fos.close();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public void setButton(Group group, Stage stage, ObservableList<String> items) {
        Button save = new Button();
        save.setText("Save memory");
        save.setLayoutX(240);
        save.setLayoutY(600);
        group.getChildren().add(save);
        
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handler(stage,items);
            }
        });
    }
}
