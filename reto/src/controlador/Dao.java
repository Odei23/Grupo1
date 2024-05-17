package controlador;

import java.util.List;

import modelo.Comida;
import modelo.Cura;
import modelo.Objeto;
import modelo.Pokeball;
import modelo.Pokemon;
import modelo.Usuario;

public interface Dao {

	//USUARIOS
	
	public void altaUsuarios(Usuario usuario);
	
	List<Usuario> consultaUsuarios();

	public void actualizarUsuario(Usuario usuario);

	public Usuario obtenerUsuarioPorDNI(String dni);

	public Usuario consultaUsuario(String dni, String contrasena);

	
	//POKEMON
	
	public List<Pokemon> obtenerListaPokemon();

	public void actualizarPokemon(Pokemon pokemonComprado);

	public List<Pokemon> obtenerPokemonPorUsuario(String dni);

	public List<Pokemon> obtenerPokemonComprados(String dni);

	
	//CURAS
	
	
	public List<Objeto> obtenerListaCura();

	public void actualizarCura(int cantidadCura, String codigo);

	public Cura obtenerCuraPorCodigo(String codigo_objeto);




	//COMIDAS
	public Comida obtenerComidaPorCodigo(String codigo_objeto);

	public void actualizarComida(String efecto, String codigo);

	
	
	/////POKEBALL
	public void insertarObjeto(String codigo_Objeto, String nombre_objeto, int precio_objeto, int stock_objeto, String imagen_objeto);
	
	public Pokeball obtenerPokeballPorCodigo(String codigo_objeto);

	public void actualizarPokeball(int ratio, String codigo);

	public List<Objeto> obtenerListaPokeball();
	
	public void insertarPokeball(String codigo_Objeto, int ratio);

	public void actualizarCantidadObjeto(String codigo_objeto, int cantidadDeseada);

	public List<Objeto> obtenerListaComida();

	public void actualizarComida(Objeto comidaComprado);

	
}


