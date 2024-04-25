package controlador;

import java.util.List;

import modelo.Usuarios;
import modelo.ImplementacionBaseDeDatos;

public class Controlador {

    public static void altaUsuario(Usuarios nuevo) {
        Dao imp = new ImplementacionBaseDeDatos();
        imp.altaUsuarios(nuevo);
    }

    public static boolean usuarioExiste(String dni, String contrasena) {
        Dao imp = new ImplementacionBaseDeDatos();
        List<Usuarios> usuarios = imp.consultaUsuarios();

        // Comprobar si hay un usuario con el DNI y la contraseña proporcionados
        for (Usuarios usuario : usuarios) {
            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
                return true; // Usuario encontrado
            }
        }
        return false; // Usuario no encontrado
    }

    public static boolean usuarioEsAdmin(String dni, String contrasena) {
        Dao imp = new ImplementacionBaseDeDatos();
        List<Usuarios> usuarios = imp.consultaUsuarios();

        // Buscar al usuario por DNI y contraseña
        for (Usuarios usuario : usuarios) {
            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
                // Verificar si el usuario es administrador
                return usuario.isEsAdmin();
            }
        }
        return false; // Usuario no encontrado o no es administrador
    }



	public static Usuarios obtenerUsuarioPorDNI(String dni) {
		 Dao imp = new ImplementacionBaseDeDatos();
	        List<Usuarios> usuarios = imp.consultaUsuarios();

	        // Buscar al usuario por su DNI
	        for (Usuarios usuario : usuarios) {
	            if (usuario.getDni().equals(dni)) {
	                return usuario; // Devolver el usuario encontrado
	            }
	        }
	        return null; // Usuario no encontrado		return null;
	}

	public static void actualizarUsuario(Usuarios usuarioModificado) {
	    // Obtener la implementación del DAO
	    Dao imp = new ImplementacionBaseDeDatos();
	    
	    // Llamar al método para actualizar el usuario en la base de datos
	    imp.actualizarUsuario(usuarioModificado);
	}

}
