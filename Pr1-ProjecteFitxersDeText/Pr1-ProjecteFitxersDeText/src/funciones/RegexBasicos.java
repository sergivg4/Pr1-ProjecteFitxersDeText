/**
 * 
 */
package funciones;

/**@author Álvaro Owen de la Quintana
 * ProgramacionBasicaUF2 
 * 25 nov 2022
 */
public class RegexBasicos {

	/**
	 * [a-z] => Hay letras de la "a" a la "z"
	 * [A-Z] => Hay letras de la "A" a la "Z"
	 * [^a-z] => Hay letras fuera del rango de la "a" a la "z"
	 * [0-9] => Hay numeros entre 0 y 9
	 * [A-Z a-z] => Hay letras entre "A" a la "Z" tanto en mayusculas como en minusculas
	 * \\d => Es un digito
	 * \\s => Es un espacio en blanco
	 * . => Un caracter cualquiera
	 * ^ => Empieza la linea con el parametro siguiente
	 * $ => Acaba la linea con el parametro anterior 
	 * n+ => Tiene un elemento n una o más veces
	 * n* => Tiene un elemento n cero o más veces
	 * n? => Tiene un elemento n cero o una vez	
	 * n{x} => Tiene una string que contiene una sequencia de "n" X veces
	 * n{x,y} => Tiene una string que contiene una sequencia de "n" de X a Y veces
	 * n{x,} => Tiene una string que contiene una sequencia de "n" por lo menos X veces
	 */
	
	//[0-9]{7,8} = 7 u 8 numeros del 0 al 9
	//[A-Z a-z] =una letra mayuscula o minuscula
	public static final String DNI = "[0-9]{7,8}[A-Z a-z]";
	
	//(^.+) -> Empieza por uno o más caracteres cualquiera
	//@ -> tiene una arroba
	//(.+) -> tiene uno mas caracteres cualquiera
	// . -> tiene un punto
	// (.+)$ -> acaba en uno o más caracteres cualquiera
	public static final String EMAIL = "(^.+)@(.+).(.+)$";
	
	//[6-7] -> el primer digito es 6 o 7
	//[0-9]{8} -> hay 8 digitos del 0 al 9 
	public static final String TELEFONO = "[6-7][0-9]{8}";
	
	//[0-9]{5} -> hay 5 digitos del 0 al 9 
	public static final String CP = "[0-9]{5}";
	
	//[0-9]+ -> hay 1 o más digitos de entre 0 y 9 
	public static final String NUMERO = "[0-9]+";
	
	//solo sirve para testear
	public static final String TEST = "";
}
