package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Modify {
    public void setButton(Group group, ListView<String> list) {
        Button modify = new Button();
        modify.setText("Modify");
        modify.setLayoutX(480);
        modify.setLayoutY(600);
        group.getChildren().add(modify);
        modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Va permite modificarea conceptului selectat.");
                System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
            }
        });
    }
}
