package com.geekbrains.chat.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    TextArea msgArea;

    @FXML
    TextField msgField, usernameField;

    @FXML
    HBox loginPanel, msgPanel;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String username;




    public void sendMSG(ActionEvent actionEvent) {
        String msg = msgField.getText() + '\n';
        try {
            out.writeUTF(msg);
            msgField.clear();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Невозможно отправить в сообщение!");
            alert.showAndWait();

        }

    }

    public void login(ActionEvent actionEvent) {
        if(socket == null || socket.isClosed()){
            connect();
        }

        if (usernameField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Пустое поле имя пользователя", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        try {
            out.writeUTF("/login " + usernameField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setUsername(String username){
        this.username = username;
        if(username != null){
            loginPanel.setVisible(false);
            loginPanel.setManaged(false);
            msgPanel.setVisible(true);
            msgPanel.setManaged(true);
        } else {
            loginPanel.setVisible(true);
            loginPanel.setManaged(true);
            msgPanel.setVisible(false);
            msgPanel.setManaged(false);
        }
    }

    public void connect(){
        try {
            socket = new Socket("localhost",8189);
            in =  new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread dataThread = new Thread(() -> {
                try {
                    while (true){
                        String msg = in.readUTF();

                        if(msg.startsWith("/")) {
                            if(msg.startsWith("/login_ok")){
                                setUsername(msg.split("\\s")[1]);
                            }
                            continue;
                        }

                        msgArea.appendText(msg);
                    }
                } catch (IOException e){
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

    private void disconnect() {
        setUsername(null);
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
