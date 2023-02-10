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
	
	public static int buscador() {
		int numeroArreglo;
		do {
			numeroArreglo=numericos("Por favor introduzca el numero de la caracteristica por la que quiere buscar: "
				+"\n"+"1. nombre"+"\n"+"2. color"+"\n"+"3. region"+"\n"+"4. uva");
		}while(numeroArreglo<1||numeroArreglo>5);
		return numeroArreglo;
	}
	
public static void buscadorPosicion() {
	String vino;
	String color;
	String region;
	String uva;
	int buscarVariable;
	
	}
}
