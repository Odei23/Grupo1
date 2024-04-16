package controlador;

import java.util.List;

import modelo.Usuarios;

public interface Dao {

	
	public void altaUsuarios(Usuarios usuario);
	
	List<Usuarios> consultaUsuarios();
}
