package controller;

import interfaces.LoginOkListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    private LoginOkListener listener;

    @FXML
    Button btnLogin;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    private void initialize() {
        btnLogin.setOnAction(event -> checkLogin());
    }

    private void checkLogin() {
        if (!username.getText().isEmpty()) {
            if (!password.getText().isEmpty()) {
                if (username.getText().equals("user") && password.getText().equals("passwort")) {
                    loginOk(false);
                } else if (username.getText().equals("admin") && password.getText().equals("passwort")){
                    loginOk(true);
                }
                else {
                    showError("Username oder Passwort falsch.");
                }
            } else {
                showError("Passwort muss ausgefüllt sein");
            }
        } else {
            showError("Username muss ausgefüllt sein");
        }
    }

    private void loginOk(boolean isAdmin) {
        if (listener != null) {
            listener.onLoginOK(isAdmin);
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Achtung");
        alert.setContentText(msg);
        alert.showAndWait();

    }

    public void setLoginOkListener(LoginOkListener listener){
        this.listener = listener;
    }
}
