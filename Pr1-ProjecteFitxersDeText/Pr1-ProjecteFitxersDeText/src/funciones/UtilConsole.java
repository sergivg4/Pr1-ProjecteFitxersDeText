package funciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Álvaro Owen de la Quintana
 * ProgramacionBasicaUF2 
 * 25 nov 2022
 */
public class UtilConsole {
	///*****Variables*******///
	
	//Scanner static para poder utilizar solo un scanner en toda la clase
	private static Scanner sc = new Scanner(System.in);
	//Random static para poder utilizar solo un random en toda la clase
	private static Random r;
	
	
	///********Funciones************///
	/**
	 * Inicializa el scanner y el random
	 * @param random si queremos que cree un random
	 */
	public static void init(boolean random) {
		if (sc == null) {
			sc = new Scanner(System.in);			
		}
		if (random == true && r == null) {
			r = new Random();
		}
	}
	
	/**
	 * Inicializa el scanner y el random en el caso de que no hayan sido instanciados
	 */
	public static void initRandom() {
		if (sc == null) {
			sc = new Scanner(System.in);			
		}
		if (r == null) {
			r = new Random();
		}
	}
	
	/**
	 * Cierra el scanner para evitar "memory leaks"
	 */
	public static void Close() {
		sc.close();
	}
	
	/**
	 * Pide un numero por la consola
	 * @return devuelve el valor si es correcto
	 */
	public static int pedirInt() {
		String text ="";
		int num = 0;
		do {
			text = sc.nextLine();
			if (text.matches(RegexBasicos.NUMERO)) {
				num = Integer.parseInt(text);
			}else {
				System.out.println("El valor es incorrecto");
			}
		} while (!text.matches(RegexBasicos.NUMERO));
		
		return num;
	}
	
	public static double pedirDouble() {
		String text ="";
		double num = 0;
		num = sc.nextDouble();
		sc.nextLine();
		return num;
	}
	
	/**
	 * Pide una string por consola
	 * @return devuelve el valor si es correcto
	 */
	public static String pedirString() {
		String text = sc.nextLine();			
		return text;
	}
	
	/**
	 * Pide un dni por consola 
	 * @return devuelve el valor si es correcto
	 */
	public static String pedirDNI() {
		String dni = "";
		boolean dniOK = false;
		do {
			dni = pedirString();
			dniOK = validarDNI(dni);
		} while (!dniOK);
		return dni;
	}

	/**
	 * Valida el DNI introducido
	 * @param dni
	 * @return devuelve true si es correcto y false si es incorrecto
	 */
	private static boolean validarDNI(String dni) {
		String lletres = "TRWAGMYFPDXBNJZSQVHLCKET";

		if (dni.matches(RegexBasicos.DNI)) {
			int numDNI = Integer.parseInt(dni.substring(0, dni.length()-1));
			char lletraDNI = dni.charAt(dni.length()-1);
			int mod = numDNI % 23;
			if (lletres.charAt(mod) == lletraDNI) return true;
		}
		return false;
	}
	
	/**
	 * Pide un email por consola
	 * @return devuelve el valor si es correcto
	 */
	public static String pedirEmail() {
		String email = "";
		do {
			email = pedirString();
			if (!email.matches(RegexBasicos.EMAIL)) {
				System.out.println("El email es incorrecto");
			}
		} while (!email.matches(RegexBasicos.EMAIL));
		return email;
	}
	
	/**
	 * Pide un codigo postal por consola
	 * @return devuelve el valor si es correcto
	 */
	public static String pedirCP() {
		String codigoP = "";
		do {
			codigoP = pedirString();
			if (!codigoP.matches(RegexBasicos.CP)) {
				System.out.println("El codigo Postal introducido es erroneo");
			}
		} while (!codigoP.matches(RegexBasicos.CP));
		return codigoP;
	}
	
	/**
	 * Pide un numero de telefono por consola
	 * @param etiqueta
	 * @return Devuelve el valor si es correcto
	 */
	public static String pedirTelefono(String etiqueta) {
		String telefono = "";
		do {
			telefono = pedirString();
			if (!telefono.matches(RegexBasicos.TELEFONO)) {
				System.out.println("El numero de telefono es erroneo");
			}
		} while (!telefono.matches(RegexBasicos.TELEFONO));

		return telefono;
	}
	
	public static String testRegex() {
		String text = "";
		do {
			text =  pedirString();
			if (!text.matches(RegexBasicos.TEST)) {
				System.out.println("El texto no cumple el regex");
			}
		} while (!text.matches(RegexBasicos.TEST));
		return text;
	}
	
	public static LocalDate demanarData() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");
		System.out.println("Data (dd-MM-yy)");
		String dataS = sc.next();
		LocalDate data = LocalDate.parse(dataS, dtf);
		System.out.println(data.format(dtf));
		
		return data;
	}
	
}
