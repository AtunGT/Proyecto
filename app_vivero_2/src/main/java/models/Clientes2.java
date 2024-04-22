package models;

public class Clientes2 {
    private String nombre;
    private String telefono;

    public Clientes2(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters and setters for nombre y apellido
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = telefono;
    }

    // Método para convertir los datos del cliente a un arreglo
    public Object[] toArray() {
        Object[] obj = new Object[2];

        obj[0] = nombre;
        obj[1] = telefono;

        return obj;
    }
}
