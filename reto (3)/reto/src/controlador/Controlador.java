package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Usuario;
import modelo.Comida;
import modelo.Cura;
import modelo.ImplementacionBaseDeDatos;
import modelo.Objeto;
import modelo.Pokeball;
import modelo.Pokemon;

public class Controlador {

	
	/*
	 * LO QUE HACEMOS AQUÍ ES CONTROLAR TODO RESPECTO AL USUARIO. @ERIK
	 */
    // USUARIO
    public static void altaUsuario(Usuario nuevo) {
        Dao imp = new ImplementacionBaseDeDatos();
        imp.altaUsuarios(nuevo);
    }

    public static Usuario usuarioExiste(String dni, String contrasena) {
        Dao imp = new ImplementacionBaseDeDatos();
        return imp.consultaUsuario(dni, contrasena);
    }

    public static boolean usuarioEsAdmin(String dni, String contrasena) {
        Dao imp = new ImplementacionBaseDeDatos();
        List<Usuario> usuarios = imp.consultaUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni) && usuario.getContrasena().equals(contrasena)) {
                return usuario.isEsAdmin();
            }
        }
        return false;
    }

    public static Usuario obtenerUsuarioPorDNI(String dni) {
        Dao imp = new ImplementacionBaseDeDatos();
        List<Usuario> usuarios = imp.consultaUsuarios();

        // Buscar al usuario por su DNI
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }

    public static void actualizarUsuario(Usuario usuarioModificado) {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

        // Llamar al método para actualizar el usuario en la base de datos
        imp.actualizarUsuario(usuarioModificado);
    }

    public static float obtenerSaldoUsuario(String dni) {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

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
        Dao imp = new ImplementacionBaseDeDatos();

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

    
	/*
	 * LO QUE HACEMOS AQUÍ ES CONTROLAR TODO RESPECTO AL LOS POKEMONS. @ERIK
	 */
    // POKEMON

    public static List<Pokemon> obtenerListaPokemon() {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();
        // Llamar al método para obtener la lista de Pokémon desde la base de datos
        return imp.obtenerListaPokemon();
    }

    public static void realizarCompraPokemon(String dni, int codigo_pokemon, int cantidadDeseada) {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

        // Obtener el usuario por su DNI
        Usuario usuario = imp.obtenerUsuarioPorDNI(dni);

        // Obtener la lista de Pokémon
        List<Pokemon> pokemonList = imp.obtenerListaPokemon();

        // Buscar el Pokémon por su código
        Pokemon pokemonComprado = null;
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getCodigo_pokemon() == codigo_pokemon) {
                pokemonComprado = pokemon;
                break;
            }
        }

        // Verificar si se encontró el usuario y el Pokémon
        if (usuario != null && pokemonComprado != null) {
            // Calcular el total de la compra
            int totalCompra = pokemonComprado.getPrecioPokemon() * cantidadDeseada;

            // Verificar si el usuario tiene suficiente saldo para la compra
            if (usuario.getSaldo() >= totalCompra) {
                // Verificar si hay suficiente stock disponible
                if (cantidadDeseada <= pokemonComprado.getStock_pokemon()) {
                    // Restar el saldo del usuario y actualizar el stock del Pokémon
                    float saldoActualizado = usuario.getSaldo() - totalCompra;
                    int stockActualizado = pokemonComprado.getStock_pokemon() - cantidadDeseada;

                    // Actualizar el saldo del usuario y el stock del Pokémon en la base de datos
                    usuario.setSaldo(saldoActualizado);
                    pokemonComprado.setStock_pokemon(stockActualizado);

                    // Actualizar la información en la base de datos
                    imp.actualizarUsuario(usuario);
                    imp.actualizarPokemon(pokemonComprado);

                    // Mostrar mensaje de compra exitosa
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
                } else {
                    // Mostrar mensaje de error por stock insuficiente
                    JOptionPane.showMessageDialog(null, "Stock insuficiente para realizar la compra.");
                }
            } else {
                // Mostrar mensaje de error por saldo insuficiente
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la compra.");
            }
        } else {
            // Manejar la situación si el usuario o el Pokémon no fueron encontrados
            JOptionPane.showMessageDialog(null, "Usuario o Pokémon no encontrado.");
        }
    }

    public static List<Pokemon> obtenerPokemonPorUsuario(String dni) {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

        // Llamar al método para obtener la lista de Pokémon por usuario desde la base de datos
        return imp.obtenerPokemonPorUsuario(dni);
    }

    public static List<Pokemon> obtenerPokemonComprados(String dni) {
        // Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

        // Llamar al método en la implementación de la base de datos para obtener los Pokémon comprados por el usuario
        return imp.obtenerPokemonPorUsuario(dni);
    }

    // CURA

    public static void realizarCompraCura(String dni, String codigo_objeto, int cantidadDeseada) throws Exception {
        // Obtener la implementación del DAO
        ImplementacionBaseDeDatos imp = new ImplementacionBaseDeDatos();

        // Obtener el usuario por su DNI
        Usuario usuario = imp.obtenerUsuarioPorDNI(dni);

        // Obtener la cura por su código (usando el método obtenerCuraPorCodigo)
        Cura curaComprada = imp.obtenerCuraPorCodigo(codigo_objeto);



        // Verificar si el usuario y la cura existen
        if (usuario != null && curaComprada != null) {
            // Calcular el total de la compra
            int totalCompra = curaComprada.getPrecio_objeto() * cantidadDeseada;

            // Verificar si el usuario tiene suficiente saldo para la compra
            if (usuario.getSaldo() >= totalCompra) {
                // Verificar si hay suficiente stock disponible
                if (cantidadDeseada <= curaComprada.getStock_objeto()) {
                    // Restar el saldo del usuario y actualizar el stock de la cura
                    float saldoActualizado = usuario.getSaldo() - totalCompra;
                    int stockActualizado = curaComprada.getStock_objeto() - cantidadDeseada;

                    // Actualizar el saldo del usuario y el stock de la cura en la base de datos
                    usuario.setSaldo(saldoActualizado);
                    curaComprada.setStock_objeto(stockActualizado);

                    imp.actualizarUsuario(usuario);
                    imp.actualizarCantidadObjeto(codigo_objeto, cantidadDeseada);

                    // La compra se realizó con éxito
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
                } else {
                    throw new Exception("Stock insuficiente para realizar la compra.");
                }
            } else {
                throw new Exception("Saldo insuficiente para realizar la compra.");
            }
        } else {
            throw new Exception("Usuario o cura no encontrada.");
        }
    }


    public static void realizarCompraComida(String dni, String codigo_objeto, int cantidadDeseada) {
    	// Obtener la implementación del DAO
        Dao imp = new ImplementacionBaseDeDatos();

        // Obtener el usuario por su DNI
        Usuario usuario = imp.obtenerUsuarioPorDNI(dni);

        // Obtener la lista de Pokémon
        List<Objeto> comidaList = imp.obtenerListaComida();

        // Buscar el Pokémon por su código
        Objeto comidaComprado = null;
        for (Objeto comida : comidaList) {
        	if (codigo_objeto == null || comida.getCodigo_Objeto() == null || !comida.getCodigo_Objeto().equals(codigo_objeto)) {

            	comidaComprado = comida;
                break;
            }
        }

        // Verificar si se encontró el usuario y el Pokémon
        if (usuario != null && comidaComprado != null) {

        	// Calcular el total de la compra
        	int totalCompra = comidaComprado.getPrecio_objeto() * cantidadDeseada;

            // Verificar si el usuario tiene suficiente saldo para la compra
            if (usuario.getSaldo() >= totalCompra) {
                // Verificar si hay suficiente stock disponible
                if (cantidadDeseada <= comidaComprado.getStock_objeto()) {
                    // Restar el saldo del usuario y actualizar el stock del Pokémon
                    float saldoActualizado = usuario.getSaldo() - totalCompra;
                    int stockActualizado = comidaComprado.getStock_objeto() - cantidadDeseada;

                    // Actualizar el saldo del usuario y el stock del Pokémon en la base de datos
                    usuario.setSaldo(saldoActualizado);
                    comidaComprado.setStock_objeto(stockActualizado);

                    // Actualizar la información en la base de datos
                    imp.actualizarUsuario(usuario);
                    imp.actualizarComida(comidaComprado);

                    // Mostrar mensaje de compra exitosa
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
                } else {
                    // Mostrar mensaje de error por stock insuficiente
                    JOptionPane.showMessageDialog(null, "Stock insuficiente para realizar la compra.");
                }
            } else {
                // Mostrar mensaje de error por saldo insuficiente
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la compra.");
            }
        } else {
            // Manejar la situación si el usuario o el Pokémon no fueron encontrados
            JOptionPane.showMessageDialog(null, "Usuario o Comida no encontrado.");
        }
    }

	 public static void realizarCompraPokeball(String dni, String codigo_objeto, int cantidadDeseada) {
	        // Obtener la implementación del DAO
	        ImplementacionBaseDeDatos imp = new ImplementacionBaseDeDatos();

	        Usuario usuario = imp.obtenerUsuarioPorDNI(dni);

	        if (usuario != null) {
	            // Obtener la lista de Pokeballs
	            List<Objeto> pokeballList = imp.obtenerListaPokeball();

	            // Buscar la Pokeball por su código
	            Objeto pokeballComprada = null;
	            for (Objeto pokeball : pokeballList) {
	                // Verificar que el código de la Pokeball no sea null antes de llamar a equals()
	                if (pokeball.getCodigo_Objeto() != null && pokeball.getCodigo_Objeto().equals(codigo_objeto)) {
	                    pokeballComprada = pokeball;
	                    break;
	                }
	            }

	            // Verificar si se encontró la Pokeball
	            if (pokeballComprada != null) {
	                // Calcular el total de la compra
	                int totalCompra = pokeballComprada.getPrecio_objeto() * cantidadDeseada;

	                // Verificar si el usuario tiene suficiente saldo para la compra
	                if (usuario.getSaldo() >= totalCompra) {
	                    // Verificar si hay suficiente stock disponible
	                    if (cantidadDeseada <= pokeballComprada.getStock_objeto()) {
	                        // Restar el saldo del usuario y actualizar el stock de la Pokeball
	                        float saldoActualizado = usuario.getSaldo() - totalCompra;
	                        int stockActualizado = pokeballComprada.getStock_objeto() - cantidadDeseada;

	                        // Actualizar el saldo del usuario y el stock de la Pokeball en la base de datos
	                        usuario.setSaldo(saldoActualizado);
	                        pokeballComprada.setStock_objeto(stockActualizado);

	                        // Actualizar la información en la base de datos
	                        imp.actualizarUsuario(usuario);
	                        imp.actualizarCantidadObjeto(codigo_objeto, cantidadDeseada);

	                        // Mostrar mensaje de compra exitosa
	                        JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
	                    } else {
	                        // Mostrar mensaje de error por stock insuficiente
	                        JOptionPane.showMessageDialog(null, "Stock insuficiente para realizar la compra.");
	                    }
	                } else {
	                    // Mostrar mensaje de error por saldo insuficiente
	                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la compra.");
	                }
	            } else {
	                // Mostrar mensaje si la Pokeball no fue encontrada
	                JOptionPane.showMessageDialog(null, "Pokeball no encontrada.");
	            }
	        } else {
	            // Mostrar mensaje si el usuario no fue encontrado
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
	        }
	    }

	 public static Comida obtenerComidaPorCodigo(String codigo_Objeto) {
		    // Obtener la implementación del DAO
		    Dao imp = new ImplementacionBaseDeDatos();

		    // Llamar al método en la implementación de la base de datos para obtener la comida por su código
		    return imp.obtenerComidaPorCodigo(codigo_Objeto);
		}

}