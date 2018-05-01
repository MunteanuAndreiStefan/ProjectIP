/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportdialog;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author andrew
 */
public class Controller implements Initializable {
    
    @FXML
    private Button exportButton;
    
    @FXML
    private File handleExport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) exportButton.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        return file;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
