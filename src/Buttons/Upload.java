/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buttons;

import img.ImgApi;
import img.Show;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
//import javax.xml.soap.Text;

/**
 * @author andrew
 */
public class Upload
{
    public void setButton(Group group, Stage stage, ObservableList<String> items)
    {
        TextField textField = new TextField();
        textField.setLayoutX(35);
        textField.setLayoutY(550);
        textField.setPrefWidth(400);
        textField.setPromptText("URL or PATH to image...");
        Button fileLoad = new Button();
        fileLoad.setText("Upload");
        fileLoad.setLayoutX(40);
        fileLoad.setLayoutY(600);
        group.getChildren().add(fileLoad);
        group.getChildren().add(textField);
        //Action
        fileLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String imgLink;// = "https://www.what-dog.net/Images/faces2/scroll001.jpg";
                imgLink = textField.getText();
                JSONObject jsonObject = null;
                System.out.println("aa");
                try {
                    jsonObject = ImgApi.analyzeImage(imgLink);
                    new Show().showImage(group, stage, jsonObject, imgLink);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jsonObject != null) {
                    try {
                        items.add(jsonObject.get("Found concept").toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
