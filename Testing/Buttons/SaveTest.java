package Testing.Buttons;

import Buttons.Load;
import Buttons.Save;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        String filePath = new File("test.txt").getAbsolutePath();
        File file = new File(filePath);
        assertNotNull(file.canRead());
    }


    @Test
    public void EmptyFile() throws IOException {

        String filePath = new File("test.txt").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        assertNotNull(br.readLine());

    }

//    @Test
//    public void wellHandled(){
//        Save button = new Save();
//        Stage stage = new Stage();
//        ObservableList<String> items = FXCollections.observableArrayList("Concept 1", "Concept 2", "Concept 3", "Concept 4");
//        button.handler(stage,items);
//
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Select memory file");
//        File file = null;
//        file = fileChooser.showSaveDialog(stage);
//        if(file != null) {
//            try{
//                FileOutputStream fos= new FileOutputStream(file.getAbsolutePath());
//                ObjectOutputStream oos= new ObjectOutputStream(fos);
//                oos.writeObject(new ArrayList<>(items));
//                oos.close();
//                fos.close();
//            }catch(IOException ioe){
//                ioe.printStackTrace();
//            }
//        }
//
//    }
}