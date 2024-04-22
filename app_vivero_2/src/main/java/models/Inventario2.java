package models;

public class Inventario2 {
    private String nombre;
    private String cantidad;
    private String precio;

    public Inventario2(String nombre, String cantidad, String precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Inventario2(){

    }

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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Object[] toArray(){
        Object[] obj = new Object[3];

        obj[0] = nombre;
        obj[1] = cantidad;
        obj[2] = precio;

        return obj;
    }
}
