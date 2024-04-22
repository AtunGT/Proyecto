package models;

import models.Usuario;
import models.UsuarioDAO;

public class UsuarioLogin {
    private static UsuarioDAO usuariodao = new UsuarioDAO();

    public static boolean autentificar(String usuario, String contraseña) {
        Usuario usuarioConsulta = obtener(usuario);
        return usuarioConsulta != null && usuarioConsulta.getUsuario().equals(usuario) && usuarioConsulta.getContraseña().equals(contraseña);
    }

    public static boolean insertar(Usuario usuario) {
        return usuariodao.insertar(usuario);
    }

    public static boolean modificar(Usuario usuario) {
        return usuariodao.modificar(usuario);
    }

    public static boolean eliminar(String usuario) {
        return usuariodao.eliminar(usuario);
    }

    public static Usuario obtener(String usuario) {
        return usuariodao.obtener(usuario);
    }
}
