package models;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PaginaPrincipal extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("paginaPrincipal.fxml"));


        Scene scene = new Scene(root);
        primaryStage.setTitle("Página Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private Label lblUsuario;




    @FXML
    private void ventasActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ventas.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ventas");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) lblUsuario.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void clientesActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("clientes.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Clientes");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) lblUsuario.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void inventarioActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("inventario.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Inventario");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) lblUsuario.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void provedorActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("proveedores.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Proveedores");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) lblUsuario.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}