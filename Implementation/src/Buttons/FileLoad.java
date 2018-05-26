/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buttons;

import img.ImgApi;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 * @author andrew
 */
public class FileLoad
{
    public void setButton(Group group, Stage stage, ObservableList<String> items)
    {
        Button fileLoad = new Button();
        fileLoad.setText("File load");
        fileLoad.setLayoutX(40);
        fileLoad.setLayoutY(500);
        group.getChildren().add(fileLoad);
        //Action
        fileLoad.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String imgLink = "https://www.what-dog.net/Images/faces2/scroll001.jpg";
                JSONObject jsonObject = ImgApi.analyzeImage(imgLink);
                if (jsonObject != null)
                    items.add(jsonObject.get("Found concept").toString());


//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Select image/text to upload");
//                FileChooser.ExtensionFilter extensions=new FileChooser.ExtensionFilter("TEXT Files(*.txt)","*.txt");
//                fileChooser.getExtensionFilters().add(extensions);
//                extensions=new FileChooser.ExtensionFilter("Image","*.gif","*.jpg","*.png");
//                fileChooser.getExtensionFilters().add(extensions);
//                File inputFile=fileChooser.showOpenDialog(stage);
//                String extension=inputFile.getName().substring(inputFile.getName().lastIndexOf(".")+1);
//                if(extension.equals("txt"))
//                {
//                    String link="";
//                    String content="";
//                    try {
//                        content = new String(Files.readAllBytes(Paths.get(inputFile.getCanonicalPath())));
//                    } catch (IOException ex) {
//                        Logger.getLogger(FileLoad.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    Requests.sendText(link, content);
//                }
//                else
//                {
//                    String host="";
//                    int port=0;
//                    try {
//                        Requests.sendImage(host,port,inputFile.getName(),extension);
//                    } catch (IOException ex) {
//                        Logger.getLogger(FileLoad.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
        });
    }
}
