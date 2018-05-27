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
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author andrew
 */
public class FileLoad
{
    private static final String ip = "172.20.10.4";
    private static final String port = "8000";

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
                JSONObject jsonObject = null;
                try {
                    jsonObject = ImgApi.analyzeImage(imgLink);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jsonObject != null)
                {
                    try {
                        items.add(jsonObject.get("Found concept").toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
        });
    }
}
