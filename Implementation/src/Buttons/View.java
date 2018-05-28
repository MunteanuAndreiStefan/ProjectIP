package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class        View {
    private Button view;
    public Group group;
    public ListView<String> list;

    private void init(Group group, ListView<String> list) {
        this.group = group;
        this.list = list;
        view = new Button();
        view.setText("View details");
        view.setLayoutX(360);
        view.setLayoutY(600);
        this.group.getChildren().add(view);
    }

    private String getData(String obj) {
        String data = "";
        data += "Nume : " + obj + "\n";
        data += "Class : " + "numele clasei" + "\n";
        data += "Concept matching : " + "..." + "\n";
        data += "Class of the concept matching percentage" + "\n";
        data += "Concept details" + "\n";
        data += "Concept attachement" + "\n";
        return data;
    }

    private void handleView() {
        String obj = list.getSelectionModel().getSelectedItem();
        System.out.println("Va permite vizuarilzarea detaliata a unui concept selectat");
        System.out.println("Concept selectat : " + obj);
        //
        String data = getData(obj);
        //
        Label label = new Label(data);
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(label);
        //
        Scene secondScene = new Scene(secondaryLayout, 300, 150);
        //
        Stage newWindow = new Stage();
        newWindow.setTitle("View details");
        newWindow.setScene(secondScene);
        newWindow.show();
    }

    public void setButton(Group g, ListView<String> l) {
        init(g, l);
        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleView();
            }
        });
    }
}
