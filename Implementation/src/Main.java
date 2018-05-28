//package sample;
import Buttons.*;
import entitysearch.EntitySearchApi;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

import static entitysearch.EntitySearchApi.entitySearchFromText;
import static java.util.logging.Logger.getLogger;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        ScrollPane pane = new ScrollPane();
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        list.setItems(items);
        list.setPrefHeight(600);
        list.setPrefWidth(300);
        //
        pane.prefWidthProperty().bind(list.widthProperty());
        pane.prefHeightProperty().bind(list.heightProperty());
        pane.setContent(list);
        pane.setLayoutX(750);
        pane.setLayoutY(50);
        //
        Group group = new Group();
        new Login().setButton(group, primaryStage, items);
        new Load().setButton(group, primaryStage, items);
        new Save().setButton(group, primaryStage, items);
        new View().setButton(group, list);
        new Delete().setButton(group, list);
        new Modify().setButton(group, list);
        //
        group.getChildren().add(pane);
        Scene scene = new Scene(group, 1100, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        //try {
        //    JSONObject j=entitySearchFromText("Bird");
        //    System.out.println(j.toString());
        //} catch (Exception ex) {
        //    getLogger(EntitySearchApi.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    public static void main(String[] args) {

        /*
         String s = null;

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("Py -2 E:\\1nfochesti\\java\\untitled2\\src\\CreativeModule\\rnn.py");
            //Process p = Runtime.getRuntime().exec("rnn.py");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
         */
        launch(args);
    }
}
