/**
 * 
 */
package projecteEx;

import java.util.HashMap;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class ClientsDao implements Persistable{

	private HashMap<Integer, Object> clients = new HashMap<>();
	
	@Override
	public void guardar(Object obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Client buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Object> getMap() {
		return clients;
	}

	
}
