package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Modify {
    public void setButton(Group group, ListView<String> list) {
        Button modify = new Button();
        modify.setText("Modify");
        modify.setLayoutX(600);
        modify.setLayoutY(600);
        group.getChildren().add(modify);
        modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Va permite modificarea conceptului selectat.");
                System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
                final String[] newName = {""};
                //
                TextField textField = new TextField();
                textField.setMaxWidth(250);
                textField.setLayoutX(60);
                textField.setLayoutY(0);
                Button ok = new Button("Ok");
                ok.setLayoutX(130);
                ok.setLayoutY(50);
                Stage modifyStage = new Stage();
                //
                //Ok button action
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        list.getItems().set(list.getSelectionModel().getSelectedIndex(), textField.getText());
                        modifyStage.hide();
                    }
                });
                //
                modifyStage.setTitle("Modify");
                Pane root = new Pane();
                root.getChildren().add(textField);
                root.getChildren().add(ok);
                modifyStage.setScene(new Scene(root, 300, 100));
                modifyStage.show();
            }
        });
    }
}
