package Buttons;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ListView;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewTest {

    @Test
    public void objectCreated() {
        View button = new View();
        assertNotNull(button);
    }

    @Test
    public void getDataTest() {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            }
        });

        View button = new View();
        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> list = new ListView<>();
        list.setItems(items);

        list.getSelectionModel().select("Concept 1");
        String obj = list.getSelectionModel().getSelectedItem();
        String expectedObj = "";
        expectedObj += "Nume : " + obj + "\n";
        expectedObj += "Class : " + "numele clasei" + "\n";
        expectedObj += "Concept matching : " + "..." + "\n";
        expectedObj += "Class of the concept matching percentage" + "\n";
        expectedObj += "Concept details" + "\n";
        expectedObj += "Concept attachement" + "\n";

        Object actualObj = button.getData(obj);


        assertEquals(expectedObj,actualObj);
    }
}