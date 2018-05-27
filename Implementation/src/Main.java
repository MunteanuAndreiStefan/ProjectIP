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
        ObservableList<String> items = FXCollections.observableArrayList("Concept 1", "Concept 2", "Concept 3", "Concept 4");
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
        launch(args);
    }
}
