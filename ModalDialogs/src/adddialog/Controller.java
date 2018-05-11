/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adddialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author andrew
 */
public class Controller implements Initializable {
        
    @FXML
    private Button addConceptButton;
    
    @FXML
    private Button addDialogCloseButton;
    
    @FXML
    private void handleAddConcept(ActionEvent event) {
       
    }
        
    @FXML
    private void handleAddDialogClose(ActionEvent event) {
        Stage stage = (Stage) addDialogCloseButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
