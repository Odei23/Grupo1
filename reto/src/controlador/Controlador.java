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
        return false; 
    }



	public static Usuarios obtenerUsuarioPorDNI(String dni) {
		 Dao imp = new ImplementacionBaseDeDatos();
	        List<Usuarios> usuarios = imp.consultaUsuarios();

	        // Buscar al usuario por su DNI
	        for (Usuarios usuario : usuarios) {
	            if (usuario.getDni().equals(dni)) {
	                return usuario; 
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

	public static float obtenerSaldoUsuario(String dni) {
	    // Obtener la implementación del DAO
	    Dao imp = new ImplementacionBaseDeDatos();
	    
	    // Llamar al método en la implementación de la base de datos para obtener el saldo del usuario por su DNI
	    Usuarios usuario = imp.obtenerUsuarioPorDNI(dni);
	    
	    // Verificar si se encontró al usuario
	    if (usuario != null) {
	        // Devolver el saldo del usuario encontrado
	        return usuario.getSaldo();
	    } else {
	        // Usuario no encontrado, devolver un valor predeterminado o manejar la situación según sea necesario
	        return 0.0f; // Por ejemplo, devolver 0 si el usuario no existe
	    }
	}

	public static void actualizarSaldoUsuario(String dni, float saldoActualizado) {
	    // Obtener la implementación del DAO
	    Dao imp = new ImplementacionBaseDeDatos();
	    
	    // Obtener el usuario por su DNI
	    Usuarios usuario = obtenerUsuarioPorDNI(dni);
	    
	    // Verificar si se encontró al usuario
	    if (usuario != null) {
	        // Actualizar el saldo del usuario
	        usuario.setSaldo(saldoActualizado);
	        
	        // Llamar al método en la implementación de la base de datos para actualizar el usuario
	        imp.actualizarUsuario(usuario);
	    } else {
	        // Manejar la situación si el usuario no existe (lanzar una excepción, registrar un error, etc.)
	        System.out.println("El usuario con DNI " + dni + " no existe.");
	    }
	}


}
