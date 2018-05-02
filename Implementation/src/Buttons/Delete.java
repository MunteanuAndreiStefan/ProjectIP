package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Delete {
    public void setButton(Group group, ListView<String> list) {
        Button delete = new Button();
        delete.setText("Delete concept");
        delete.setLayoutX(350);
        delete.setLayoutY(600);
        group.getChildren().add(delete);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Va sterge conceptul selectat.");
                System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
            }
        });
    }
}
