/**
 * 
 */
package projecteEx;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public abstract class Persona {

	/******Atributos************/
	private static int numeroPersonas;
	private int idPersona;
	private String dni;
	private String Nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String email;
	private String telefono;
	private Adreca direccion;
	
	/*******Constructores*********/
	public Persona(){	
		numeroPersonas++;
	}
	
	public Persona(int idPersona, String dni, String nombre, String apellido) {
		this.idPersona = idPersona;
		this.dni = dni;
		Nombre = nombre;
		this.apellido = apellido;
		numeroPersonas++;
	}

	public Persona(int idPersona, String dni, String nombre, String apellido, LocalDate fechaDeNacimiento, String email,
			String telefono, Adreca direccion) {
		this.idPersona = idPersona;
		this.dni = dni;
		Nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		numeroPersonas++;
	}

	/********Funciones***********/
	
	public int getEdad() {
		int diff = (int)ChronoUnit.YEARS.between(fechaDeNacimiento, LocalDate.now());
		return diff;
	}
	
	public static long diferenciaEdad(Persona p1, Persona p2) {
		long diff = ChronoUnit.YEARS.between(p1.getFechaDeNacimiento(), p2.getFechaDeNacimiento());
		return diff;
	}
	
	/*Getters y setters*/
	
	public static int getNumeroPersonas() {
		return numeroPersonas;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	protected String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Adreca getDireccion() {
		return direccion;
	}

	public void setDireccion(Adreca direccion) {
		this.direccion = direccion;
	}

	/****toString*****/
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", Nombre=" + Nombre + ", apellido=" + apellido
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", edad="+getEdad()+"]";
	}
	
	
	
	
}
