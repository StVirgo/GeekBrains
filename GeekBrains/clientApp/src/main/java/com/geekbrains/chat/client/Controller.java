package com.geekbrains.chat.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
    @FXML
    TextField msgField, usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    TextArea msgArea;

    @FXML
    HBox loginPanel, msgPanel;

    @FXML
    ListView<String> clientList;

    public Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private Stage regStage;
    private Stage logStage;
    private regController regController;
    private loginController loginController;

    public void sendMsg(ActionEvent actionEvent) {
        String msg = msgField.getText();
        try {
            out.writeUTF(msg);
            msgField.clear();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Невозможно отправить сообщение", ButtonType.OK);
            alert.showAndWait();
        }
    }


    public void login(String login, String password) {
        if(socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/login " + login + " " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            logStage.close();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void connect() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread dataThread = new Thread(() -> {
                try {
                    //цикл авторизации
                    while (true) {
                        String msg = in.readUTF();
                        if(msg.startsWith("/login_ok ")) {
                            setUsername(msg.split("\\s")[1]);
                            break;
                        }

                        if(msg.startsWith("/login_failed ")) {
                            String cause = msg.split("\\s", 2)[1];
                            msgArea.appendText(cause + '\n');
                        }
                        if(msg.equals("/regok")){
                            regController.setResultTryToReg("/regok");
                        }

                        if(msg.equals("/regno")){
                            regController.setResultTryToReg("/regno");
                        }

                    }

                    //цикл общения
                    while (true) {
                        String msg = in.readUTF();
                        if(msg.startsWith("/")) {
                            executeCommand(msg);
                            continue;
                        }
                        msgArea.appendText(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }
            });
            dataThread.start();

        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to server [localhost: 8189]");
        }
    }

    private void executeCommand(String cmd){
        if (cmd.startsWith("/clients_list ")){
            String[] tokens = cmd.split("\\s");
            Platform.runLater(() ->{
                clientList.getItems().clear();
                for (int i = 1; i < tokens.length; i++) {
                    clientList.getItems().add(tokens[i]);
                }
            });

        }
        if (cmd.startsWith("/yourNickIs ")) {
            username = cmd.split(" ")[1];
        }
    }

    public void disconnect() {
        setUsername(null);
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showRegWindow(ActionEvent actionEvent) {
        if (regStage == null) {
            initRegWindow();
        }
        regStage.show();
    }

    private void initRegWindow() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/regWindow.fxml"));
        Parent root = fxmlLoader.load();

        regController = fxmlLoader.getController();
        regController.setController(this);

        regStage = new Stage();
        regStage.setTitle("Регистрация");
        regStage.setScene(new Scene(root, 250, 150));


    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void showLogWindow(ActionEvent actionEvent) {
        if (logStage == null) {
            initLogWindow();
        }
        logStage.show();
    }
    private void initLogWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginWindow.fxml"));
            Parent root = fxmlLoader.load();

            loginController = fxmlLoader.getController();
            loginController.setController(this);

            logStage = new Stage();
            logStage.setTitle("Авторизация");
            logStage.setScene(new Scene(root, 250, 150));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registration(String login, String password, String nickname) {
        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF(String.format("%s %s %s %s", "/reg", login, password, nickname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
