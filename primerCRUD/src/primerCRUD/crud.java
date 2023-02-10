package primerCRUD;

import java.util.Arrays;
import java.util.Scanner;

public class crud {

	public static void main(String[] args) {
		menuCrud();
	}

	private static void menuCrud() {
		String[] nombre = new String[5];
		String[] color = new String[5];
		String[] region = new String[5];
		String[] uva = new String[5];
		String nuevoVino;
		String nuevoColor;
		String nuevaRegion;
		String nuevaUva;
		String buscarVariable;
		int contador=0;
		int menu;
		int cantidad;
		Scanner lector = new Scanner(System.in);
		
		menu=basicos.menuCrud();
		if(menu!=1) {
			do {
				menu=basicos.numericos("1. introducir vino");
			}while(menu!=1);
		}
			nuevoVino=basicos.caracteres("nombre del vino");
			nuevoColor=basicos.caracteres("color");
			nuevaRegion=basicos.caracteres("region");
			nuevaUva=basicos.caracteres("uva");
			nombre[0]=nuevoVino;
			color[0]=nuevoColor;
			region[0]=nuevaRegion;
			uva[0]=nuevaUva;
			//evalua si me guarda el valor en la posición correcta del string
			System.out.print(Arrays.toString(nombre)); 
			
		while(menu!=5) {
			menu=basicos.menuCrud();
			
			if(menu==1) {
				contador=contador+1;
				nuevoVino=basicos.caracteres("nombre vino nuevo");
				nuevoColor=basicos.caracteres("color");
				nuevaRegion=basicos.caracteres("region");
				nuevaUva=basicos.caracteres("uva principal");
				nombre[contador]=nuevoVino;
				color[contador]=nuevoColor;
				region[contador]=nuevaRegion;
				uva[contador]=nuevaUva;
				System.out.println(Arrays.toString(nombre));
			}else if(menu==2) {
				System.out.println("al fiiiiin");
				System.out.println(Arrays.toString(nombre));
			}else if(menu==3) {
				
			}else if(menu==4) {
				buscarVariable=basicos.buscador();
				do {
					if(nombre.equals(buscarVariable)){
						System.out.println(Arrays.toString(nombre));
					}
				}while(nombre.equals(buscarVariable)||color.equals(buscarVariable));
				System.out.println(Arrays.toString(nombre));
			}else {
				System.out.println("Gracias, que tenga un buen dia.");
			}
		}
	}

}
