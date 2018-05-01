/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loaddialog;

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
    private Button loadForAnalysisButton;
    
    @FXML 
    private Button loadMemoryButton;
    
    @FXML
    private File handleLoadForAnalysis(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter textExtensions = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter imageExtensions= new FileChooser.ExtensionFilter("Image files (*.jpg,*.gif,*.png,*.bmp)","*.jpg","*.gif","*.png","*.bmp");
        fileChooser.getExtensionFilters().add(textExtensions);
        fileChooser.getExtensionFilters().add(imageExtensions);
        Stage stage = (Stage) loadForAnalysisButton.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }
    
    @FXML 
    private File handleLoadMemory(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        Stage stage = (Stage) loadMemoryButton.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
