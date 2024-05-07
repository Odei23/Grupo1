package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controlador.Dao;

public class ImplementacionBaseDeDatos implements Dao {

	 private Connection conect;
	    private PreparedStatement stat;
	    private ResourceBundle fichConfBundle;
	    private String url;
	    private String user;
	    private String passwd;

    final String INSERT_USUARIOS = "INSERT INTO cliente VALUES( ?, ?, ?, ?, ?, ?, ?)";

    private final String CONSULTA_USUARIOS = "SELECT * FROM cliente";

    private final String CONSULTA_USUARIO = "SELECT * FROM cliente WHERE dni = ? AND contrasena = ?";
    private final String INSERT_POKEMON = "INSERT INTO pokemon VALUES (?, ?, ?, ?, ?, ? , ?, ?, ?)";

    private final String UPDATE_POKEMON = "UPDATE pokemon SET nombre=?, tipo=?, color=?, num_evo=?, precio_pokemon=?, stock_pokemon=?, imagen_pokemon=? WHERE codigo_pokemon=?";
    private final String SELECT_CODIGOS_POKEMON = "SELECT codigo_pokemon FROM pokemon";
    private final String SELECT_POKEMON_POR_CODIGO = "SELECT * FROM pokemon WHERE codigo_pokemon=?";
    
    
    
    private final String UPDATE_CURA = "UPDATE curas SET nombre_curas=?, codigo_objeto=?, imagen_curas=? WHERE codigo_objeto=?";
    private final String SELECT_CODIGO_OBJETO = "SELECT codigo_objeto FROM curas";
    private final String SELECT_CURAS_POR_CODIGO = "SELECT * FROM cura WHERE codigo_objeto=?";

    public ImplementacionBaseDeDatos() {
        openConnection(); // Llamar al método openConnection para inicializar la conexión
    }

    // Método para abrir la conexión
 // Método para abrir la conexión
    public Connection openConnection() {
        fichConfBundle = ResourceBundle.getBundle("modelo.config");
        this.url = fichConfBundle.getString("URL");
        this.user = fichConfBundle.getString("USER");
        this.passwd = fichConfBundle.getString("PASSWD");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection(url, user, passwd);
            return conect; // Devolver la conexión abierta
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la conexión a la BD");
            e.printStackTrace();
        }

        return null; // En caso de error, devuelve null
    }



    @Override
    public void altaUsuarios(Usuario usuario) {
        openConnection();

        try {
            stat = conect.prepareStatement(INSERT_USUARIOS);

            // SUSTITUIMOS ARGUMENTOS EN SENTENCIAS SQL
            stat.setString(1, usuario.getDni());
            stat.setString(2, usuario.getNombre());
            stat.setString(3, usuario.getApellido());
            stat.setDate(4, Date.valueOf(usuario.getFechaNac())); // Use Date.valueOf to convert LocalDate to SQL Date

            // Verificar si el saldo es nulo antes de establecerlo en la sentencia SQL
            if (usuario.getSaldo() != null) {
                stat.setFloat(5, usuario.getSaldo());
            } else {
                // Si el saldo es nulo, establecer un valor predeterminado o dejarlo como NULL
                // en la base de datos, dependiendo de tus requisitos
                stat.setNull(5, Types.FLOAT);
            }

            stat.setString(6, usuario.getContrasena());
            stat.setBoolean(7, usuario.isEsAdmin()); // Nuevo parámetro para esAdmin

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> consultaUsuarios() {
        ResultSet rs;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario;

        openConnection();

        try {
            stat = conect.prepareStatement(CONSULTA_USUARIOS);
            rs = stat.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setDni(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                Date date = rs.getDate(4);
                LocalDate localDate = date.toLocalDate();
                usuario.setFechaNac(localDate);
                usuario.setSaldo(rs.getFloat(5));
                usuario.setContrasena(rs.getString(6));
                usuario.setEsAdmin(rs.getBoolean(7)); // Establecer esAdmin con el valor de la base de datos

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // En la clase ImplementacionBaseDeDatos

    @Override
    public void actualizarUsuario(Usuario usuario) {
        openConnection();

        try {
            String UPDATE_USUARIO = "UPDATE cliente SET nombre=?, apellido=?, fecha_nac=?, contrasena=?, saldo=? WHERE dni=?";
            stat = conect.prepareStatement(UPDATE_USUARIO);

            // Establecer los valores para los parámetros de la sentencia SQL
            stat.setString(1, usuario.getNombre());
            stat.setString(2, usuario.getApellido());
            stat.setDate(3, Date.valueOf(usuario.getFechaNac())); // Suponiendo que la fecha se almacena en formato SQL DATE
            stat.setString(4, usuario.getContrasena());

            // Verificar si el saldo es nulo antes de establecerlo en la sentencia SQL
            if (usuario.getSaldo() != null) {
                stat.setFloat(5, usuario.getSaldo());
            } else {
                // Dejar el saldo como está en la base de datos
                // Esto se hace pasando el valor actual del saldo al parámetro de la sentencia SQL
                stat.setFloat(5, obtenerSaldoActual(usuario.getDni()));
            }

            stat.setString(6, usuario.getDni());

            // Ejecutar la actualización
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el saldo actual de un usuario por su DNI
    private float obtenerSaldoActual(String dni) throws SQLException {
        String CONSULTA_SALDO = "SELECT saldo FROM cliente WHERE dni=?";
        PreparedStatement statSaldo = conect.prepareStatement(CONSULTA_SALDO);
        statSaldo.setString(1, dni);
        ResultSet rs = statSaldo.executeQuery();
        float saldoActual = 0.0f;
        if (rs.next()) {
            saldoActual = rs.getFloat("saldo");
        }
        return saldoActual;
    }

    @Override
    public Usuario obtenerUsuarioPorDNI(String dni) {
        openConnection();
        Usuario usuario = null;
        ResultSet rs = null;

        try {
            String CONSULTA_USUARIO_POR_DNI = "SELECT * FROM cliente WHERE dni=?";
            stat = conect.prepareStatement(CONSULTA_USUARIO_POR_DNI);
            stat.setString(1, dni);
            rs = stat.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setDni(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                Date date = rs.getDate(4);
                LocalDate localDate = date.toLocalDate();
                usuario.setFechaNac(localDate);
                usuario.setSaldo(rs.getFloat(5));
                usuario.setContrasena(rs.getString(6));
                usuario.setEsAdmin(rs.getBoolean(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conect != null) {
                    conect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public Usuario consultaUsuario(String dni, String contrasena) {
        openConnection();
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stat = conect.prepareStatement(CONSULTA_USUARIO);
            stat.setString(1, dni);
            stat.setString(2, contrasena);
            rs = stat.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setDni(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                Date date = rs.getDate(4);
                LocalDate localDate = date.toLocalDate();
                usuario.setFechaNac(localDate);
                usuario.setSaldo(rs.getFloat(5));
                usuario.setContrasena(rs.getString(6));
                usuario.setEsAdmin(rs.getBoolean(7));
            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conect != null) {
                    conect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usuario;
    }

    public boolean cambiarContrasenaEnBaseDeDatos(String dni, String nuevaContrasena) {
        openConnection(); // Inicializar la conexión a la base de datos

        String sql = "UPDATE cliente SET contrasena = ? WHERE dni = ?";
        try (Connection conn = DriverManager.getConnection(url, user, passwd);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nuevaContrasena);
            statement.setString(2, dni);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Asegúrate de cerrar la conexión después de su uso
            try {
                if (conect != null) {
                    conect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void altaPokemon(Pokemon pokemon) {
        openConnection(); // Abre la conexión antes de ejecutar la consulta

        try {
            stat = conect.prepareStatement(INSERT_POKEMON);
            stat.setString(1, pokemon.getNombre());
            stat.setString(2, pokemon.getTipo());
            stat.setString(3, pokemon.getColor());
            stat.setInt(4, pokemon.getNum_evo());
            stat.setInt(5, pokemon.getPrecioPokemon());
            stat.setInt(6, pokemon.getStock_pokemon());
            stat.setString(7, pokemon.getImagen_pokemon());

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(); // Cierra la conexión después de usarla
        }
    }

    public void actualizarPokemon(Pokemon pokemon) {
        openConnection(); // Abre la conexión antes de ejecutar la consulta

        try {
            stat = conect.prepareStatement(UPDATE_POKEMON);
            stat.setString(1, pokemon.getNombre());
            stat.setString(2, pokemon.getTipo());
            stat.setString(3, pokemon.getColor());
            stat.setInt(4, pokemon.getNum_evo());
            stat.setInt(5, pokemon.getPrecioPokemon());
            stat.setInt(6, pokemon.getStock_pokemon());
            stat.setString(7, pokemon.getImagen_pokemon());
            stat.setInt(8, pokemon.getCodigo_pokemon());

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(); // Cierra la conexión después de usarla
        }
    }
    public List<Integer> obtenerCodigosPokemon() {
        List<Integer> codigos = new ArrayList<>();
        openConnection(); // Asegúrate de abrir la conexión aquí

        try {
            stat = conect.prepareStatement(SELECT_CODIGOS_POKEMON);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                codigos.add(rs.getInt("codigo_pokemon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codigos;
    }

    public Pokemon obtenerPokemonPorCodigo(int codigo) {
        Pokemon pokemon = null;
        try {
            stat = conect.prepareStatement(SELECT_POKEMON_POR_CODIGO);
            stat.setInt(1, codigo);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                pokemon = new Pokemon();
                pokemon.setCodigo_pokemon(rs.getInt("codigo_pokemon"));
                pokemon.setNombre(rs.getString("nombre"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setColor(rs.getString("color"));
                pokemon.setNum_evo(rs.getInt("num_evo"));
                pokemon.setPrecioPokemon(rs.getInt("precio_pokemon"));
                pokemon.setStock_pokemon(rs.getInt("stock_pokemon"));
                pokemon.setImagen_pokemon(rs.getString("imagen_pokemon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public void closeConnection() {
        try {
            if (stat != null) {
                stat.close();
            }
            if (conect != null) {
                conect.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Pokemon> obtenerListaPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();
        try (Connection con = openConnection();
             PreparedStatement stat = con.prepareStatement("SELECT * FROM pokemon");
             ResultSet rs = stat.executeQuery()) {

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setCodigo_pokemon(rs.getInt("codigo_pokemon"));
                pokemon.setNombre(rs.getString("nombre"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setColor(rs.getString("color"));
                pokemon.setNum_evo(rs.getInt("num_evo"));
                pokemon.setPrecioPokemon(rs.getInt("precio_pokemon"));
                pokemon.setStock_pokemon(rs.getInt("stock_pokemon"));
                pokemon.setImagen_pokemon(rs.getString("imagen_pokemon"));
                pokemonList.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }

    @Override
    public List<Pokemon> obtenerPokemonPorUsuario(String dni) {
        List<Pokemon> pokemonList = new ArrayList<>();
        openConnection(); // Abre la conexión antes de ejecutar la consulta

        try {
            String sql = "SELECT * FROM pokemon p JOIN compra c ON p.codigo_pokemon = codigo_pokemon WHERE c.dni = ?";
            stat = conect.prepareStatement(sql);
            stat.setString(1, dni);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setCodigo_pokemon(rs.getInt("codigo_pokemon"));
                pokemon.setNombre(rs.getString("nombre"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setColor(rs.getString("color"));
                pokemon.setNum_evo(rs.getInt("num_evo"));
                pokemon.setPrecioPokemon(rs.getInt("precio_pokemon"));
                pokemon.setStock_pokemon(rs.getInt("stock_pokemon"));
                pokemon.setImagen_pokemon(rs.getString("imagen_pokemon"));
                pokemonList.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(); // Cierra la conexión después de usarla
        }
        return pokemonList;
    }

    public void actualizarCura(Cura cura) {
        try {
            String UPDATE_CURA = "UPDATE cura SET nombre_cura=?, stock_cura=?, precio_cura=?, imagen_cura=? WHERE codigo_objeto=?";
            stat = conect.prepareStatement(UPDATE_CURA);
            stat.setString(1, cura.getNombre_cura());
            stat.setInt(2, cura.getStock_cura());
            stat.setInt(3, cura.getPrecio_cura());
            stat.setString(4, cura.getImagen_cura());
            stat.setString(5, cura.getCodigo_objeto());
          
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<String> obtenerCodigosCura(String dni) {
	    List<String> codigos = new ArrayList<>();
	    try {
	        String SELECT_CURA_CODIGOS = "SELECT codigo_objeto FROM cura";
	        stat = conect.prepareStatement(SELECT_CURA_CODIGOS);
	        ResultSet rs = stat.executeQuery();
	        while (rs.next()) {
	            codigos.add(rs.getString("codigo_objeto"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Manejar la excepción apropiadamente, por ejemplo, lanzando una excepción o devolviendo null
	        // dependiendo de los requisitos del programa
	    }
	    return codigos;
	}


	public Cura obtenerCurasPorCodigo(String codigo_objeto) {
		Cura cura = null;
        try {
            stat = conect.prepareStatement(SELECT_CURAS_POR_CODIGO);
            stat.setString(1, codigo_objeto);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                cura = new Cura();
                cura.setCodigo_objeto(rs.getString("codigo_objeto"));
                cura.setNombre_cura(rs.getString("nombre_curas"));
                cura.setImagen_cura(rs.getString("imagen_curas"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cura;
    }

	 public List<Pokemon> obtenerPokemonComprados(String dni) {
	        List<Pokemon> pokemonComprados = new ArrayList<>();
	        // Obtener la lista completa de Pokémon asociados al usuario
	        List<Pokemon> pokemonList = obtenerPokemonPorUsuario(dni);

	        // Filtrar solo los Pokémon que han sido marcados como comprados
	        for (Pokemon pokemon : pokemonList) {
	            if (pokemon.isComprado()) {
	                pokemonComprados.add(pokemon);
	            }
	        }

	        return pokemonComprados;
	    }

	 public List<String> obtenerCodigosCuras(String dni) {
		    List<String> codigos = new ArrayList<>();
		    try {
		        String SELECT_CURA_CODIGOS = "SELECT codigo_objeto FROM cura";
		        stat = conect.prepareStatement(SELECT_CURA_CODIGOS);
		        ResultSet rs = stat.executeQuery();
		        while (rs.next()) {
		            codigos.add(rs.getString("codigo_objeto"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Manejar la excepción apropiadamente, por ejemplo, lanzando una excepción o devolviendo null
		        // dependiendo de los requisitos del programa
		    }
		    return codigos;
		}

	 public Cura obtenerCuraPorCodigo(String codigo) {
		    Cura cura = null;
		    try {
		        String SELECT_CURA_POR_CODIGO = "SELECT * FROM cura WHERE codigo_objeto=?";
		        stat = conect.prepareStatement(SELECT_CURA_POR_CODIGO);
		        stat.setString(1, codigo);
		        ResultSet rs = stat.executeQuery();
		        if (rs.next()) {
		            cura = new Cura();
		            cura.setCodigo_objeto(rs.getString("codigo_objeto"));
		            cura.setNombre_cura(rs.getString("nombre_cura"));
		            cura.setPrecio_cura(rs.getInt("precio_cura"));
		            cura.setStock_cura(rs.getInt("stock_cura"));
		            cura.setImagen_cura(rs.getString("imagen_cura"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Manejar la excepción apropiadamente, por ejemplo, lanzando una excepción o devolviendo null
		        // dependiendo de los requisitos del programa
		    }
		    return cura;
		}

	public List<Cura> obtenerListaCura() {
		  List<Cura> curaList = new ArrayList<>();
	        try (Connection con = openConnection();
	             PreparedStatement stat = con.prepareStatement("SELECT * FROM cura");
	             ResultSet rs = stat.executeQuery()) {

	            while (rs.next()) {
	                Cura cura = new Cura();
	                cura.setCodigo_objeto(rs.getString("codigo_objeto"));
	                cura.setNombre_cura(rs.getString("nombre_cura"));
	                cura.setStock_cura(rs.getInt("stock_cura"));
	                cura.setPrecio_cura(rs.getInt("precio_cura"));
	                cura.setImagen_cura(rs.getString("imagen_cura"));
	                curaList.add(cura);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return curaList;
	    }
	
    
	}		
	



