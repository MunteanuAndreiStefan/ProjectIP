package Buttons;

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
import sample.WekaDecision;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Upload {
    private Button upload;
    public Group group;
    public Stage stage;
    public ObservableList<String> items;

    private void init(Group group, Stage stage, ObservableList<String> items) {
        this.group = group;
        this.items = items;
        this.stage = stage;
        upload = new Button();
        upload.setText("Upload");
        upload.setLayoutX(40);
        upload.setLayoutY(600);
        this.group.getChildren().add(upload);
    }

    private List<JSONObject> getJsonObjects() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select image/text to upload");
        List<File> inputFile = fileChooser.showOpenMultipleDialog(stage);
        if(inputFile == null)
            return null;
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
        return jsonObjects;
    }

    private String getHeader() {
        String dataToWrite = "";
        dataToWrite += "@relation animals" + '\n' + '\n';
        dataToWrite += "@attribute class {Mamifer, Insecta}" + '\n';
        dataToWrite += "@attribute classMatching {low, high}" + '\n';
        dataToWrite += "@attribute concept {Soarece, Albina, Caine, Motan, Urs, Maimuta}" + '\n';
        dataToWrite += "@attribute conceptMatching {low, high}" + '\n' + '\n';
        //
        dataToWrite += "@data" + '\n';
        return dataToWrite;
    }

    private String parseJsonObj(JSONObject jsonObject) {
        String classFound = (String) jsonObject.get("Class");
        String concept = (String) jsonObject.get("Found concept");
        Double classMatching = (Double) jsonObject.get("Class matching");
        Double conceptMatching = (Double) jsonObject.get("Concept matching");
        String matchingClassIntensivity;
        String matchingConceptIntensivity;

        if(classMatching < 50)
            matchingClassIntensivity = "low";
        else
            matchingClassIntensivity = "high";
        //
        if(conceptMatching < 50)
            matchingConceptIntensivity = "low";
        else
            matchingConceptIntensivity = "high";
        return classFound + "," + matchingClassIntensivity + "," + concept + "," + matchingConceptIntensivity + '\n';
    }

    private void decide(List<JSONObject> jsonObjects) {
        try {
            //Decision decision = new Decision();
            //Pair<String, Double> ans = decision.check(jsonObjects, items);
            //items.add(ans.getKey());
            //
            //new ConceptPopup(group, ans.getKey(), ans.getValue());
            //
            //Weka classifier
            String forWekaFile = "forWekaFile.txt";
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(forWekaFile), "utf-8"));
            //
            //To artff
            String dataToWrite = getHeader();
            writer.write(dataToWrite);
            for(int i=0;i<jsonObjects.size();i++){
                String line = parseJsonObj(jsonObjects.get(i));
                writer.write(line);
                //System.out.println(classFound + " " + concept + " " + classMatching + " " + conceptMatching);
            }
            //
            //writer.write("Saa");
            writer.close();
            WekaDecision wekaDecision = new WekaDecision();
            wekaDecision.classify(forWekaFile);
            //
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setButton(Group g, Stage s, ObservableList<String> i) {
        init(g, s, i);
        //Action
        upload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<JSONObject> jsonObjects = getJsonObjects();
                if(jsonObjects != null)
                    decide(jsonObjects);
            }
        });
    }

}
