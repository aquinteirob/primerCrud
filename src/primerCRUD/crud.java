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
		int posicionEliminada = -1;
		Scanner lector = new Scanner(System.in);

		menu = basicos.menuGestiones();
		if (menu != 1 && menu != 5) {
			do {
				System.out.println("No es posible modificar, eliminar o buscar porque no hay valores iniciales, tiene que introducir valores primero o salir: ");
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
			menu = basicos.menuGestiones();

			/**
			 * Añade valores si hay campos disponibles, en caso contrario arroja una
			 * notificación de que no es posible Si se ha eliminado anteriormente se
			 * introduce el dato en la posición eliminada y posteriormente se reestablece el
			 * valor de la posición eliminada para cumplir con el requisito a evaluar y no
			 * sobreescribir ese dato constantemente.
			 * 
			 * @author Quinteiro_Adhemar
			 * @version 1.6, 16/02/2023
			 * @exception ArrayIndexOutOfBoundsException controla que no se introduzcan mas
			 *                                           valores de los posibles
			 * @see basicos.caracteres, basicos,eliminador
			 */
			if (menu == 1) {
				contador = contador + 1;
				try {
					if (contador < longitudNombre) {
						nuevoVino = basicos.caracteres("nombre vino nuevo");
						nuevoColor = basicos.caracteres("color del vino: ");
						nuevaRegion = basicos.caracteres("region del vino");
						nuevaUva = basicos.caracteres("uva principal");
						nombre[contador] = nuevoVino;
						color[contador] = nuevoColor;
						region[contador] = nuevaRegion;
						uva[contador] = nuevaUva;
						/* Se evalúa si se hizo una eliminación anterior dejando un espacio libre y, en
						*caso de que si se eliminase anteriormente se da la posibilidad de introducir
						*un valor nuevo*/
					} else if (posicionEliminada != (-1)) {
						nuevoVino = basicos.caracteres("nombre vino nuevo");
						nuevoColor = basicos.caracteres("color del vino: ");
						nuevaRegion = basicos.caracteres("region del vino");
						nuevaUva = basicos.caracteres("uva principal");
						nombre[posicionEliminada] = nuevoVino;
						color[posicionEliminada] = nuevoColor;
						region[posicionEliminada] = nuevaRegion;
						uva[posicionEliminada] = nuevaUva;
						posicionEliminada = -1;
					} else {
						System.out.println("capacidad maxima, elimine algun valor por favor");
					}
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					System.out.println("error");
				}
			} else if (menu == 2) {
				buscarVariable = basicos.menuBusqueda();
				switch (buscarVariable) {
				case 1:
					System.out.println(Arrays.toString(nombre));
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino que quiere modificar y las demas caracteristicas: ");
					resultado = basicos.modificador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;

				/**
				 * Se usa un bucle for por las altas probabilidades de que los colores se
				 * repitan. Se muestra por pantalla un primer resultado al color correspondiente
				 * a la búsqueda pide confirmación para modificar, en caso positivo se piden los
				 * nuevos valores, en caso negativo se muestra el siguiente corresponddiente y
				 * se vuelve a pedir confirmación. No se muestran valores null
				 * 
				 * @author Quinteiro_Adhemar.
				 * @version 1.4, 15/02/2023
				 * @exception: NullPointerExceptio: ocurre cuando el arreglo no está completo,
				 *                                  se controla para poder seguir con la
				 *                                  ejecución del programa
				 * @see: basicos.caracteres
				 */
				case 2:
					System.out.println("Introduzca el color del vino que quiere modificar y las demas caracteristicas: ");
					productoBuscar = basicos.caracteres(Arrays.toString(color));
					try {
						for (int i = 0; i < longitudColor; i++) {
							/*
							 * referencia:
							 * https://stackoverflow.com/questions/16522065/how-to-stop-printing-null-in-an-
							 * array evita imprimir el valor en la posición si este es nulo. cuando los
							 * array se declaran y se inicializan estos se llenan con un dato nulo por
							 * defecto, en el caso de los int con cero y en el de los String con null para
							 * evitar esto hago una comparación donde, primero imprimo los valores
							 * correspondientes a la búsqueda y luego por el funcionamiento del bucle for me
							 * seguiría imprimiendo, aun si son valores nulos, como no quiero mostrar dichos
							 * valores añado una segunda condición que se tiene que cumplir para poder
							 * imprimir y es la de que el valor tiene que ser distinto de nulo para
							 * imprimirlo, Este código donde colo[i]!=null también se usa dentro del menu=3,
							 * case 2 y menu=4 , case 2
							 */
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
					productoBuscar = basicos.caracteres("Introduzca el nombre del vino que quiere eliminar, se eliminan las demas caracteristicas tambien : ");
					posicionEliminada = basicos.eliminador(nombre, color, region, uva, productoBuscar, buscarVariable);
					break;

				/**
				 * Se usa un bucle for por las altas probabilidades de que los colores se
				 * repitan. Se muestra por pantalla un primer resultado al color correspondiente
				 * a la búsqueda pide confirmación para eliminarlo,en caso negativo se muestra
				 * el siguiente corresponddiente y se vuelve a pedir confirmación. No se
				 * muestran valores null
				 * 
				 * @author Quinteiro_Adhemar.
				 * @version 1.4, 15/02/2023
				 * @exception: NullPointerExceptio: ocurre cuando el arreglo no está completo,
				 *                                  se controla para poder seguir con la
				 *                                  ejecución del programa
				 * @see: basicos.caracteres
				 */
				case 2:
					System.out.println("Introduzca el color del vino que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
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
					System.out.println("Introduzca la region que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
					productoBuscar = basicos.caracteres(Arrays.toString(region));
					posicionEliminada = basicos.eliminador(region, color, nombre, uva, productoBuscar, buscarVariable);
					break;
				default:
					System.out.println("Introduzca la uva que quiere eliminar, se eliminan las demas caracteristicas tambien: ");
					productoBuscar = basicos.caracteres(Arrays.toString(uva));
					posicionEliminada = basicos.eliminador(nombre, color, region, uva, productoBuscar, buscarVariable);
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

				/**
				 * Se usa un bucle for por las altas probabilidades de que los colores se
				 * repitan. Muestra por pantalla todos los resultados asociados al color por el
				 * que se busca. No se muestran valores null
				 * 
				 * @author Quinteiro_Adhemar.
				 * @version 1.4, 15/02/2023
				 * @exception: NullPointerExceptio: ocurre cuando el arreglo no está completo,
				 *                                  se controla para poder seguir con la
				 *                                  ejecución del programa
				 * @see: basicos.caracteres
				 */
				case 2:
					try {
						System.out.println("Introduzca el color del vino por el que quiere buscar: ");
						productoBuscar = basicos.caracteres(Arrays.toString(color));
						for (int i = 0; i < longitudColor; i++) {
							if ((color[i].equals(productoBuscar)) && (color[i] != null)) {
								System.out.println("nombre del vino: " + nombre[i] + " color: " + color[i] + " region: "
										+ region[i] + " uva: " + uva[i]);
							}
						}
					} catch (java.lang.NullPointerException e) {
						System.out.println("Error, por favor introduzca mas valores para poder buscar");
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