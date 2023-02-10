package primerCRUD;

import java.util.Scanner;

public class basicos {
	public static int numericos(String texto) {
		int numero;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		numero = lector.nextInt();
		lector.nextLine();
		return numero;
	}

	public static String caracteres(String texto) {
		String caracter;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		caracter = lector.nextLine();
		return caracter;
	}
	
	public static int menuCrud () {
		int numero;
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduzca el numero segun la gestion que quiere realizar:"+"\n"
				+"1. Introducir vino" + "\n" + "2. Modificar algun vino" + "\n" + "3. Eliminar algun vino"+"\n"
				+ "4. Buscar vino" + "\n" + "5. Salir");
		numero = lector.nextInt();
		lector.nextLine();
		return numero;
	}
	
	public static String buscador() {
		String nombreArreglo;
		nombreArreglo=caracteres("Introduzca el nombre de la variable por la que quiere buscar: "
				+"\n"+"nombre"+"\n"+"color"+"\n"+"region"+"\n"+"uva");
		return nombreArreglo;
	}
}
