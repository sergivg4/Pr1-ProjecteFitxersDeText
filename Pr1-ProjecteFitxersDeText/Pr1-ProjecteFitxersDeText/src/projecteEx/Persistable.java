/**
 * 
 */
package projecteEx;

import java.util.HashMap;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public interface Persistable<T> {

	//guardar
	public void guardar(T obj);
	//eliminar
	public void eliminar(int id);
	//buscar
	public T buscar(int id);
	//getMap
	public HashMap<Integer, T> getMap();
}
