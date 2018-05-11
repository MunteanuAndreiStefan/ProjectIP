/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewdialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author andrew
 */
public class Controller implements Initializable {
    
    @FXML
    private Button viewConceptButton;
    
    @FXML 
    private Button viewDialogCloseButton;
    
    @FXML
    private void handleViewConcept(ActionEvent event) {
    }
    
    @FXML 
    private Label label;
    
    @FXML 
    private void handleViewDialogClose(ActionEvent event){
        Stage stage = (Stage) viewDialogCloseButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setLabel(String text){
        label.setText(text);
    }
   
}
