package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import modelo.ImplementacionBaseDeDatos;


public class Controlador {

	private static Dao imp = new ImplementacionBaseDeDatos();
	
	public static void altaUsuario(Usuario nuevo) {
		
		
		imp.altaUsuarios(nuevo);
	
	}



	    public static boolean usuarioExiste(String dni, String contrasena) {
	       
	        List<Usuario> usuarios = imp.consultaUsuarios();

	        // Check if there's a user with the provided DNI and password
	        for (Usuario usuario : usuarios) {
	            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
	                return true; // User found
	            }
	        }
	        return false; // User not found
	    }



	    public static boolean usuarioEsAdmin(String dni, String contrasena) {
	      
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



		/*public static Usuario editarDatos(Usuario per) {
			// TODO Auto-generated method stub
			return imp.editarDatos(per);
		}
*/


		

	}



