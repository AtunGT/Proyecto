package models;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Proveedores extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("proveedores.fxml"));
        primaryStage.setTitle("Proveedores");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TableView<Object[]> tblRegister;

    @FXML
    private TableColumn<Object[], String> colNombre;

    @FXML
    private TableColumn<Object[], String> colTelefono;

    @FXML
    private TableColumn<Object[], String> colDireccion;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;



    private ObservableList<Object[]> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[0]));
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[1]));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[2]));
        tblRegister.setItems(data);
    }

    @FXML
    private void btnAgregarAction(ActionEvent event) {
        String nombre = txtNombres.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        Object[] row = {nombre, telefono, direccion};
        data.add(row);

        txtNombres.clear();
        txtTelefono.clear();
        txtDireccion.clear();
    }

    @FXML
    private void btnEditarAction(ActionEvent event) {
        Object[] row = tblRegister.getSelectionModel().getSelectedItem();
        if (row != null) {
            row[0] = txtNombres.getText();
            row[1] = txtTelefono.getText();
            row[2] = txtDireccion.getText();
            tblRegister.refresh();
        }
    }

    @FXML
    private void btnEliminarAction(ActionEvent event) {
        Object[] row = tblRegister.getSelectionModel().getSelectedItem();
        if (row != null) {
            data.remove(row);
        }
    }

    @FXML
    private void btnEliminarTodoAction(ActionEvent event) {
        data.clear();
    }

    @FXML
    private void btnInicioActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("paginaprincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Página Principal");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void btnClientesActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("clientes.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Clientes");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void btnInventarioActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("inventario.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Inventario");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void btnVentasActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ventas.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ventas");
            stage.setScene(new Scene(root));
            stage.show();


            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
