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
		String productoBuscar;
		int longitudNombre = nombre.length;
		int longitudColor = color.length;
		String confirmar = "";
		String resultado;
		Scanner lector = new Scanner(System.in);

		menu = basicos.menuCrud();
		if (menu != 1 && menu != 5) {
			do {
				System.out.println(
						"No es posible modificar, eliminar o buscar porque no hay valores iniciales, tiene que introducir valores primero o salir: ");
				menu = basicos.numericos("1. introducir vino" + "\n" + "5. Salir");
			} while (menu != 1 && menu != 5);
		}
		if (menu == 1) {
			System.out.println("Introducir valores: ");
			nuevoVino = basicos.caracteres("nombre del vino");
			nuevoColor = basicos.caracteres("color");
			nuevaRegion = basicos.caracteres("region");
			nuevaUva = basicos.caracteres("uva");
			nombre[0] = nuevoVino;
			color[0] = nuevoColor;
			region[0] = nuevaRegion;
			uva[0] = nuevaUva;
		} else {
			System.out.println("Gracias, que tenga un buen dia.");
		}

		while (menu != 5) {
			menu = basicos.menuCrud();

			if (menu == 1) {
				contador = contador + 1;
				if (contador >= longitudNombre) {
					System.out.println("Capacidad total ocupada, elimine algun valor para poder añadir uno nuevo");
				} else {
					nuevoVino = basicos.caracteres("nombre vino nuevo");
					nuevoColor = basicos.caracteres("color del vino: ");
					nuevaRegion = basicos.caracteres("region del vino");
					nuevaUva = basicos.caracteres("uva principal");
					nombre[contador] = nuevoVino;
					color[contador] = nuevoColor;
					region[contador] = nuevaRegion;
					uva[contador] = nuevaUva;
				}
			} else if (menu == 2) {
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres(
							"Introduzca el nombre del vino que quiere modificar y las demas caracteristicas: ");
					resultado = basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;

				case 2:
					System.out
							.println("Introduzca el color del vino que quiere modificar y las demas caracteristicas: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					try {
						for (int i = 0; i < longitudColor; i++) {
							if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
								System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
										+ region[i] + " uva: " + uva[i]);
								confirmar = basicos.caracteres("¿Es este el vino que quiere modificar? (s/n):");
								if (confirmar.equals("s")) {
									nuevoVino = basicos.caracteres("nombre vino nuevo");
									nuevoColor = basicos.caracteres("color nuevo");
									nuevaRegion = basicos.caracteres("region nueva");
									nuevaUva = basicos.caracteres("uva principal nueva");
									nombre[i] = nuevoVino;
									color[i] = nuevoColor;
									region[i] = nuevaRegion;
									uva[i] = nuevaUva;
								}
							}
						}
					} catch (java.lang.NullPointerException e) {
						System.out.println("Introduzca mas valores primero por favor");
					}
					break;

				case 3:
					System.out.println("Introduzca la region que quiere modificar y las demas caracteristicas: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					resultado = basicos.modificador(region, color, nombre, uva, productoBuscar, buscarVariable);
					break;
				default:
					System.out.println("Introduzca la uva que quiere modificar y las demas caracteristicas: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					resultado = basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;
				}

			} else if (menu == 3) {
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres(
							"Introduzca el nombre del vino que quiere eliminar, se eliminan las demas caracteristicas tambien : ");
					resultado = basicos.eliminador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;

				case 2:
					System.out.println(
							"Introduzca el color del vino que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					try {
						for (int i = 0; i < longitudColor; i++) {
							if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
								System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
										+ region[i] + " uva: " + uva[i]);
								confirmar = basicos.caracteres("¿Es este el vino que quiere eliminar? (s/n):");
								if (confirmar.equals("s")) {
									nombre[i] = " ";
									color[i] = " ";
									region[i] = " ";
									uva[i] = " ";
									System.out.println("Eliminado correctamente.");
								}
							}
						}
					} catch (java.lang.NullPointerException e) {
						System.out.println("Introduzca mas valores primero por favor");
					}
					break;

				case 3:
					System.out.println(
							"Introduzca la region que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					resultado = basicos.eliminador(region, color, nombre, uva, productoBuscar, buscarVariable);
					break;
				default:
					System.out.println(
							"Introduzca la uva que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					resultado = basicos.eliminador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;
				}

			} else if (menu == 4) {
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino por el que quiere buscar: ");
					resultado = basicos.buscador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;
				// uso un for en vez del metodo comparador porque es más probable que se repitan
				// colores y me interesa mostrar todos los resultados con los mismos colores y
				// sin valores nulos.
				case 2:
					System.out.println("Introduzca el color del vino por el que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					for (int i = 0; i < longitudColor; i++) {
						if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
							System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
									+ region[i] + " uva: " + uva[i]);
						}
					}
					break;
				case 3:
					System.out.println("Introduzca la region por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					resultado = basicos.buscador(region, nombre, color, uva, productoBuscar, buscarVariable);
					break;
				default:
					System.out.println("Introduzca la uva por la que quiere buscar: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					resultado = basicos.buscador(uva, nombre, color, region, productoBuscar, buscarVariable);
					break;
				}
			} else if (menu == 5) {
				System.out.println("Gracias, que tenga un buen dia.");
			}
		}
	}
}