package models;

import javafx.scene.control.TableView;
import javafx.collections.ObservableList;

public class ventas2 {
    private String nombre;
    private String cantidad;
    private double precio;

    public ventas2(String nombre, String cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para convertir el objeto en un array de objetos para la tabla
    public Object[] toArray(){
        Object[] obj = new Object[3];

        obj[0] = nombre;
        obj[1] = cantidad;
        obj[2] = precio;

        return obj;
    }

    // Método para agregar un objeto Ventas3 a una tabla de JavaFX
    public static void agregarAVentas(TableView tabla, ventas2 venta) {
        ObservableList<Object[]> data = tabla.getItems();
        data.add(venta.toArray());
        tabla.setItems(data);
    }
}
