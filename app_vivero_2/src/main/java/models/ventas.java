package models;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ventas extends Application {

    @FXML
    private TableView<Object[]> tblRegister;

    @FXML
    private TableColumn<Object[], String> colNombre;

    @FXML
    private TableColumn<Object[], String> colCantidad;

    @FXML
    private TableColumn<Object[], String> colPrecio;

    @FXML
    private TableColumn<Object[], String> colTotal;


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ventas.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void recibirDatosDeInventario(ObservableList<Inventario2> datosInventario) {
        tblRegister.getItems().clear();

        for (Inventario2 item : datosInventario) {
            String precioTotal = String.valueOf(Double.parseDouble(item.getCantidad()) * Double.parseDouble(item.getPrecio()));
            Object[] rowData = {item.getNombre(), item.getCantidad(), item.getPrecio(), precioTotal};
            tblRegister.getItems().add(rowData);
        }
    }


    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtEtapa;

    @FXML
    private Label lblTotal;

    private double total = 0.0;

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(data -> new SimpleStringProperty((String) data.getValue()[0]));
        colCantidad.setCellValueFactory(data -> new SimpleStringProperty((String) data.getValue()[1]));
        colPrecio.setCellValueFactory(data -> new SimpleStringProperty((String) data.getValue()[2]));
        colTotal.setCellValueFactory(data -> new SimpleStringProperty((String) data.getValue()[3]));
    }

    @FXML
    private void tblRegisterMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Object[] rowData = tblRegister.getSelectionModel().getSelectedItem();
            if (rowData != null) {
                txtNombres.setText((String) rowData[0]);
                txtTipo.setText(String.valueOf(rowData[1]));
                txtEtapa.setText(String.valueOf(rowData[2]));
            }
        }
    }

    @FXML
    private void btnAgregarActionPerformed(ActionEvent event) {
        String nombre = txtNombres.getText();
        String tipo = txtTipo.getText();
        String etapa = txtEtapa.getText();


        if (nombre.isEmpty() || tipo.isEmpty() || etapa.isEmpty()) {

            return;
        }


        String precioTotal = String.valueOf(Double.parseDouble(tipo) * Integer.parseInt(etapa));


        Object[] rowData = {nombre, etapa, tipo, precioTotal};


        tblRegister.getItems().add(rowData);


        txtNombres.clear();
        txtTipo.clear();
        txtEtapa.clear();


        calcularTotal();
    }

    @FXML
    private void btnEliminarActionPerformed(ActionEvent event) {
        Object[] rowData = tblRegister.getSelectionModel().getSelectedItem();
        if (rowData != null) {
            tblRegister.getItems().remove(rowData);
            calcularTotal();
        }
    }

    @FXML
    private void btnEliminarTodoActionPerformed(ActionEvent event) {
        tblRegister.getItems().clear();
        calcularTotal();
    }

    @FXML
    private void btnEditarActionPerformed(ActionEvent event) {
        Object[] rowData = tblRegister.getSelectionModel().getSelectedItem();
        if (rowData != null) {
            String nombre = txtNombres.getText();
            String tipo = txtTipo.getText();
            String etapa = txtEtapa.getText();


            if (nombre.isEmpty() || tipo.isEmpty() || etapa.isEmpty()) {

                return;
            }


            String precioTotal = String.valueOf(Double.parseDouble(tipo) * Integer.parseInt(etapa));

            rowData[0] = nombre;
            rowData[1] = etapa;
            rowData[2] = tipo;
            rowData[3] = precioTotal;

            tblRegister.refresh();
            calcularTotal();
        }
    }

    private void calcularTotal() {
        total = 0.0;
        for (Object[] rowData : tblRegister.getItems()) {
            total += Double.parseDouble((String) rowData[3]);
        }
        lblTotal.setText("Total: " + total);
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
}
