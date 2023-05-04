package funcionalidades;

import java.awt.Color;
import battleship.Constants;
import modelo.Barco;
import modelo.Casilla;
import utilidades.StdDraw;

public class Pantalla {
	
	public static void pintarCasillaTocadoAliado(Casilla[][] tablero, int fila, int columna) {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(100 + Constants.MEDIDA_CASILLA * columna, 
	                 650 - Constants.MEDIDA_CASILLA * fila, 
	                 "O");
		//pintarBarcoAliado(tablero, fila, columna);
	}
	
	public static void pintarCasillaAguaAliado(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(100 + Constants.MEDIDA_CASILLA * columna, 
	                 650 - Constants.MEDIDA_CASILLA * fila, 
	                 ".");
		pintarCasillaTableroAliado(fila, columna);
	}
	
	public static void pintarBarcoAliado(Casilla[][] tablero, int fila, int columna) {
		StdDraw.setPenColor(tablero[fila][columna].barco.color);
		StdDraw.filledSquare(100 + Constants.MEDIDA_CASILLA * columna, 
				             650 - Constants.MEDIDA_CASILLA * fila, 
				             Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(100 + Constants.MEDIDA_CASILLA * columna, 
				       650 - Constants.MEDIDA_CASILLA * fila, 
				       Constants.MEDIDA_CASILLA / 2);
	}
	
	public static void pintarCasillaTableroAliado(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(100 + Constants.MEDIDA_CASILLA * columna, 
					   650 - Constants.MEDIDA_CASILLA * fila, 
					   Constants.MEDIDA_CASILLA / 2);
	}
	
	public static void pintarNumerosTableroAliado(int fila, int columna) {
		StdDraw.text(50 + Constants.MEDIDA_CASILLA * columna, 
				     650 - Constants.MEDIDA_CASILLA * fila, 
				     String.valueOf(fila + 1));
	}
	
	public static void pintarLetrasTableroAliado(int fila, int columna, char ascii) {
		StdDraw.text(100 + Constants.MEDIDA_CASILLA * columna, 
				     Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * fila, 
				     "" + ascii);
	}
	
	public static void escribirNombreTableroAliado() {
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_ALIADO, 
				     Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, 
				     "FLOTA ALIADA");
	}
	
	public static void pintarBarcoEnemigo(Casilla[][] tablero, int fila, int columna) {
		Casilla casilla = tablero[fila][columna];
		StdDraw.setPenColor(casilla.barco.color);
		StdDraw.filledSquare(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
		                     650 - Constants.MEDIDA_CASILLA * fila, 
		                     Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
                       650 - Constants.MEDIDA_CASILLA * fila, 
                       Constants.MEDIDA_CASILLA / 2);
	}
	
	public static void pintarCasillaTableroEnemigo(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
			           650 - Constants.MEDIDA_CASILLA * fila, 
			           Constants.MEDIDA_CASILLA / 2);
	}
	
	public static void pintarNumerosTableroEnemigo(int fila, int columna) {
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 120 + Constants.MEDIDA_CASILLA * columna, 
			     650 - Constants.MEDIDA_CASILLA * fila, 
			     String.valueOf(fila + 1));
	}
	
	public static void pintarLetrasTableroEnemigo(int fila, int columna, char ascii) {
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
			         Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * fila, 
			         "" + ascii);
	}
	
	public static void escribirNombreTableroEnemigo() {
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_ENEMIGO, 
				     Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, 
				     "FLOTA ENEMIGA");
	}
	
	public static void pintarCasillaTocadoEnemigo(Casilla[][] tablero, int fila, int columna) {
		Casilla casilla = tablero[fila][columna];
		if (casilla.barco.estadoDeLasPartesDelBarco[casilla.indiceParteBarco] == Barco.EstadoDeLasCasillasDelBarco.TOCADO) {
			StdDraw.setPenColor(Color.RED);
			StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
                         650 - Constants.MEDIDA_CASILLA * fila, 
                         "O");
		}
		pintarCasillaTableroEnemigo(fila, columna);
	}
	
	public static void pintarCasillaAguaEnemigo(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
                     650 - Constants.MEDIDA_CASILLA * fila, 
                     ".");
		pintarCasillaTableroEnemigo(fila, columna);
	}
}
