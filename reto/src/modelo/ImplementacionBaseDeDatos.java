package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import controlador.Dao;


public class ImplementacionBaseDeDatos implements Dao{

	private Connection conect;
	private PreparedStatement stat;
	
	final String INSERT_USUARIOS = "INSERT INTO cliente VALUES( ?, ?, ?, ?, ?, ?, ?)";

	private final String CONSULTA_USUARIOS = "SELECT * FROM cliente"; 
	
	
	private void openConnection() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_pokemon?serverTimezone=Europe/Madrid&useSSL=false&allowPublicKeyRetrieval=true", "root", "abcd*1234");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error al cargar el controlador JDBC");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al intentar abrir la conexión a la BD");
	        e.printStackTrace();
	    }
	}

	@Override
	public void altaUsuarios(Usuarios usuario) {
	    openConnection();
	    
	    try {
	        stat = conect.prepareStatement(INSERT_USUARIOS);
	        
	        // SUSTITUIMOS ARGUMENTOS EN SENTENCIAS SQL
	        stat.setString(1, usuario.getDni());
	        stat.setString(2, usuario.getNombre());
	        stat.setString(3, usuario.getApellido());
	        stat.setDate(4, Date.valueOf(usuario.getFechaNac())); // Use Date.valueOf to convert LocalDate to SQL Date
	        stat.setFloat(5, usuario.getSaldo());
	        stat.setString(6, usuario.getContrasena());
	        stat.setBoolean(7, usuario.isEsAdmin()); // Nuevo parámetro para esAdmin

	        stat.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public List<Usuarios> consultaUsuarios() {
		ResultSet rs;
		List <Usuarios> usuarios = new ArrayList<Usuarios>();
		Usuarios usuario;
		
		openConnection();
		
		try {
			stat = conect.prepareStatement(CONSULTA_USUARIOS);		
			rs= stat.executeQuery();
			
			while (rs.next()) {
			    usuario = new Usuarios();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return usuarios
				
				;
	}

	// En la clase ImplementacionBaseDeDatos

	@Override
	public void actualizarUsuario(Usuarios usuario) {
	    openConnection();
	    
	    try {
	        String UPDATE_USUARIO = "UPDATE cliente SET nombre=?, apellido=?, fecha_nac=?, contrasena=? WHERE dni=?";
	        stat = conect.prepareStatement(UPDATE_USUARIO);
	        
	        // Establecer los valores para los parámetros de la sentencia SQL
	        stat.setString(1, usuario.getNombre());
	        stat.setString(2, usuario.getApellido());
	        stat.setDate(3, Date.valueOf(usuario.getFechaNac())); // Suponiendo que la fecha se almacena en formato SQL DATE
	        stat.setString(4, usuario.getContrasena());
	        stat.setString(5, usuario.getDni());
	        
	        // Ejecutar la actualización
	        stat.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}

	

	
	
}
