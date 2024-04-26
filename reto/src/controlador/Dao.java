package controlador;

import java.util.List;

import modelo.Usuario;

public interface Dao {

	
	public void altaUsuarios(Usuario usuario);
	
	List<Usuario> consultaUsuarios();

	public void actualizarUsuario(Usuario usuario);

	public Usuario obtenerUsuarioPorDNI(String dni);

	public Usuario consultaUsuario(String dni, String contrasena);
}
