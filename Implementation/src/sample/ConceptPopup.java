package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConceptPopup {
        public ConceptPopup(Group group, String winner, Double percents){
            Label label = new Label("The concept \"" + winner + "\" was found with matching " + percents + "% percents");
            Button ok = new Button("Ok");
            ok.setLayoutX(200);
            ok.setLayoutY(50);
            Stage modifyStage = new Stage();
            //
            //Ok button action
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    modifyStage.hide();
                }
            });
            //
            modifyStage.setTitle("New Concept!!!");
            Pane root = new Pane();
            root.getChildren().add(label);
            root.getChildren().add(ok);
            modifyStage.setScene(new Scene(root, 450, 100));
            modifyStage.show();
        }
}
