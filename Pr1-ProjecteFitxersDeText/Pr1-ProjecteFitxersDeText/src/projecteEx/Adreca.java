/**
 * 
 */
package projecteEx;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class Adreca {

	//********atributos*******//
	private String poblacion;
	private String provincia;
	private String cp;
	private String domicilio;
	
	//****constructor*****//
	public Adreca(String poblacion, String provincia, String cp, String domicilio) {
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.cp = cp;
		this.domicilio = domicilio;
	}
	
	//******Getters y setters**//
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Adreca [poblacion:" + poblacion + ", provincia:" + provincia + ", Codigo postal:" + cp + ", domicilio:" + domicilio
				+ "]";
	}
	
	
	
	
}
