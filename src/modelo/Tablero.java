package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
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
	
	public Casilla[][] crearTablero() {
		Casilla[][] tablero = new Casilla[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Casilla(i, j, Casilla.TipoDeCelda.AGUA);
			}
		}
		return tablero;
	}
	
	public ArrayList<Barco> crearFlota() {
		ArrayList<Barco> flota = new ArrayList<Barco>();
		flota.add(0, new Barco("Portaaviones", 4, Color.GREEN, false));
		flota.add(1, new Barco("Acorazado1", 3, Color.BLUE, false));
		flota.add(2, new Barco("Acorazado2", 3, Color.BLUE, false));
		flota.add(3, new Barco("Destructor1", 2, Color.GRAY, false));
		flota.add(4, new Barco("Destructor2", 2, Color.GRAY, false));
		flota.add(5, new Barco("Destructor3", 2, Color.GRAY, false));
		flota.add(6, new Barco("Submarino1", 1, Color.MAGENTA, false));
		flota.add(7, new Barco("Submarino2", 1, Color.MAGENTA, false));
		flota.add(8, new Barco("Submarino3", 1, Color.MAGENTA, false));
		flota.add(9, new Barco("Submarino4", 1, Color.MAGENTA, false));
		return flota;
	}
	public Barco.Orientacion orientacionAleatoria() {
		Random orientacion = new Random();
		int direccion = orientacion.nextInt(2);
		if (direccion == 0) {
			return Barco.Orientacion.VERTICAL;
		} else {
			return Barco.Orientacion.HORIZONTAL;
		}
	}
	public Casilla[][] colocarBarcos(ArrayList<Barco> flota, Casilla[][] tablero) {
		for (Barco barco : flota) {
			while(barco.colocado==false) {
				barco.orientacion=orientacionAleatoria();
				if (barco.orientacion == Barco.Orientacion.VERTICAL) {
					Random columna = new Random();
					barco.columna = columna.nextInt(0, columnas);
					Random fila = new Random();
					barco.fila = fila.nextInt(0, filas - barco.numeroCasillas);
					tablero[barco.fila][barco.columna]=new Casilla(barco.fila, barco.columna, Casilla.TipoDeCelda.BARCO);
					barco.colocado=true;
				}
				if (barco.orientacion == Barco.Orientacion.HORIZONTAL) {
					Random columna = new Random();
					barco.columna = columna.nextInt(0, columnas - barco.numeroCasillas);
					Random fila = new Random();
					barco.fila = fila.nextInt(0, filas);
					tablero[barco.fila][barco.columna]=new Casilla(barco.fila, barco.columna, Casilla.TipoDeCelda.BARCO);
					barco.colocado=true;
				}
			}
		}
		return tablero;
	}
	
	public Casilla[][] generarTableroAliado() {
		Casilla[][] tableroAliado = crearTablero();
		tableroAliado = colocarBarcos(crearFlota(), tableroAliado);
		return tableroAliado;
	}
	
	public Casilla[][] generarTableroEnemigo() {
		Casilla[][] tableroEnemigo = crearTablero();
		tableroEnemigo = colocarBarcos(crearFlota(), tableroEnemigo);
		return tableroEnemigo;
	}

	public void pintarTableroAliado(Casilla[][] tableroAliado) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroAliado[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					StdDraw.setPenColor(Color.RED);
					StdDraw.filledSquare(100 + Constants.MEDIDA_CASILLA * j, 
							             650 - Constants.MEDIDA_CASILLA * i, 
							             Constants.MEDIDA_CASILLA / 2);
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.square(100 + Constants.MEDIDA_CASILLA * j, 
							             650 - Constants.MEDIDA_CASILLA * i, 
							             Constants.MEDIDA_CASILLA / 2);
				} else {
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.square(100 + Constants.MEDIDA_CASILLA * j, 
								   650 - Constants.MEDIDA_CASILLA * i, 
								   Constants.MEDIDA_CASILLA / 2);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					StdDraw.text(50 + Constants.MEDIDA_CASILLA * j, 
								 650 - Constants.MEDIDA_CASILLA * i, 
								 String.valueOf(i+1));
				}
				if (i==0) { 
					StdDraw.text(100 + Constants.MEDIDA_CASILLA * j, 
								 Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * i, 
								 "" + ascii);
					ascii++;
				}			
			}
		}
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_IZQUIERDO, Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, "FLOTA ALIADA");
	}
	
	public void pintarTableroEnemigo(Casilla[][] tableroEnemigo) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroEnemigo[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					StdDraw.setPenColor(Color.RED);
					StdDraw.filledSquare(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
					                     650 - Constants.MEDIDA_CASILLA * i, 
					                     Constants.MEDIDA_CASILLA / 2);
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
		                     650 - Constants.MEDIDA_CASILLA * i, 
		                     Constants.MEDIDA_CASILLA / 2);
				} else {
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
						           650 - Constants.MEDIDA_CASILLA * i, 
						           Constants.MEDIDA_CASILLA / 2);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 120 + Constants.MEDIDA_CASILLA * j, 
							     650 - Constants.MEDIDA_CASILLA * i, 
							     String.valueOf(i+1));
				}
				if (i==0) { 
					StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * j, 
							     Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * i, 
							     "" + ascii);
					ascii++;
				}			
			}
		}
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_DERECHO, Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, "FLOTA ENEMIGA");
	}
}
