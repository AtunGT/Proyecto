package models;

public class Proveedores2 {
    private String nombre;
    private String telefono;
    private String direccion;

    public Proveedores2(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Object[] toArray(){
        Object[] obj = new Object[3];

        obj[0] = nombre;
        obj[1] = telefono;
        obj[2] = direccion;

        return obj;
    }
}