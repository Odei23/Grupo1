package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import modelo.ImplementacionBaseDeDatos;

public class Controlador {

    public static void altaUsuario(Usuario nuevo) {
        Dao imp = (Dao) new ImplementacionBaseDeDatos();
        imp.altaUsuarios(nuevo);
    }

    public static Usuario usuarioExiste(String dni, String contrasena) {
        Dao imp = (Dao) new ImplementacionBaseDeDatos();
       
        return imp.consultaUsuario(dni, contrasena);  // Usuario no encontrado
    }

    public static boolean usuarioEsAdmin(String dni, String contrasena) {
        Dao imp = (Dao) new ImplementacionBaseDeDatos();
        List<Usuario> usuarios = imp.consultaUsuarios();

        // Buscar al usuario por DNI y contraseña
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
                // Verificar si el usuario es administrador
                return usuario.isEsAdmin();
            }
        }
        return false; 
    }



	public static Usuario obtenerUsuarioPorDNI(String dni) {
		 Dao imp = (Dao) new ImplementacionBaseDeDatos();
	        List<Usuario> usuarios = imp.consultaUsuarios();

	        // Buscar al usuario por su DNI
	        for (Usuario usuario : usuarios) {
	            if (usuario.getDni().equals(dni)) {
	                return usuario; 
	            }
	        }
	        return null; // Usuario no encontrado		return null;
	}

	public static void actualizarUsuario(Usuario usuarioModificado) {
	    // Obtener la implementación del DAO
	    Dao imp = (Dao) new ImplementacionBaseDeDatos();
	    
	    // Llamar al método para actualizar el usuario en la base de datos
	    imp.actualizarUsuario(usuarioModificado);
	}

	public static float obtenerSaldoUsuario(String dni) {
	    // Obtener la implementación del DAO
	    Dao imp = (Dao) new ImplementacionBaseDeDatos();
	    
	    // Llamar al método en la implementación de la base de datos para obtener el saldo del usuario por su DNI
	    Usuario usuario = imp.obtenerUsuarioPorDNI(dni);
	    
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
	    Dao imp = (Dao) new ImplementacionBaseDeDatos();
	    
	    // Obtener el usuario por su DNI
	    Usuario usuario = obtenerUsuarioPorDNI(dni);
	    
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

	
	  public static boolean cambiarContraseña(String dni, String nuevaContraseña) {
	        ImplementacionBaseDeDatos db = new ImplementacionBaseDeDatos();
	        Usuario usuario = db.obtenerUsuarioPorDNI(dni);

	        if (usuario != null) {
	            // Actualizar la contraseña del usuario en la base de datos
	            usuario.setContrasena(nuevaContraseña);
	            db.actualizarUsuario(usuario);
	            return true; // Contraseña cambiada con éxito
	        } else {
	            return false; // Usuario no encontrado
	        }
	    }

	  public static List<String> obtenerDNIsNoAdministradores() {
		    // Crear una lista para almacenar los DNIs de usuarios no administradores
		    List<String> dnisNoAdmin = new ArrayList<>();
		    
		    // Obtener la implementación del DAO
		    Dao imp = new ImplementacionBaseDeDatos();
		    
		    // Obtener la lista de todos los usuarios
		    List<Usuario> usuarios = imp.consultaUsuarios();
		    
		    // Iterar sobre los usuarios para filtrar los no administradores
		    for (Usuario usuario : usuarios) {
		        if (!usuario.isEsAdmin()) {
		            // Agregar el DNI del usuario no administrador a la lista
		            dnisNoAdmin.add(usuario.getDni());
		        }
		    }
		    
		    return dnisNoAdmin;
		}

		public static List<String> obtenerTodosDNIs() {
		    // Crear una lista para almacenar todos los DNIs
		    List<String> todosDNIs = new ArrayList<>();
		    
		    // Obtener la implementación del DAO
		    Dao imp = new ImplementacionBaseDeDatos();
		    
		    // Obtener la lista de todos los usuarios
		    List<Usuario> usuarios = imp.consultaUsuarios();
		    
		    // Iterar sobre los usuarios para obtener sus DNIs
		    for (Usuario usuario : usuarios) {
		        // Agregar el DNI del usuario a la lista
		        todosDNIs.add(usuario.getDni());
		    }
		    
		    return todosDNIs;
		}


	


}
