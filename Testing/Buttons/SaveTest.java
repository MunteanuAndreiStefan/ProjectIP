package Testing.Buttons;

import Buttons.Load;
import Buttons.Save;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SaveTest {

    @Test
    public void objectCreated() {
        Save button = new Save();
        assertNotNull(button);
    }

    @Test
    public void ReadableFile() {

        String filePath = new File("SaveTest.ser").getAbsolutePath();
        File file = new File(filePath);
        assertNotNull(file.canRead());
    }


    @Test
    public void EmptyFile() throws IOException {

        String filePath = new File("Testing/SaveTest.ser").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        assertNotNull(br.readLine());

    }

    @Test
    public void handleSaveTest() throws IOException, ClassNotFoundException {

        Save button = new Save();
        ObservableList<String> items = FXCollections.observableArrayList("Concept 1", "Concept 2", "Concept 3", "Concept 4");
        File file = new File( "Testing/SaveTest.ser");
        button.handleSave(file,items);

        ArrayList obj1 = null;
        FileInputStream fileIn1 = new FileInputStream("Testing/SaveTest.ser");
        ObjectInputStream in1 = new ObjectInputStream(fileIn1);
        obj1 =  (ArrayList) in1.readObject();
        in1.close();
        fileIn1.close();

        assertEquals(items,obj1);



    }
}