package controlador;

import java.util.List;

import modelo.Pokemon;
import modelo.Usuario;

public interface Dao {

	
	public void altaUsuarios(Usuario usuario);
	
	List<Usuario> consultaUsuarios();

	public void actualizarUsuario(Usuario usuario);

	public Usuario obtenerUsuarioPorDNI(String dni);

	public Usuario consultaUsuario(String dni, String contrasena);

	public List<Pokemon> obtenerListaPokemon();

	public void actualizarPokemon(Pokemon pokemonComprado);

	public List<Pokemon> obtenerPokemonPorUsuario(String dni);

	public String obtenerRutaImagenPokemon(int codigoPokemon);
}
