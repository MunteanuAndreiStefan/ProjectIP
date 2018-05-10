package Buttons;

import gvjava.org.json.JSONException;
import javafx.beans.binding.ListBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.ConceptPopup;
import sample.Decision;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Upload {
    public void setButton(Group group, Stage stage, ObservableList<String> items) {
        Button upload = new Button();
        upload.setText("Upload");
        upload.setLayoutX(40);
        upload.setLayoutY(600);
        group.getChildren().add(upload);
        //Action
        upload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select image/text to upload");
                List<File> inputFile = fileChooser.showOpenMultipleDialog(stage);
                List<JSONObject> jsonObjects = new ArrayList<>();
                JSONParser parser = new JSONParser();
                for(int i=0; i<inputFile.size(); i++){
                    Object obj = null;
                    try {
                        obj = parser.parse(new FileReader(inputFile.get(i)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JSONObject jsonObject = (JSONObject) obj;
                    jsonObjects.add(jsonObject);
                }
                try {
                    Decision decision = new Decision();
                    Pair<String, Double> ans = decision.check(jsonObjects, items);
                    items.add(ans.getKey());
                    //
                    new ConceptPopup(group, ans.getKey(), ans.getValue());
                    //
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
