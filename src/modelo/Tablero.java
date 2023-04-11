package modelo;

import java.awt.Color;
import battleship.Constants;
import utilidades.StdDraw;

public class Tablero {
	public int filas;
	public int columnas;

	public Tablero(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
	}

	public Casilla[][] generarTablero() {
		Casilla[][] tablero = new Casilla[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Casilla(i, j, Casilla.TipoDeCelda.AGUA);
			}
		}
		return tablero;
	}

	public void pintarTablero(Casilla[][] tablero) {
		int ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.square(100 + Constants.MEDIDA_CASILLA * j, 
							   650 - Constants.MEDIDA_CASILLA * i, 
							   Constants.MEDIDA_CASILLA / 2);
				StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
					           650 - Constants.MEDIDA_CASILLA * i, 
					           Constants.MEDIDA_CASILLA / 2);
				if (j==0) { 
					StdDraw.text(50 + Constants.MEDIDA_CASILLA * j, 
							     650 - Constants.MEDIDA_CASILLA * i, 
							     String.valueOf(i+1));
					StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 120 + Constants.MEDIDA_CASILLA * j, 
						         650 - Constants.MEDIDA_CASILLA * i, 
						         String.valueOf(i+1));
				}
				if (i==0) { 
					StdDraw.text(100 + Constants.MEDIDA_CASILLA * j, 
							     Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * i, 
							     Character.toString((char)ascii));
					StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
						         Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * i, 
						         Character.toString((char)ascii));
					ascii++;
				}
			}
		}
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_IZQUIERDO, Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, "FLOTA ALIADA");
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_DERECHO, Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, "FLOTA ENEMIGA");
	}
}
