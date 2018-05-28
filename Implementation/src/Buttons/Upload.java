
/*
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
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.soap.Text;
import java.io.IOException;

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

*/
package Buttons;

        import img.ImgApi;
        import img.Show;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;
        import org.json.JSONException;
        import org.json.JSONObject;

/**
 * @author andrew
 */
public class Upload
{
    private static final String ip = "172.20.10.4";
    private static final String port = "8000";

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
        fileLoad.setOnAction(new EventHandler<ActionEvent>()
        {
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


                if (jsonObject != null)
                {
                    try {
                        boolean newOne = true;
                        String newConcept = jsonObject.get("Found concept").toString();
                        for(int i=0;i<items.size();i++){
                            if(items.get(i).compareTo(newConcept) == 0){
                                newOne = false;
                            }
                        }
                        if(newOne) {
                            newConcept(1, newConcept);
                            items.add(newConcept);
                        } else {
                            newConcept(0, newConcept);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
/*
                    JSONObject toSend = new JSONObject();
                    try {
                        toSend.put("text", jsonObject.get("Text"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        toSend.put("conceptClass", "animals");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONObject result;
                    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                    try
                    {
                        HttpPost request = new HttpPost("http://" + ip + ":" + port + "/analyze");
                        StringEntity params = new StringEntity(toSend.toString());
                        request.addHeader("content-type", "application/json");
                        request.setEntity(params);
                        HttpResponse response = httpClient.execute(request);
                        result = new JSONObject(EntityUtils.toString(response.getEntity()));

                        //Obtained json from text module -> result
                        System.out.println(result.toString());
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally
                    {
                        try
                        {
                            httpClient.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                */
                }

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


            private void createLoginPanel(Stage modifyStage, Pane root, String concept, int ok) {

                if(ok == 0){
                    Label label = new Label("You already know this concept.");
                    label.setMaxWidth(250);
                    label.setLayoutX(60);
                    label.setLayoutY(40);

                    Button yes = new Button("Ok");
                    yes.setLayoutX(130);
                    yes.setLayoutY(80);
                    yes.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            modifyStage.hide();
                        }
                    });
                    root.getChildren().add(label);
                    root.getChildren().add(yes);
                } else {
                    final String[] newName = {""};
                    //
                    Label label = new Label("Is the main concept a " + concept + " ?");
                    label.setMaxWidth(250);
                    label.setLayoutX(60);
                    label.setLayoutY(40);


                    Button yes = new Button("Yes");
                    yes.setLayoutX(100);
                    yes.setLayoutY(80);
                    yes.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            modifyStage.hide();
                        }
                    });
                    Button no = new Button("No");
                    no.setLayoutX(160);
                    no.setLayoutY(80);
                    no.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            modifyStage.hide();
                        }
                    });

                    modifyStage.setTitle("New Concept!");
                    root.getChildren().add(label);
                    root.getChildren().add(yes);
                    root.getChildren().add(no);
                    //root.getChildren().add(status);
                }
                modifyStage.setTitle("New Concept!");
                modifyStage.setScene(new Scene(root, 300, 150));
            }
            private void newConcept(int ok, String concept) {
                if(ok > 0){
                    Stage modifyStage = new Stage();
                    Pane root = new Pane();
                    createLoginPanel(modifyStage, root, concept, ok);
                    modifyStage.show();
                } else {
                    Stage modifyStage = new Stage();
                    Pane root = new Pane();
                    createLoginPanel(modifyStage, root, concept, ok);
                    modifyStage.show();
                }
            }
        });
    }
}

