package Buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class Login {
    public void setButton(Group group) {
        Button login = new Button();
        login.setText("Login");
        login.setLayoutX(50);
        login.setLayoutY(600);
        group.getChildren().add(login);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Butonul va face pop-up la un formular pentru crearea unui cont, apoi acesta va fi inlocuit cu butonul de upload");

            }
        });
    }
}
