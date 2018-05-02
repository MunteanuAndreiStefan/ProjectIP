package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Load {
    public void setButton(Group group, Stage stage) {
        Button load = new Button();
        load.setText("Load memory");
        load.setLayoutX(120);
        load.setLayoutY(600);
        group.getChildren().add(load);
        //Action
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select memory file");
                fileChooser.showOpenDialog(stage);
            }
        });
    }

}
