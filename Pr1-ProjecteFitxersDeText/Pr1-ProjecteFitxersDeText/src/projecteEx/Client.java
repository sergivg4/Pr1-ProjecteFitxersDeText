/**
 * 
 */
package projecteEx;

import java.time.LocalDate;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class Client extends Persona{

	private boolean enviarPublicitat;

	public Client() {
		super();
		enviarPublicitat = false;
	}

	public Client(int idPersona, String dni, String nombre, String apellido, LocalDate fechaDeNacimiento, String email,
			String telefono, Adreca direccion, boolean enviarPublicitat) {
		super(idPersona, dni, nombre, apellido, fechaDeNacimiento, email, telefono, direccion);
		this.enviarPublicitat = enviarPublicitat;
	}

	public boolean isEnviarPublicitat() {
		return enviarPublicitat;
	}

	public void setEnviarPublicitat(boolean enviarPublicitat) {
		this.enviarPublicitat = enviarPublicitat;
	}

	@Override
	public String toString() {
		return "Client [enviarPublicitat=" + enviarPublicitat + ", Edad=" + getEdad() + ", IdPersona="
				+ getIdPersona() + ", Dni=" + getDni() + ", Nombre=" + getNombre() + ", Apellido="
				+ getApellido() + ", FechaDeNacimiento=" + getFechaDeNacimiento() + ", Email=" + getEmail()
				+ ", Telefono=" + getTelefono() + ", Direccion=" + getDireccion() + "]";
	}
	
	
	
}
