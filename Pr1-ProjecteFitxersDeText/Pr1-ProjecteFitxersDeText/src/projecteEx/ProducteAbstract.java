package projecteEx;

import java.io.Serializable;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public abstract class ProducteAbstract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	private String nom;
	
	public ProducteAbstract(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "ProducteAbstract [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
