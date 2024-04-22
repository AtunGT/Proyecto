package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    private final StringProperty usuario = new SimpleStringProperty();
    private final StringProperty contraseña = new SimpleStringProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellido = new SimpleStringProperty();

    public Usuario() {
        this(null, null, null, null);
    }

    public Usuario(String usuario, String contraseña, String nombre, String apellido) {
        this.usuario.set(usuario);
        this.contraseña.set(contraseña);
        this.nombre.set(nombre);
        this.apellido.set(apellido);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public void setContraseña(String contraseña) {
        this.contraseña.set(contraseña);
    }

    public StringProperty contraseñaProperty() {
        return contraseña;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }
}
