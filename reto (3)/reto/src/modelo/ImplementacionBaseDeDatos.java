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

import controlador.Controlador;
import controlador.Dao;


public class ImplementacionBaseDeDatos implements Dao {

	 private Connection conect;
	    private PreparedStatement stat;
	    private ResourceBundle fichConfBundle;
	    private String url;
	    private String user;
	    private String passwd;

	    private final String INSERT_USUARIOS = "INSERT INTO cliente VALUES(?, ?, ?, ?, ?, ?, ?)";
	    private final String CONSULTA_USUARIOS = "SELECT * FROM cliente";
	    private final String CONSULTA_USUARIO = "SELECT * FROM cliente WHERE dni = ? AND contrasena = ?";
	    private final String INSERT_POKEMON = "INSERT INTO pokemon VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    private final String UPDATE_POKEMON = "UPDATE pokemon SET nombre=?, tipo=?, color=?, num_evo=?, precio_pokemon=?, stock_pokemon=?, imagen_pokemon=? WHERE codigo_pokemon=?";
	    private final String SELECT_CODIGOS_POKEMON = "SELECT codigo_pokemon FROM pokemon";
	    private final String SELECT_POKEMON_POR_CODIGO = "SELECT * FROM pokemon WHERE codigo_pokemon=?";
	    private final String UPDATE_OBJETO = "UPDATE objeto SET nombre_objeto=?, precio_objeto=?, stock_objeto=?, imagen_objeto=? WHERE codigo_objeto=?";
	    private final String UPDATE_CURA = "UPDATE cura SET cantidad_cura=? WHERE codigo_objeto=?";
	    private final String SELECT_CODIGOS_POKEBALL = "SELECT max(codigo_objeto) FROM pokeball";
	    private final String SELECT_CODIGOS_CURA = "SELECT max(codigo_objeto) FROM cura";
	    private final String SELECT_CODIGOS_COMIDA = "SELECT max(codigo_objeto) FROM comida";

	    private final String INSERT_POKEBALL = "INSERT INTO pokeball (codigo_objeto, ratio_captura) VALUES (?, ?)";
	    private final String INSERT_CURA = "INSERT INTO cura (codigo_objeto, cantidad_cura) VALUES (?, ?)";
	    private final String INSERT_COMIDA = "INSERT INTO comida (codigo_objeto, efecto) VALUES (?, ?)";

	    private final String UPDATE_POKEBALL = "UPDATE pokeball SET ratio_captura=? WHERE codigo_objeto=?";
	    private final String UPDATE_COMIDA = "UPDATE comida SET efecto=? WHERE codigo_objeto=?";
	    private final String SELECT_CURAS_POR_CODIGO = "SELECT * FROM cura WHERE codigo_objeto=?";
	    private final String INSERT_OBJETO = "INSERT INTO objeto (codigo_objeto, nombre_objeto, stock_objeto, precio_objeto, imagen_objeto) VALUES (?,?,?,?,?)";

    
    public ImplementacionBaseDeDatos() {
        openConnection();
    }
    	
    // Método para abrir la conexión
    public Connection openConnection() {
        fichConfBundle = ResourceBundle.getBundle("modelo.config");
        this.url = fichConfBundle.getString("URL");
        this.user = fichConfBundle.getString("USER");
        this.passwd = fichConfBundle.getString("PASSWD");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection(url, user, passwd);
            return conect; 
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la conexión a la BD");
            e.printStackTrace();
        }

        return null; 
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

	    
	
	//USUARIOS
	
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

    
    //POKEMON
	
	
    
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
            stat.setInt(8, pokemon.getCodigo_pokemon());

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
    


	public void insertarPokemon(Pokemon nuevoPokemon) {
	    // Abre la conexión con la base de datos
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = openConnection(); // Método que obtiene la conexión a la base de datos
	        String sql = "INSERT INTO pokemon (codigo_pokemon, nombre, tipo, color, num_evo, precio_pokemon, stock_pokemon, imagen_pokemon) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, nuevoPokemon.getCodigo_pokemon());
	        stmt.setString(2, nuevoPokemon.getNombre());
	        stmt.setString(3, nuevoPokemon.getTipo());
	        stmt.setString(4, nuevoPokemon.getColor());
	        stmt.setInt(5, nuevoPokemon.getNum_evo());
	        stmt.setInt(6, nuevoPokemon.getPrecioPokemon());
	        stmt.setInt(7, nuevoPokemon.getStock_pokemon());
	        stmt.setString(8, nuevoPokemon.getImagen_pokemon());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cierra los recursos
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }}}
	        }
    
    ///OBJETO
    
    
    public Objeto obtenerObjetoPorCodigo(String codigo) {
		 Objeto objeto = null;
		    try {
		        String SELECT_OBJETO_POR_CODIGO = "SELECT * FROM OBJETO WHERE codigo_objeto=?";
		        stat = conect.prepareStatement(SELECT_OBJETO_POR_CODIGO);
		        stat.setString(1, codigo);
		        ResultSet rs = stat.executeQuery();
		        if (rs.next()) {
		        	objeto = new Objeto();
		            objeto.setCodigo_Objeto(rs.getString("codigo_objeto"));
		            objeto.setNombre_objeto(rs.getString("nombre_objeto"));
		            objeto.setPrecio_objeto(rs.getInt("precio_objeto"));
		            objeto.setStock_objeto(rs.getInt("stock_objeto"));
		            objeto.setImagen_objeto(rs.getString("imagen_objeto"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Manejar la excepción apropiadamente, por ejemplo, lanzando una excepción o devolviendo null
		        // dependiendo de los requisitos del programa
		    }
		    return objeto;
		}
    //CURAS

    
	public void actualizarCura(int cantidadCura, String codigo) {
		this.openConnection();
		  try {
	            stat = conect.prepareStatement(UPDATE_CURA);          
	            stat.setInt(1, cantidadCura);
	            stat.setString(2, codigo);
	            stat.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		  closeConnection();
		
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
	        // Abre la conexión
	    	openConnection();

	        stat = conect.prepareStatement(SELECT_CURAS_POR_CODIGO);
	        stat.setString(1, codigo_objeto);
	        ResultSet rs = stat.executeQuery();
	        if (rs.next()) {
	            cura = new Cura();
	            cura.setCodigo_Objeto(rs.getString("codigo_objeto"));
	            cura.setNombre_objeto(rs.getString("nombre_objeto"));
	            cura.setImagen_objeto(rs.getString("imagen_objeto"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cierra la conexión
	    	closeConnection();
	    }
	    return cura;
	}

	 
	public Cura obtenerCuraPorCodigo(String codigo) {
	    Cura cura = null;
	    try {
	    	openConnection();
	        String SELECT_CURA_POR_CODIGO = "SELECT * FROM cura WHERE codigo_objeto = ?";
	        stat = conect.prepareStatement(SELECT_CURA_POR_CODIGO);
	        stat.setString(1, codigo);
	        ResultSet rs = stat.executeQuery();
	        if (rs.next()) {
	            cura = new Cura();
	            cura.setCodigo_Objeto(rs.getString("codigo_objeto"));
	            cura.setCantidad_cura(rs.getInt("cantidad_cura"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection();
	    }
	    return cura;
	}

	 
	 public List<Objeto> obtenerListaCura() {
		    List<Objeto> curaList = new ArrayList<>();
		    try (Connection con = openConnection();
		         PreparedStatement stat = con.prepareStatement("SELECT * FROM objeto WHERE codigo_objeto LIKE '%CU%'");
		         ResultSet rs = stat.executeQuery()) {

		        while (rs.next()) {
		            Objeto obj = new Objeto();
		            obj.setNombre_objeto(rs.getString("nombre_objeto"));
		            obj.setStock_objeto(rs.getInt("stock_objeto"));
		            obj.setPrecio_objeto(rs.getInt("precio_objeto"));
		            obj.setImagen_objeto(rs.getString("imagen_objeto"));
		            curaList.add(obj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return curaList;
		}
	 
	 
		public String obtenerCodigosCura() {
			 openConnection(); // Asegúrate de abrir la conexión aquí
			    String cod = null;
			    int num = 0;
			    try {
			        stat = conect.prepareStatement(SELECT_CODIGOS_CURA);
			        ResultSet rs = stat.executeQuery();
			        if (rs.next()) { // Mover el cursor a la primera fila
			            cod = rs.getString(1);
			            num = Integer.parseInt(cod.substring(2));
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    } finally {
			        closeConnection(); // Asegúrate de cerrar la conexión aquí
			    }
			    if (cod == null) {
			        // Manejar el caso en que no se encontraron resultados
			        return null; // o algún valor predeterminado según lo que necesites
			    }
			    return "CU" + String.format("%03d", num + 1);
		}
	 
	 
	 ///////COMIDAAAAA
	
	 
		@Override
		public void actualizarComida(Objeto comidaComprado) {
			openConnection();
			try {
		        // Prepare SQL statement to update the food item
		        String sql = "UPDATE comida SET stock_objeto = ? WHERE codigo_objeto = ?";
		        
		        // Set the parameters for the SQL statement
		        stat.setInt(1, comidaComprado.getStock_objeto());
		        stat.setString(2, comidaComprado.getCodigo_Objeto());
		        
		        // Execute the update statement
		        int rowsUpdated = stat.executeUpdate();   
		     
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			closeConnection();

	}
	public List<String> obtenerCodigosComida(String dni) {
		 List<String> codigos = new ArrayList<>();
		    try {
		        String SELECT_COMIDA_CODIGOS = "SELECT codigo_objeto FROM comida";
		        stat = conect.prepareStatement(SELECT_COMIDA_CODIGOS);
		        ResultSet rs = stat.executeQuery();
		        while (rs.next()) {
		            codigos.add(rs.getString("codigo_objeto"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		       
		    }
		    return codigos;
		
	}

	public Comida obtenerComidaPorCodigo(String codigo) {
		openConnection();

	    Comida comida = null;
	    try {
	        String SELECT_COMIDA_POR_CODIGO = "SELECT * FROM comida WHERE codigo_objeto = ?";
	        stat = conect.prepareStatement(SELECT_COMIDA_POR_CODIGO);
	        stat.setString(1, codigo);
	        ResultSet rs = stat.executeQuery();
	        if (rs.next()) {
	        	comida= new Comida();
	        	comida.setCodigo_Objeto(rs.getString("codigo_objeto"));
	        	comida.setEfecto(rs.getString("efecto"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
	    closeConnection();
	    return comida;
	}

	public List<Objeto> obtenerListaComida() {
		  List<Objeto> comidaList = new ArrayList<>();
		    try (Connection con = openConnection();
		         PreparedStatement stat = con.prepareStatement("SELECT * FROM objeto WHERE codigo_objeto LIKE '%CO%'");
		         ResultSet rs = stat.executeQuery()) {

		        while (rs.next()) {
		            Objeto obj = new Objeto();
		            obj.setNombre_objeto(rs.getString("nombre_objeto"));
		            obj.setStock_objeto(rs.getInt("stock_objeto"));
		            obj.setPrecio_objeto(rs.getInt("precio_objeto"));
		            obj.setImagen_objeto(rs.getString("imagen_objeto"));
		            comidaList.add(obj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return comidaList;
	}
	
	

	public void insertarComida(String codigo_Objeto, String efecto) {
		try {
	        openConnection();
	        PreparedStatement stmt = conect.prepareStatement(INSERT_COMIDA);
	        stmt.setString(1, codigo_Objeto);
	        stmt.setString(2, efecto);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(); // Cerrar la conexión aquí
	    }
	}

	public String obtenerCodigosComida() {
		 openConnection(); 
		    String cod = null;
		    int num = 0;
		    try {
		        stat = conect.prepareStatement(SELECT_CODIGOS_COMIDA);
		        ResultSet rs = stat.executeQuery();
		        if (rs.next()) { // Mover el cursor a la primera fila
		            cod = rs.getString(1);
		            num = Integer.parseInt(cod.substring(2));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        closeConnection(); // Asegúrate de cerrar la conexión aquí
		    }
		    if (cod == null) {
		        // Manejar el caso en que no se encontraron resultados
		        return null; // o algún valor predeterminado según lo que necesites
		    }
		    return "CO" + String.format("%03d", num + 1);
	}
		    
		    public void actualizarComida(String efecto, String codigo) {

				 try {
				        openConnection();

			            stat = conect.prepareStatement(UPDATE_COMIDA);          
			            stat.setString(1, efecto);
			            stat.setString(2, codigo);
			            stat.executeUpdate();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }   finally {
				        closeConnection(); // Asegúrate de cerrar la conexión aquí
				    }		
				
			
	}
	
	////////POKEBALL
	
	


	public List<String> obtenerCodigosPokeball(String dni) {
		List<String> codigos = new ArrayList<>();
	    try {
	        String SELECT_POKEBALL_CODIGOS = "SELECT codigo_objeto FROM pokeball";
	        stat = conect.prepareStatement(SELECT_POKEBALL_CODIGOS);
	        ResultSet rs = stat.executeQuery();
	        while (rs.next()) {
	            codigos.add(rs.getString("codigo_objeto"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
	    return codigos;
	
	}

	public Pokeball obtenerPokeballPorCodigo(String codigo) {
		openConnection();

		Pokeball pokeball = null;
	    try {
	        String SELECT_POKEBALL_POR_CODIGO = "SELECT * FROM pokeball WHERE codigo_objeto = ?";
	        stat = conect.prepareStatement(SELECT_POKEBALL_POR_CODIGO);
	        stat.setString(1, codigo);
	        ResultSet rs = stat.executeQuery();
	        if (rs.next()) {
	        	pokeball= new Pokeball();
	        	pokeball.setCodigo_Objeto(rs.getString("codigo_objeto"));
	        	pokeball.setRatio(rs.getInt("ratio_captura"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
	    closeConnection();
	    return pokeball;
	}

	public List<Objeto> obtenerListaPokeball() {
		  List<Objeto> pokeballList = new ArrayList<>();
		    try (Connection con = openConnection();
		         PreparedStatement stat = con.prepareStatement("SELECT * FROM objeto WHERE codigo_objeto LIKE '%PO%'");
		         ResultSet rs = stat.executeQuery()) {

		        while (rs.next()) {
		            Objeto obj = new Objeto();
		            obj.setNombre_objeto(rs.getString("nombre_objeto"));
		            obj.setStock_objeto(rs.getInt("stock_objeto"));
		            obj.setPrecio_objeto(rs.getInt("precio_objeto"));
		            obj.setImagen_objeto(rs.getString("imagen_objeto"));
		            pokeballList.add(obj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return pokeballList;
	}

	// Asumiendo que estos son los métodos relevantes en la clase ImplementacionBaseDeDatos




	public void insertarObjeto(String codigo_Objeto, String nombre_objeto, int precio_objeto, int stock_objeto, String imagen_objeto) {
	    try {
	        // Establecer la conexión con la base de datos
	        this.openConnection();
	        // Supongamos que tienes un método para obtener la conexión

	        stat = conect.prepareStatement(INSERT_OBJETO);
	        stat.setString(1, codigo_Objeto);
	        stat.setString(2, nombre_objeto);
	        stat.setInt(3, precio_objeto);
	        stat.setInt(4, stock_objeto);
	        stat.setString(5, imagen_objeto);
	        stat.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(); // Asegúrate de cerrar la conexión aquí
	    }
	}


	public void insertarPokeball(String codigo_Objeto, int ratio) {
	    try {
	        openConnection();
	        PreparedStatement stmt = conect.prepareStatement(INSERT_POKEBALL);
	        stmt.setString(1, codigo_Objeto);
	        stmt.setInt(2, ratio);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(); // Cerrar la conexión aquí
	    }
	}
	
	public void insertarCura(String codigo_Objeto, int cantidadCura) {
		try {
	        openConnection();
	        PreparedStatement stmt = conect.prepareStatement(INSERT_CURA);
	        stmt.setString(1, codigo_Objeto);
	        stmt.setInt(2, cantidadCura);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(); // Cerrar la conexión aquí
	    }
		
	}


	public String obtenerCodigosPokeball() {
	    openConnection(); // Asegúrate de abrir la conexión aquí
	    String cod = null;
	    int num = 0;
	    try {
	        stat = conect.prepareStatement(SELECT_CODIGOS_POKEBALL);
	        ResultSet rs = stat.executeQuery();
	        if (rs.next()) { // Mover el cursor a la primera fila
	            cod = rs.getString(1);
	            num = Integer.parseInt(cod.substring(2));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(); // Asegúrate de cerrar la conexión aquí
	    }
	    if (cod == null) {
	        // Manejar el caso en que no se encontraron resultados
	        return null; // o algún valor predeterminado según lo que necesites
	    }
	    return "PO" + String.format("%03d", num + 1);
	}


	public void actualizarObjeto(String nombre, int precio, int stock, String rutaImagenSeleccionada, String codigo) {
		 try {
		    	openConnection();

	        	stat = conect.prepareStatement(UPDATE_OBJETO);
	            stat.setString(1, nombre);
	            stat.setInt(2, precio);
	            stat.setInt(3, stock);
	            stat.setString(4, rutaImagenSeleccionada);
	            stat.setString(5, codigo); 
	          
	            stat.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        closeConnection();
	    }

	public void actualizarPokeball(int ratio, String codigo) {
		  try {
		        openConnection();
		        PreparedStatement stat = conect.prepareStatement(UPDATE_POKEBALL);          
		        stat.setInt(1, ratio);
		        stat.setString(2, codigo);
		        stat.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        closeConnection(); // Asegúrate de cerrar la conexión aquí
		    }		
	}

	


	
	public void actualizarCantidadObjeto(String codigo_objeto, int cantidadDeseada) {
		 try {
		    	openConnection();

	        	stat = conect.prepareStatement("update objeto set stock_objeto = ? where codigo_objeto = ?");
	            stat.setInt(1, cantidadDeseada);
	            stat.setString(2, codigo_objeto);
	          
	            stat.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        closeConnection();
	}


}
	 		
	

	
	
	
	



