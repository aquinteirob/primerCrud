package primerCRUD;

import java.util.Scanner;

public class basicos {
	
	/**
	 * La clase basicos proporciona métodos generales para la elaboración del CRUD
	 * 	Interacción y mensajes por consola de tipo entero y de tipo caracteres. 
	 * 	Menu para escoger las gestiones que se quieren realizar sobre los arrays
	 * 	Menu para indicar por cual parámetro se quiere realizar la gestión seleccionada
	 * 	Un método para buscar el valor que se introduzca. 
	 * 	Un método modificador para cambiar el valor introducido por uno nuevo. 
	 * 	Un método eliminador 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/23
	 */
	
	
	public static int numericos(String texto) {
		int numero;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		numero = lector.nextInt();
		lector.nextLine();
		return numero;

	}
	/**
	 * El método caracteres proporciona interacciones por consola
	 * Captura el valor ingresado por el usuario después de un texto que recibe como parámetro
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @param texto: mensaje que se muestra por consola
	 * @exception NullPointerException: cuando se introduce un caracter null 
	 * @return caracter: el o los caracteres capturados por el lector y son regresados para su futura utilización
	 */
	public static String caracteres(String texto) {
		String caracter = " ";
		Scanner lector = new Scanner(System.in);
		try {
			System.out.println(texto);
			caracter = lector.nextLine();
			return caracter;
		} catch (java.lang.NumberFormatException e) {
			System.out.println("error");
		}
		return caracter;
	}

	/**
	 * El método menuCrud proporciona interacciones por consola
	 * Muestra las gestiones que se pueden realizar y captura el valor numérico de la gestión 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @exception InputMismatchException: cuando se introduce un caracter no numérico 
	 */
	public static int menuGestiones() {

		int numero = 0;
		Scanner lector = new Scanner(System.in);
		try {
			do {
				System.out.println("Introduzca el numero segun la gestion que quiere realizar:" + "\n"
						+ "1. Introducir vino" + "\n" + "2. Modificar algun vino" + "\n" + "3. Eliminar algun vino"
						+ "\n" + "4. Buscar vino" + "\n" + "5. Salir");
				numero = lector.nextInt();
				lector.nextLine();
				return numero;
			} while (numero < 1 && numero > 5);
		} catch (java.util.InputMismatchException e) {
			System.out.println("Caracter no valido");
		}
		return numero;
	}

	/**
	 * El método menuBusqueda proporciona interacciones por las que se puede filtrar una vez selecionada la gestión
	 * Muestra los filtros de búsqueda, captura el valor numérico de la gestión 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @exception InputMismatchException: cuando se introduce un caracter no numérico 
	 */
	public static int menuBusqueda() {
		int numeroArreglo = 0;
		try {
			do {
				numeroArreglo = numericos(
						"Por favor introduzca el numero de la caracteristica por la que quiere buscar: " + "\n"
								+ "1. nombre" + "\n" + "2. color" + "\n" + "3. region" + "\n" + "4. uva");
			} while (numeroArreglo < 1 || numeroArreglo > 5);
			return numeroArreglo;
		} catch (java.util.InputMismatchException e) {
			System.out.println("Caracter no valido");
		}
		return numeroArreglo;
	}


	/**
	 * El método buscador compara un input solicitado por consola por el método caracteres con los valores ya existentes 
	 * en el arreglo, una vez conseguido ese valor lo muestra por pantalla junto con las demás características asociadas
	 * al valor por el que se buscó. 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @param arregloComparo: es el primer arreglo, por el cual se ha escogido realizar la búsqueda, ya sea por nombre, color, región o uva.
	 * @param arreglo1: es el primer arreglo que se introduce después del arreglo por el que se buscará.
	 * @param arreglo2: es el segundo arreglo que se introduce.
	 * @param arreglo3: es arreglo que se introduce como último. 
	 * @param producto: es el valor que el usuario a seleccionado para buscar.
	 * @param casoModificador:Es el filtro que se ha seleccionado para buscar, puede ser nombre, región o uva, dependiendo del escogido se 
	 * 							muestra por pantalla un orden diferente.
	 * @exception NullPointerException: cuando se necesitan introducir mayor cantidad de datos.
	 * @return resultado: es el input del usuario, se usará para llevar un control en la bbdd para saber los más buscados y las cantidades de veces.
	 */
	public static String buscador(String[] arregloComparo, String[] arreglo1, String[] arreglo2, String[] arreglo3,
			String producto, int casoModificador) {
		String resultado = " ";
		int contador = 0;
		int longitud = arregloComparo.length;
		boolean encontrado = false;
		try {
		if (casoModificador == 1) {
			do {
				if (arregloComparo[contador].equals(producto)) {
					encontrado = true;
					System.out.println("nombre del vino: " + arregloComparo[contador] + " color: " + arreglo1[contador]
							+ " region: " + arreglo2[contador] + " uva: " + arreglo3[contador]);
					resultado = producto;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		} else if (casoModificador == 3) {
			do {
				if (arregloComparo[contador].equals(producto)) {
					encontrado = true;
					System.out.println("nombre del vino: " + arreglo1[contador] + " color: " + arreglo2[contador]
							+ " region: " + arregloComparo[contador] + " uva: " + arreglo3[contador]);
					resultado = producto;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		} else if (casoModificador == 4) {
			do {
				if (arregloComparo[contador].equals(producto)) {
					encontrado = true;
					System.out.println("nombre del vino: " + arreglo1[contador] + " color: " + arreglo2[contador]
							+ " region: " + arreglo3[contador] + " uva: " + arregloComparo[contador]);
					resultado = producto;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		}
		}catch(java.lang.NullPointerException e) {
			System.out.println("Introduzca mas valores primero por favor");
		}
		return resultado;
	}

	/**
	 * El método modificador compara un input solicitado por consola por el método caracteres con los valores ya existentes 
	 * en el arreglo, una vez conseguido ese valor lo muestra por pantalla junto con las demás características asociadas
	 * al valor por el que se buscó y solicita los nuevos valores para modificar los anteriores 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @param arregloModificador: es el primer arreglo, por el cual se ha escogido realizar la búsqueda para su posterior modificación, la busqueda puede ser por nombre, color, región o uva.
	 * @param arreglo1: es el primer arreglo que se introduce después del arreglo por el que se buscará.
	 * @param arreglo2: es el segundo arreglo que se introduce.
	 * @param arreglo3: es arreglo que se introduce como último. 
	 * @param modificar: es el valor que el usuario a seleccionado para modificar junto con las características asociadas.
	 * @param casoModificador:Es el filtro que se ha seleccionado para buscar, puede ser nombre, región o uva, dependiendo del escogido se 
	 * 							muestra por pantalla un orden diferente.
	 * @return resultado: es el input del usuario, se usará para llevar un control en la bbdd para saber cuales fueron los datos originales. 
	 */
	public static String modificador(String[] arregloModificar, String[] arreglo1, String[] arreglo2, String[] arreglo3,
			String modificar, int casoModificador) {
		String nuevoVino;
		String nuevoColor;
		String nuevaRegion;
		String nuevaUva;
		String buscarValor;
		int contador = 0;
		int longitud = arregloModificar.length;
		boolean encontrado = false;
		String resultado = " ";

		buscarValor = buscador(arregloModificar, arreglo1, arreglo2, arreglo3, modificar, casoModificador);
		System.out.println("Este es el vino que va a modificar");
		nuevoVino = caracteres("nombre del nuevo Vino: ");
		nuevoColor = caracteres("nuevo color: ");
		nuevaRegion = caracteres("nueva region: ");
		nuevaUva = caracteres("nueva uva: ");
		if (casoModificador == 1) {
			do {
				if (arregloModificar[contador].equals(modificar)) {
					arregloModificar[contador] = nuevoVino;
					arreglo1[contador] = nuevoColor;
					arreglo2[contador] = nuevaRegion;
					arreglo3[contador] = nuevaUva;
					System.out.println("nombre del vino nuevo: " + arregloModificar[contador] + " color nuevo: "
							+ arreglo1[contador] + " region nueva: " + arreglo2[contador] + " uva nueva: "
							+ arreglo3[contador]);
					encontrado = true;
					resultado = modificar;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		} else if (casoModificador == 3) {
			do {
				if (arregloModificar[contador].equals(modificar)) {
					arregloModificar[contador] = nuevaRegion;
					arreglo1[contador] = nuevoColor;
					arreglo2[contador] = nuevoVino;
					arreglo3[contador] = nuevaUva;
					System.out.println(
							"nueva region: " + arregloModificar[contador] + " color nuevo: " + arreglo1[contador]
									+ " nuevo vino: " + arreglo2[contador] + " uva nueva: " + arreglo3[contador]);
					encontrado = true;
					resultado = modificar;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		} else if (casoModificador == 4) {
			do {
				if (arregloModificar[contador].equals(modificar)) {
					arregloModificar[contador] = nuevaUva;
					arreglo1[contador] = nuevoColor;
					arreglo2[contador] = nuevaRegion;
					arreglo3[contador] = nuevoVino;
					System.out
							.println("nueva Uva: " + arregloModificar[contador] + " color nuevo: " + arreglo1[contador]
									+ " region nueva: " + arreglo2[contador] + " nuevo Vino: " + arreglo3[contador]);
					encontrado = true;
					resultado = modificar;
				}
				contador++;
			} while (contador < longitud && !encontrado);
		}
		return resultado;
	}

	/**
	 * El método eliminador buscar un input solicitado por consola con los valores ya existentes en el arreglo, una vez conseguido ese valor lo muestra por pantalla junto con las demás características asociadas
	 * al valor por el que se buscó, solicita confirmar si ese valor es el que se quiere eliminar y, en caso afirmativo asigna un espacio
	 * en blanco a todas las características asociadas. 
	 * @author Quinteiro_Adhemar
	 * @version 1, 15/02/2023
	 * @param arregloComparo: arreglo escogido para buscar, puede ser por nombre, color, región o uva, posteriormente se eliminarán los valores
	 * @param arreglo1: es el primer arreglo que se introduce después del arreglo por el que se busca.
	 * @param arreglo2: es el segundo arreglo que se introduce.
	 * @param arreglo3: es arreglo que se introduce como último. 
	 * @param producto: es el valor que el usuario a seleccionado para buscar.
	 * @param casoModificador:Es el filtro que se ha seleccionado para buscar, puede ser nombre, región o uva, para estos 3 casos después de eliminar se notifica por pantalla
	 * @return resultado: es el input del usuario, se usará para llevar un control en la bbdd para saber los valores eliminados.
	 */
	public static String eliminador(String[] arregloEliminar, String[] arreglo1, String[] arreglo2, String[] arreglo3,
			String eliminar, int casoModificador) {
		String buscarValor;
		String confirmacion;
		String resultado = " ";
		int contador = 0;
		int longitud = arregloEliminar.length;
		boolean encontrado = false;
		buscarValor = buscador(arregloEliminar, arreglo1, arreglo2, arreglo3, eliminar, casoModificador);
		confirmacion = caracteres("Este es el vino y sus caracteristicas que eliminara, ¿Esta seguro? (s/n): ");
		if (confirmacion.equals("s")) {
			if ((casoModificador == 1) || (casoModificador == 3) || (casoModificador == 4)) {
				do {
					if (arregloEliminar[contador].equals(eliminar)) {
						arregloEliminar[contador] = " ";
						arreglo1[contador] = " ";
						arreglo2[contador] = " ";
						arreglo3[contador] = " ";
						System.out.println("se ha eliminado de manera correcta");
						encontrado = true;
						resultado = eliminar;
					}
					contador++;
				} while (contador < longitud && !encontrado);
			}
		}
		return resultado;
	}
}
