package modelo;

import java.awt.Color;

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
		Casilla barco1 = new Casilla(0, 2, Casilla.TipoDeCelda.BARCO);
		barco1.estadoCasillaBarco = Barco.EstadoDeLasCasillasDelBarco.OK;
		tablero[0][2] = barco1;
		Casilla barco2 = new Casilla(3, 2, Casilla.TipoDeCelda.BARCO);
		barco2.estadoCasillaBarco = Barco.EstadoDeLasCasillasDelBarco.OK;
		tablero[3][2] = barco2;
		return tablero;
	}

	public void pintarTablero(Casilla[][] tablero) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					StdDraw.setPenColor(Color.RED);
					StdDraw.filledSquare(100 + 20 * i, 100 + 20 * j, 10);
					System.out.println("barco");
				} else {
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.square(100 + 20 * i, 100 + 20 * j, 10);
				}
			}
		}
	}
}
