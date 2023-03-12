
package projecteEx;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**@author Sergi Valenzuela García
 * M03-UF4 
 * 10 mar 2023
 */
public class BotigaImportExportText implements BotigaImportExportable<ProducteAbstract>{

	private static Map<Integer, ProducteAbstract> productesMap = new HashMap<Integer, ProducteAbstract>();
	
	@Override
	public Map<Integer, ProducteAbstract> importar(String nomFitxer) {
		
		//variables
		//String nomFitxer = "res/texto.txt";
		ProducteAbstract prod = null;
		String linea = "";
		String[] datos = {};
		
		//creamos un formatador de numeros
		NumberFormat nformat = NumberFormat.getInstance(Locale.ITALIAN);
		
		//pack de objetos para escribir 
		try (BufferedReader bfr = new BufferedReader(new FileReader(nomFitxer))){
			while ((linea = bfr.readLine()) != null) {
				datos = linea.split("\\|");//hace un split de la linea cada vez que encuentra un '|'
				int id = Integer.parseInt(datos[0]);//lee el dato en la posicion 0
				String nom = datos[1];//lee el dato en la posicion 1
				//lee el dato en la posicion 2 y con el formatador lo convierte en decimal adecuandose al formato regional del programa
				//double price = nformat.parse(datos[2]).doubleValue();
				double preu = Double.valueOf(datos[2].replace(",", "."));
				int stock = Integer.parseInt(datos[3]);//lee el dato en la posicion 3
				prod = new Producte(id, nom, stock, preu);
				//System.out.println(prod);
				productesMap.put(id, prod);
			}
			
//			System.out.println("Importando productos:");
//			for (Map.Entry<Integer, ProducteAbstract> entry : productesMap.entrySet()) {
//			    System.out.println(entry.getValue());
//			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return productesMap;
	}

	@Override
	public boolean exportar(String nomFitxer, Persistable<ProducteAbstract> dao) {
		
		//Convierte los double con . a decimal con , 
		DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.GERMANY);
		decimalFormatSymbols.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("#.##", decimalFormatSymbols);

		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomFitxer), "utf-8")){
			
			for (Map.Entry<Integer, ProducteAbstract> entry : dao.getMap().entrySet()) {
				ProducteAbstract tempProd = entry.getValue();
				
				if (tempProd instanceof Producte) {
					Producte tempProd2 = (Producte)dao.buscar(tempProd.getId());
					osw.write(String.valueOf(tempProd2.getId() + "|"));
					osw.write(tempProd2.getNom() + "|");
					osw.write(df.format(tempProd2.getPrecio()) + "|");
					osw.write(tempProd2.getStock() + "\n");
				}else if(tempProd instanceof Pack) {
					//Todavía no se puede exportar packs
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}
