package Buttons;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login {
    public boolean logged = false;
    public void setButton(Group group, Stage primaryStage, ObservableList<String> items) {
        Button login = new Button();
        login.setText("Login");
        login.setLayoutX(50);
        login.setLayoutY(600);
        group.getChildren().add(login);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Butonul va face pop-up la un formular pentru crearea unui cont, apoi acesta va fi inlocuit cu butonul de upload");
                final String[] newName = {""};
                //
                TextField username = new TextField();
                username.setMaxWidth(250);
                username.setLayoutX(60);
                username.setLayoutY(0);
                username.setPromptText("Username");
                //
                PasswordField password = new PasswordField();
                password.setMaxWidth(250);
                password.setLayoutX(60);
                password.setLayoutY(40);
                password.setPromptText("Password");
                //
                Button ok = new Button("Ok");
                ok.setLayoutX(130);
                ok.setLayoutY(80);
                Stage modifyStage = new Stage();
                //Ok button action
                Pane root = new Pane();
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(username.getText().compareTo("admin") == 0 && password.getText().compareTo("admin") == 0) {
                            modifyStage.hide();
                            group.getChildren().remove(login);
                            new Upload().setButton(group, primaryStage, items);
                        } else {
                            Label status = new Label();
                            status.setLayoutX(130);
                            status.setLayoutY(120);
                            status.setText("Fail.");
                            status.setTextFill(Color.web("#B22222"));
                            root.getChildren().add(status);
                        }
                    }
                });
                //
                modifyStage.setTitle("Login");
                root.getChildren().add(username);
                root.getChildren().add(password);
                root.getChildren().add(ok);
                //root.getChildren().add(status);
                modifyStage.setScene(new Scene(root, 300, 150));
                modifyStage.show();
            }
        });
    }
}
