package com.geekbrains.chat.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class loginController {
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML

    private Controller controller;
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void login(ActionEvent actionEvent) {
        if(usernameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Имя пользователя не может быть пустым",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }
        if(passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Пароль не может быть пустым",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }
        controller.login(usernameField.getText(), passwordField.getText());
    }
}
