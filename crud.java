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
		int menu;
		boolean encontrado = false;
		String productoBuscar;
		String coloresIguales;
		int cantidadImpresa=0;
		String resultado;
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
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino que quiere modificar: ");
					resultado=basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;

				case 2:
					System.out.println("Introduzca el color del vino que quiere modificar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					for (int i = 0; i < color.length; i++) {
						if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
							System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
									+ region[i] + " uva: " + uva[i]);
							cantidadImpresa++;
						}
					}
					if (cantidadImpresa >= 2) {
						coloresIguales = basicos.caracteres("Existen " + cantidadImpresa
								+ " resultados posibles para modificar, ingrese otra caracteristica para hacer la modificación: ");
						buscarVariable = basicos.menuBusqueda();
						while (buscarVariable == 2) {
							System.out.println("Ingrese una caracteristica distinta de color: ");
							buscarVariable = basicos.menuBusqueda();
						}
						if (buscarVariable == 1) {
							System.out.println(Arrays.toString(nombre));
							productoBuscar = basicos.caracteres("Introduzca el nombre del vino que quiere modificar: ");
							resultado=basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
						} else if (buscarVariable == 3) {
							System.out.println("Introduzca la region que quiere modificar: ");
							productoBuscar = basicos.caracteres(Arrays.toString(region));
							resultado=basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
						} else {
							System.out.println("Introduzca la uva que quiere modificar: ");
							productoBuscar = basicos.caracteres(Arrays.toString(uva));
							resultado=basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
						}
					}
					break;

				case 3:
					System.out.println("Introduzca la region que quiere modificar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					resultado=basicos.modificador(region, color, nombre, uva, productoBuscar, buscarVariable);
					break;
				default:
					System.out.println("Introduzca la uva que quiere modificar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					resultado=basicos.modificador(nombre, color, region, uva, productoBuscar,buscarVariable);
					break;
				}

			} else if (menu == 3) {

			} else if (menu == 4) {
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino por el que quiere buscar: ");
					resultado=basicos.buscador(nombre, color, region, uva, productoBuscar,buscarVariable);
					break;
				// uso un for en vez del metodo comparador porque es más probable que se repitan
				// colores y me interesa mostrar todos los resultados con los mismos colores y
				// sin valores nulos.
				case 2:
					System.out.println("Introduzca el color del vino por el que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					for (int i = 0; i < color.length; i++) {
						if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
							System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
									+ region[i] + " uva: " + uva[i]);
						}
					}
					break;
				case 3:
					System.out.println("Introduzca la region por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					resultado=basicos.buscador(region, nombre, color, uva, productoBuscar,buscarVariable);
					break;
				default:
					System.out.println("Introduzca la uva por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					resultado=basicos.buscador(uva,nombre,color,region, productoBuscar,buscarVariable);
					
					break;
				}
			} else {
				System.out.println("Gracias, que tenga un buen dia.");
			}
		}
	}
}