package projecteEx;

import java.util.ArrayList;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class Pack extends ProducteAbstract{

	private ArrayList<Producte> productes;
	private double porDescuento;
	
	/**
	 * 
	 * @param id
	 * @param nom
	 * @param productes
	 * @param porDescuento
	 */
	public Pack(int id, String nom, ArrayList<Producte> productes, double porDescuento) {
		super(id, nom);
		this.productes = productes;
		this.porDescuento = porDescuento;
	}

	public ArrayList<Producte> getProductes() {
		return productes;
	}

	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
	}

	public double getPorDescuento() {
		return porDescuento;
	}

	public void setPorDescuento(double porDescuento) {
		this.porDescuento = porDescuento;
	}
	
	@Override
	public String toString() {
		
		StringBuilder ProductosDelPack = new StringBuilder();
		
		for (int i = 0; i < productes.size(); i++) {
			ProductosDelPack.append("\n       --> " + productes.get(i));
		}
		
		return "Pack [ Id = " + getId() + ", Nom = " + getNom() + ", Descuento = " + getPorDescuento() + "% ]" + ProductosDelPack;
		
	}
	
	
	
	
}
