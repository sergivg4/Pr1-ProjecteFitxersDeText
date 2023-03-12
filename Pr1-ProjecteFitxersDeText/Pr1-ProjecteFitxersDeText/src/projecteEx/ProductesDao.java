/**
 * 
 */
package projecteEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import funciones.UtilConsole;


/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class ProductesDao implements Persistable<ProducteAbstract>{

	private static HashMap<Integer, ProducteAbstract> productes = new HashMap<>();
	
	public void guardarFitxer() {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/productes.txt"))){
			oos.writeObject(productes);
			
		}catch (Exception e) {
			System.out.println("ha petado, pero no!" + e.getMessage());
		}
	}
	
	public void obrirFitxer() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/productes.txt"))){
			
			HashMap<Integer, ProducteAbstract> productes2 = (HashMap<Integer, ProducteAbstract>)ois.readObject();
	        
			productes = productes2;

		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("ha petado, pero sigue vivo, aunque el archivo no existe!");
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println("ha petado, pero no se porque, cosas...!"+e.getMessage());
		}
	}
	
	public void importarFitxer(BotigaImportExportText BotigaImEx) {
		
		Map<Integer, ProducteAbstract> productsToImport = BotigaImEx.importar("res/datos.txt");
		
		System.out.println("Productos que se van a importar:");
		for (Map.Entry<Integer, ProducteAbstract> entry : productsToImport.entrySet()) {
		    System.out.println(entry.getValue());
		}
		
		System.out.println("¿Estas seguro que quieres importar estos productos?");
		int opcion;
		do {
			// confirmar import
			System.out.println("1. Si");
			System.out.println("2. No");
			opcion = UtilConsole.pedirInt();
			if (opcion == 1) {
				System.out.println("Se han importado SOLO los productos con IDs NO existentes.");
				productsToImport.forEach((Integer, ProducteAbstract) -> productes.putIfAbsent(Integer, ProducteAbstract));
		        for (Map.Entry<Integer, ProducteAbstract> entry : productes.entrySet()) {
				    System.out.println(entry.getValue());
				}
		        opcion = 2;
			} else if (opcion == 2) {
				System.out.println("Los productos NO han sido importados.");
			}
		} while (opcion != 2);
	}

	@Override
	public void guardar(ProducteAbstract prod) {
		productes.put(prod.getId(), prod);
	}

	@Override
	public void eliminar(int id) {
			productes.remove(id);
	}

	@Override
	public ProducteAbstract buscar(int id) {
		return productes.get(id);
	}

	@Override
	public HashMap<Integer, ProducteAbstract> getMap() {
		return productes;
	}
	
}
