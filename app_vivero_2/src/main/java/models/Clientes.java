package models;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Clientes extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("clientes.fxml"));


        Scene scene = new Scene(root);
        primaryStage.setTitle("Clientes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TableView<Clientes2> tblRegister;
    @FXML
    private TableColumn<Clientes2, String> colNombre;
    @FXML
    private TableColumn<Clientes2, String> colTelefono;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtTelefono;

    private ObservableList<Clientes2> clientesList = FXCollections.observableArrayList();

    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tblRegister.setItems(clientesList);
    }

    @FXML
    private void btnAgregarClicked() {
        String nombre = txtNombres.getText();
        String telefono = txtTelefono.getText();

        Clientes2 cliente = new Clientes2(nombre, telefono);

        clientesList.add(cliente);

        txtNombres.clear();
        txtTelefono.clear();
    }

    @FXML
    private void btnEditarClicked() {
        Clientes2 selectedCliente = tblRegister.getSelectionModel().getSelectedItem();
        if (selectedCliente != null) {
            selectedCliente.setNombre(txtNombres.getText());
            selectedCliente.setTelefono(txtTelefono.getText());
            tblRegister.refresh();
        }
    }

    @FXML
    private void btnEliminarClicked() {
        Clientes2 selectedCliente = tblRegister.getSelectionModel().getSelectedItem();
        if (selectedCliente != null) {
            clientesList.remove(selectedCliente);
        }
    }

    @FXML
    private void btnEliminarTodoActionPerformed(ActionEvent event) {
        clientesList.clear();
    }

    @FXML
    private void tblRegisterClicked() {
        Clientes2 selectedCliente = tblRegister.getSelectionModel().getSelectedItem();
        if (selectedCliente != null) {
            txtNombres.setText(selectedCliente.getNombre());
            txtTelefono.setText(selectedCliente.getTelefono());
        }
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
    private void btnProveedoresActionPerformed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("proveedores.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Proveedores");
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
