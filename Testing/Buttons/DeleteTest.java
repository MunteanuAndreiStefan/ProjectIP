package Buttons;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import openjava.test.stringPlay.Application;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteTest {


    @Test
    public void wellHandled() {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            }
        });

        Delete delete = new Delete();
        ObservableList<String> items1 = FXCollections.observableArrayList("Concept 1", "Concept 2", "Concept 3", "Concept 4");
        ListView<String> list1 = new ListView<>();
        list1.setItems(items1);
        list1.getSelectionModel().select("Concept 1");
        delete.handleDelete(list1);

        ObservableList<String> items2 = FXCollections.observableArrayList( "Concept 2", "Concept 3", "Concept 4");
        ListView<String> list2 = new ListView<>();
        list2.setItems(items2);

        assertEquals(list2.getItems(),list1.getItems());
    }
}