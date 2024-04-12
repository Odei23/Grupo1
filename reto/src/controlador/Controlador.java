package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuarios;
import modelo.ImplementacionBaseDeDatos;


public class Controlador {

	public static void altaCoche(Usuarios nuevo) {
		
		Dao imp = new ImplementacionBaseDeDatos();
		imp.altaUsuarios(nuevo);
	
	}


	public static List<Usuarios> consultaCoches() {
		Dao imp = new ImplementacionBaseDeDatos();
		List <Usuarios> listaCoches = new ArrayList<>();
		
		listaCoches = imp.consultaUsuarios();
		
		return listaCoches;
		
		
	}

}
