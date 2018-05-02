package sample;
import Buttons.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ScrollPane pane = new ScrollPane();

        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("Concept 1", "Concept 2", "Concept 3", "Concept 4");
        list.setItems(items);
        list.setPrefHeight(600);
        list.setPrefWidth(300);
        //
        pane.prefWidthProperty().bind(list.widthProperty());
        pane.prefHeightProperty().bind(list.heightProperty());
        pane.setContent(list);
        pane.setLayoutX(650);
        pane.setLayoutY(50);
        //
        Group group = new Group();
        new Login().setButton(group);
        new Load().setButton(group, primaryStage);
        new View().setButton(group, list);
        new Delete().setButton(group, list);
        new Modify().setButton(group, list);
        //
        group.getChildren().add(pane);
        Scene scene = new Scene(group, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
