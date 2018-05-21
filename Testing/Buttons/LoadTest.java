package Buttons;

import Buttons.Load;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import sample.Decision;

import java.io.*;

import static org.junit.Assert.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LoadTest {


    @Test
    public void objectCreated() {
        Load button = new Load();
        assertNotNull(button);
    }

    @Test
    public void ReadableFile() {

        String filePath = new File("Testing/LoadTest.ser").getAbsolutePath();
        File file = new File(filePath);
        System.out.println(filePath);
        assertNotNull(file.canRead());
    }

    @Test
    public void EmptyFile() throws IOException {

        String filePath = new File("Testing/LoadTest.ser").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        assertNotNull(br.readLine());

    }

    @Test
    public void loadHandleTest() throws IOException, ClassNotFoundException {
        Load button = new Load();
        File file = new File("Testing/LoadTest.ser");
        ObservableList<String> expectedItems = FXCollections.observableArrayList("Concept 1","Concept 2","Concept 3","Concept 4");
        ObservableList<String> items = FXCollections.observableArrayList();
        button.handleLoad(file,items);

        assertEquals(expectedItems,items);
    }


}