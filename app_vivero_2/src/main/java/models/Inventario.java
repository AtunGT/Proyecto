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
import models.Inventario2;
import models.ventas;

import java.io.IOException;

public class Inventario extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventario.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Inventario");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TableView<Inventario2> tblRegister;

    @FXML
    private TableColumn<Inventario2, String> colNombre;

    @FXML
    private TableColumn<Inventario2, String> colCantidad;

    @FXML
    private TableColumn<Inventario2, String> colPrecio;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtEtapa;

    private ObservableList<Inventario2> items = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tblRegister.setItems(items);
    }

    @FXML
    private void btnVentasActionPerformed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ventas.fxml"));
            Parent root = loader.load();
            ventas ventasController = loader.getController();
            ventasController.recibirDatosDeInventario(items);

            Stage stage = new Stage();
            stage.setTitle("Ventas");
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void btnAgregarActionPerformed(ActionEvent event) {
        String nombre = txtNombres.getText();
        String cantidad = txtTipo.getText();
        String precio = txtEtapa.getText();

        Inventario2 item = new Inventario2(nombre, cantidad, precio);
        items.add(item);

        txtNombres.clear();
        txtTipo.clear();
        txtEtapa.clear();
    }

    @FXML
    private void btnEditarActionPerformed(ActionEvent event) {
        Inventario2 item = tblRegister.getSelectionModel().getSelectedItem();
        if (item != null) {
            String nombre = txtNombres.getText();
            String cantidad = txtTipo.getText();
            String precio = txtEtapa.getText();

            item.setNombre(nombre);
            item.setCantidad(cantidad);
            item.setPrecio(precio);

            tblRegister.refresh();
        }
    }

    @FXML
    private void btnEliminarActionPerformed(ActionEvent event) {
        Inventario2 item = tblRegister.getSelectionModel().getSelectedItem();
        if (item != null) {
            items.remove(item);
        }
    }

    @FXML
    private void btnEliminarTodoActionPerformed(ActionEvent event) {
        items.clear();
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


}
