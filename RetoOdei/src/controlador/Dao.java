package controlador;

import java.util.List;

import modelo.Usuario;

public interface Dao {

	
	public void altaUsuarios(Usuario usuario);
	
	List<Usuario> consultaUsuarios();
}
