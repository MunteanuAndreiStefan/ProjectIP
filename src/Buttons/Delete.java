package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Delete {
    private Button delete;
    public Group group;
    public ListView<String> list;

    private void init(Group group, ListView<String> list) {
        this.group = group;
        this.list = list;
        delete = new Button();
        delete.setText("Delete concept");
        delete.setLayoutX(470);
        delete.setLayoutY(600);
        this.group.getChildren().add(delete);
    }

    private void handleDelete(ListView<String> list) {
        System.out.println("Va sterge conceptul selectat.");
        System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
        list.getItems().remove(list.getSelectionModel().getSelectedIndex());
    }

    public void setButton(Group g, ListView<String> l) {
        init(g, l);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleDelete(list);
            }
        });
    }
}
