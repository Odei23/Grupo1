package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Float saldo;
    private String contrasena;
    private boolean esAdmin;

    // Constructor
    public Usuario() {
        this.esAdmin = false;
    }

    // Getters y setters

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

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac
                + ", saldo=" + saldo + ", contrasena=" + contrasena + ", esAdmin=" + esAdmin + "]";
    }
}
