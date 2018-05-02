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

public class View {
    public void setButton(Group group, ListView<String> list) {
        Button view = new Button();
        view.setText("View details");
        view.setLayoutX(240);
        view.setLayoutY(600);
        group.getChildren().add(view);
        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Va permite vizuarilzarea detaliata a unui concept selectat");
                System.out.println("Concept selectat : " + list.getSelectionModel().getSelectedItem());
                //
                String data = "";
                data += "Nume : " + list.getSelectionModel().getSelectedItem() + "\n";
                data += "Class : " + "numele clasei" + "\n";
                data += "Concept matching : " + "..." + "\n";
                data += "Class of the concept matching percentage" + "\n";
                data += "Concept details" + "\n";
                data += "Concept attachement" + "\n";
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
        });
    }
}
