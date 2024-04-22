package models;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("Inicio de sesión");
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private CheckBox chkMostrarContraseña;

    @FXML
    public void btnIngresarActionPerformed(ActionEvent event) {
        if (!txtUsuario.getText().isEmpty() && !txtContraseña.getText().isEmpty()) {
            if (UsuarioLogin.autentificar(txtUsuario.getText(), txtContraseña.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inicio de sesión exitoso");
                alert.setHeaderText(null);
                alert.setContentText("Bienvenido, disfrute su programa.");
                alert.showAndWait();


                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("paginaprincipal.fxml"));
                    Parent root = loader.load();


                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("Página Principal");
                    stage.setScene(scene);
                    stage.show();


                    Stage loginStage = (Stage) txtUsuario.getScene().getWindow();
                    loginStage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert alertError = new Alert(Alert.AlertType.ERROR);
                    alertError.setTitle("Error");
                    alertError.setHeaderText(null);
                    alertError.setContentText("No se pudo abrir la página principal.");
                    alertError.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de inicio de sesión");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrectos.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese su usuario y contraseña.");
            alert.showAndWait();
        }
    }


    @FXML
    public void chkMostrarContraseñaActionPerformed(ActionEvent event) {
        if (chkMostrarContraseña.isSelected()) {
            txtContraseña.setManaged(false);
            txtContraseña.setVisible(false);
            TextField unmaskedPassword = new TextField(txtContraseña.getText());
            unmaskedPassword.setId("txtContraseña");
            unmaskedPassword.setOnAction(txtContraseña.getOnAction());
            unmaskedPassword.setPromptText("Contraseña");
            unmaskedPassword.setManaged(true);
            unmaskedPassword.setVisible(true);
            txtContraseña = new PasswordField();
        } else {
            txtContraseña = new PasswordField();
            txtContraseña.setId("txtContraseña");
            txtContraseña.setOnAction(txtContraseña.getOnAction());
            txtContraseña.setPromptText("Contraseña");
            txtContraseña.setManaged(true);
            txtContraseña.setVisible(true);
        }
    }

    @FXML
    public void btnRegistrarActionPerformed(ActionEvent event) {
        try {

            Stage loginStage = (Stage) txtUsuario.getScene().getWindow();


            loginStage.close();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("registrarusuario.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrar Usuario");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo abrir la ventana de registro de usuario.");
            alert.showAndWait();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
