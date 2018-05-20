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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login {
    public boolean logged = false;
    public Group group;
    public Stage primaryStage;
    public ObservableList<String> items;
    private Button login;

    private void init(Group group, Stage primaryStage, ObservableList<String> items) {
        this.group = group;
        this.primaryStage = primaryStage;
        this.items = items;
        login = new Button();
        login.setText("Login");
        login.setLayoutX(50);
        login.setLayoutY(600);
        this.group.getChildren().add(login);
    }

    private void createLoginPanel(Stage modifyStage, Pane root) {
        final String[] newName = {""};
        //
        TextField username = new TextField();
        username.setMaxWidth(250);
        username.setLayoutX(60);
        username.setLayoutY(0);
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setMaxWidth(250);
        password.setLayoutX(60);
        password.setLayoutY(40);
        password.setPromptText("Password");

        Button ok = new Button("Ok");
        ok.setLayoutX(130);
        ok.setLayoutY(80);

        modifyStage.setTitle("Login");
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(ok);
        //root.getChildren().add(status);
        modifyStage.setScene(new Scene(root, 300, 150));
    }

    private void addStatusLabel(Pane root) {
        Label status = new Label();
        status.setLayoutX(130);
        status.setLayoutY(120);
        status.setText("Fail.");
        status.setTextFill(Color.web("#B22222"));
        root.getChildren().add(status);
    }

    private void confirmationHandle(Stage modifyStage, Pane root) {
        TextField username = (TextField) root.getChildren().get(0);
        PasswordField password = (PasswordField) root.getChildren().get(1);

        if(username.getText().compareTo("admin") == 0 && password.getText().compareTo("admin") == 0) {
            modifyStage.hide();
            group.getChildren().remove(login);
            new Upload().setButton(group, primaryStage, items);
        } else {
            addStatusLabel(root);
        }
    }

    public void setButton(Group g, Stage pStage, ObservableList<String> i) {
        System.out.println("Butonul va face pop-up la un formular pentru crearea unui cont, apoi acesta va fi inlocuit cu butonul de upload");
        init(g, pStage, i);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage modifyStage = new Stage();
                Pane root = new Pane();
                createLoginPanel(modifyStage, root);
                Button ok = (Button) root.getChildren().get(2);
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        confirmationHandle(modifyStage, root);
                    }
                });
                modifyStage.show();
            }
        });

    }
}
