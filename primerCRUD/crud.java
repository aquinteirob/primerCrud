package primerCRUD;

import java.util.Arrays;
import java.util.Scanner;

public class crud {

	public static void main(String[] args) {
		menuCrud();
	}

	private static void menuCrud() {
		String[] nombre = new String[3];
		String[] color = new String[3];
		String[] region = new String[3];
		String[] uva = new String[3];
		String nuevoVino;
		String nuevoColor;
		String nuevaRegion;
		String nuevaUva;
		int buscarVariable;
		int contador = 0;
		int contador2 = 0;
		int menu;
		boolean encontrado = false;
		String productoBuscar;
		Scanner lector = new Scanner(System.in);

		menu = basicos.menuCrud();
		if (menu != 1) {
			do {
				menu = basicos.numericos("1. introducir vino");
			} while (menu != 1);
		}
		nuevoVino = basicos.caracteres("nombre del vino");
		nuevoColor = basicos.caracteres("color");
		nuevaRegion = basicos.caracteres("region");
		nuevaUva = basicos.caracteres("uva");
		nombre[0] = nuevoVino;
		color[0] = nuevoColor;
		region[0] = nuevaRegion;
		uva[0] = nuevaUva;
		// evalua si me guarda el valor en la posición correcta del string
		System.out.print(Arrays.toString(nombre));

		while (menu != 5) {
			menu = basicos.menuCrud();

			if (menu == 1) {
				contador = contador + 1;
				nuevoVino = basicos.caracteres("nombre vino nuevo");
				nuevoColor = basicos.caracteres("color");
				nuevaRegion = basicos.caracteres("region");
				nuevaUva = basicos.caracteres("uva principal");
				nombre[contador] = nuevoVino;
				color[contador] = nuevoColor;
				region[contador] = nuevaRegion;
				uva[contador] = nuevaUva;
				System.out.println(Arrays.toString(nombre));
			} else if (menu == 2) {
				System.out.println("al fiiiiin");
				System.out.println(Arrays.toString(nombre));
			} else if (menu == 3) {

			} else if (menu == 4) {
				buscarVariable = basicos.buscador();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino por el que quiere buscar: ");
					do {
						if (nombre[contador2].equals(productoBuscar)) {
							System.out.println("nombre: " + nombre[contador2] + " color: " + color[contador2]
									+ " region: " + region[contador2] + " uva: " + uva[contador2]);
							encontrado = true;
						}
						contador2++;
					} while (contador2 < nombre.length && !encontrado);
					break;
				// uso un for en vez del otro formato porque es más probable que se repitan
				// colores y me interesa mostrar todos los resultados con los mismos colores y sin valores nulos.
				case 2:
					System.out.println("Introduzca el color del vino por el que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					for (int i = 0; i < color.length; i++) {
						if ((color[contador].equals(productoBuscar)) && (color[contador] != null)) {
							System.out.println("nombre: " + nombre[i] + " color: " + color[i] + " region: " + region[i]
									+ " uva: " + uva[i]);
						}
					}
					break;
				case 3:
					System.out.println("Introduzca la region por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					do {
						if (region[contador2].equals(productoBuscar)) {
							encontrado = true;
							System.out.println("nombre: " + nombre[contador2] + " color: " + color[contador2]
									+ " region: " + region[contador2] + " uva: " + uva[contador2]);
						}
						contador2++;
					} while (contador2 < region.length && !encontrado);
					break;
				default:
					System.out.println("Introduzca la uva por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					do {
						if (uva[contador2].equals(productoBuscar)) {
							encontrado = true;
							System.out.println("nombre: " + nombre[contador2] + " color: " + color[contador2]
									+ " region: " + region[contador2] + " uva: " + uva[contador2]);
						}
						contador2++;
					} while (contador2 < region.length && !encontrado);
					break;
				}
			} else {
				System.out.println("Gracias, que tenga un buen dia.");
			}
		}
	}
	
	public static void buscador() {
		
	}
}