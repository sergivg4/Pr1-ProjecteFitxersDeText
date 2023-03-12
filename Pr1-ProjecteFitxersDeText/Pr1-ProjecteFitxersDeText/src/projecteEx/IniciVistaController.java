/**
 * 
 */
package projecteEx;

import funciones.UtilConsole;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class IniciVistaController {

	public static void main(String[] args) {
		int opcion = 0;
		ProductesDao pd = new ProductesDao();
		ClientsDao cd = new ClientsDao();
		BotigaImportExportText BotigaImEx = new BotigaImportExportText();
		do {
			//menu
			System.out.println("0. Salir");
			System.out.println("1. Productes");
			System.out.println("2. Clients");
			System.out.println("3. Proveïdors");
			opcion = UtilConsole.pedirInt();
			//segun lo que se escoge, se llama al submenu del controlador que toca
			if (opcion == 1) {
				ProductesVistaController.inicio(pd, BotigaImEx);
			}else  if (opcion ==2){
				ClientsVistaController.inicio(cd);
			}else  if (opcion == 3){
				//TODO 
			}

		} while (opcion != 0);	
	}
	
	/**
	 * 
	 */
	public static void imprimir(Persistable<?> p) {
		for (Object obj : p.getMap().values()) {
			System.out.println(obj);
		}
	}
	
}
