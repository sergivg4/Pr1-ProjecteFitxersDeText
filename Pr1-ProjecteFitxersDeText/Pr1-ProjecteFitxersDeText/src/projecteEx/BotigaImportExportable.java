/**
 * 
 */
package projecteEx;

import java.util.Map;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public interface BotigaImportExportable<T> {

	//Importar
	public Map<Integer, T> importar(String nomFitxer);
	
	//Exportar
	public boolean exportar(String nomFitxer, Persistable<T> dao);
}
