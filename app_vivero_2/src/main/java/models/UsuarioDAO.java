package models;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }

    public int buscar(String usuario) {
        int n = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)) {
                n = i;
                break;
            }
        }
        return n;
    }

    public boolean insertar(Usuario usuario) {
        if (buscar(usuario.getUsuario()) == -1) {
            usuarios.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificar(Usuario usuario) {
        int indice = buscar(usuario.getUsuario());
        if (indice != -1) {
            Usuario usuarioaux = usuarios.get(indice);

            usuarioaux.setContraseña(usuario.getContraseña());
            usuarioaux.setNombre(usuario.getNombre());
            usuarioaux.setApellido(usuario.getApellido());

            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(String usuario) {
        int indice = buscar(usuario);
        if (indice != -1) {
            usuarios.remove(indice);
            return true;
        } else {
            return false;
        }
    }

    public Usuario obtener(String usuario) {
        int indice = buscar(usuario);
        if (indice != -1) {
            return usuarios.get(indice);
        } else {
            return null;
        }
    }
}
