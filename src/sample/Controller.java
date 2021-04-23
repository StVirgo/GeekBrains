package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    TextField msgField;
    @FXML
    TextArea chatArea;
    @FXML
    Button btn;

    public void clickSendBtn(ActionEvent actionEvent) {
        chatArea.appendText(msgField.getText() + "\n");
        msgField.clear();

    }

    public void key(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            chatArea.appendText(msgField.getText() + "\n");
            msgField.clear();
        }
    }
}
