package models;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarUsuario extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("registroUsuario.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);
        primaryStage.setTitle("Registrar Usuario");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtUsuarios;

    @FXML
    private TextField txtcontraseña;

    @FXML
    private TextField txtConfirmarContraseña;

    @FXML
    private void btnRegistrarActionPerformed(ActionEvent event) {
        if (!txtNombres.getText().isEmpty() &&
                !txtApellidos.getText().isEmpty() &&
                !txtUsuarios.getText().isEmpty() &&
                !txtcontraseña.getText().isEmpty() &&
                txtConfirmarContraseña.getText().equals(txtcontraseña.getText())) {
            Usuario usuario = new Usuario(txtUsuarios.getText(),
                    txtcontraseña.getText(), txtNombres.getText(), txtApellidos.getText());

            if (UsuarioLogin.insertar(usuario)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro exitoso");
                alert.setHeaderText(null);
                alert.setContentText("Usuario registrado exitosamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario ya existente");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacíos o contraseña no coincidente");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos y asegúrese de que las contraseñas coincidan.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnModificarActionPerformed(ActionEvent event) {
        if (!txtNombres.getText().isEmpty() &&
                !txtApellidos.getText().isEmpty() &&
                !txtUsuarios.getText().isEmpty() &&
                !txtcontraseña.getText().isEmpty() &&
                txtConfirmarContraseña.getText().equals(txtcontraseña.getText())) {
            Usuario usuario = new Usuario(txtUsuarios.getText(),
                    txtcontraseña.getText(), txtNombres.getText(), txtApellidos.getText());

            if (UsuarioLogin.modificar(usuario)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modificación exitosa");
                alert.setHeaderText(null);
                alert.setContentText("Usuario modificado exitosamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario no encontrado");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacíos o contraseña no coincidente");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos y asegúrese de que las contraseñas coincidan.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnEliminarActionPerformed(ActionEvent event) {
        if (!txtUsuarios.getText().isEmpty()) {

            if (UsuarioLogin.eliminar(txtUsuarios.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminación exitosa");
                alert.setHeaderText(null);
                alert.setContentText("Usuario eliminado exitosamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario no encontrado");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campo vacío");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese el nombre de usuario.");
            alert.showAndWait();
        }
    }

    @FXML
    private void NavActionPerformed(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.close();


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Inicio de sesión");
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
