package com.geekbrains.chat.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class regController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nicknameField;
    @FXML
    private TextArea textArea;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void setResultTryToReg(String command) {
        if (command.equals("/regok")) {
            textArea.appendText("Регистрация прошла успешно\n");
        }
        if (command.equals("/regno")) {
            textArea.appendText("Логин или никнейм уже заняты\n");
        }
    }

    public void tryToReg(ActionEvent actionEvent) {
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();
        String nickname = nicknameField.getText().trim();

        if(loginField.getText().isEmpty()) {
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
        if(nicknameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ник не может быть пустым",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }

        if (login.length() * password.length() * nickname.length() == 0) {
            return;
        }

        controller.registration(login, password, nickname);
    }
}
