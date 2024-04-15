package controlador;

import java.util.ArrayList;
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

	        // Check if there's a user with the provided DNI and password
	        for (Usuarios usuario : usuarios) {
	            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
	                return true; // User found
	            }
	        }
	        return false; // User not found
	    }
	}