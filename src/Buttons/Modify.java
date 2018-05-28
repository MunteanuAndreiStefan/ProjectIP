package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//import javax.xml.soap.Text;

public class Modify {
    private Button modify;
    public Group group;
    public ListView<String> list;

    private void init(Group group, ListView<String> list) {
        this.group = group;
        this.list = list;
        modify = new Button();
        modify.setText("Modify");
        modify.setLayoutX(600);
        modify.setLayoutY(600);
        this.group.getChildren().add(modify);
    }

    private void createModifyDialog(Stage modifyStage, Pane root) {
        final String[] newName = {""};
        //
        TextField textField = new TextField();
        textField.setMaxWidth(250);
        textField.setLayoutX(60);
        textField.setLayoutY(0);
        Button ok = new Button("Ok");
        ok.setLayoutX(130);
        ok.setLayoutY(50);
        //
        modifyStage.setTitle("Modify");
        root.getChildren().add(textField);
        root.getChildren().add(ok);
        modifyStage.setScene(new Scene(root, 300, 100));
    }

    private void handleModify(ListView<String> list) {
        Stage modifyStage = new Stage();
        Pane root = new Pane();
        createModifyDialog(modifyStage, root);
        TextField textField = (TextField) root.getChildren().get(0);
        Button ok = (Button) root.getChildren().get(1);
        //Ok button action
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean found = false;
                for(String concept : list.getItems())
                    if(concept.equals(textField.getText()) && !concept.equals(list.getSelectionModel().getSelectedItem()))
                        found = true;
                if(found == true) {
                    Alert alert = new Alert(AlertType.ERROR, "Concept already exists!");
                    alert.showAndWait();
                }
                else {
                    list.getItems().set(list.getSelectionModel().getSelectedIndex(), textField.getText());
                    modifyStage.hide();
                }
            }
        });
        //
        modifyStage.show();
    }

    public void setButton(Group g, ListView<String> l) {
        init(g, l);
        System.out.println("Va permite modificarea conceptului selectat.");
        System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
        modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleModify(list);
            }
        });
    }
}
