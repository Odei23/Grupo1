package modelo;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.management.loading.PrivateClassLoader;

public class Usuarios implements Serializable{
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private Float Saldo;
	private String contrasena;
	
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate localDate) {
		this.fechaNac = localDate;
	}

	public Float getSaldo() {
		return Saldo;
	}

	public void setSaldo(Float saldo) {
		Saldo = saldo;
	}

	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuarios [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac
				+ ", Saldo=" + Saldo + ", contrasena=" + contrasena + "]";
	}

	
	
	
	
}