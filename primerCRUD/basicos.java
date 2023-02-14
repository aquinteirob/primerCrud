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
		String caracter = " ";
		Scanner lector = new Scanner(System.in);
		try {
			System.out.println(texto);
			caracter = lector.nextLine();
			return caracter;
		} catch (java.lang.NullPointerException e) {
			System.out.println("error");
		}
		return caracter;
	}

	public static int menuCrud() {

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
