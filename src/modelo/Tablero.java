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
	
	public ArrayList<Barco> crearFlotaAliada() {
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
	
	public ArrayList<Barco> crearFlotaEnemiga() {
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
	
	public Barco colocacionVerticalAleatoria(Barco barco) {
		Random columna = new Random();
		barco.columna = columna.nextInt(0, columnas);
		Random fila = new Random();
		barco.fila = fila.nextInt(0, filas - barco.numeroCasillas);
		return barco;
	}
	
	public Barco colocacionHorizontalAleatoria(Barco barco) {
		Random columna = new Random();
		barco.columna = columna.nextInt(0, columnas - barco.numeroCasillas);
		Random fila = new Random();
		barco.fila = fila.nextInt(0, filas);
		return barco;
	}
	
	public boolean comprobarCasillasVerticales(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			if (tablero[barco.fila + i][barco.columna] == null) {
				return false;
			}
			if (tablero[barco.fila + i][barco.columna].tipo == Casilla.TipoDeCelda.BARCO) {
				return false;
			}
		}
		return true;
	} 
	
	public boolean comprobarCasillasHorizontales(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			if (tablero[barco.fila][barco.columna + i] == null) {
				return false;
			}
			if (tablero[barco.fila][barco.columna + i].tipo == Casilla.TipoDeCelda.BARCO) {
				return false;
			}
		}
		return true;
	}
	
	public Barco colocarBarcoVertical(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			tablero[barco.fila + i][barco.columna].tipo = Casilla.TipoDeCelda.BARCO;
			tablero[barco.fila + i][barco.columna].barco = barco;
		}
		return barco;
	}
	
	public Barco colocarBarcoHorizontal(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			tablero[barco.fila][barco.columna + i].tipo = Casilla.TipoDeCelda.BARCO;
			tablero[barco.fila][barco.columna + i].barco = barco;
		}
		return barco;
	}
	
	public Casilla[][] colocarFlota(ArrayList<Barco> flota, Casilla[][] tablero) {
		for (Barco barco : flota) {
			while(barco.colocado == false) {
				barco.orientacion = orientacionAleatoria();
				if (barco.orientacion == Barco.Orientacion.VERTICAL) {
					barco = colocacionVerticalAleatoria(barco);
					if (comprobarCasillasVerticales(barco, tablero)) {
						colocarBarcoVertical(barco, tablero);
						barco.colocado = true;
					}
				}
				if (barco.orientacion == Barco.Orientacion.HORIZONTAL) {
					barco = colocacionHorizontalAleatoria(barco);
					if (comprobarCasillasHorizontales(barco, tablero)) {
						colocarBarcoHorizontal(barco, tablero);
						barco.colocado = true;
					}
				}
			}
		}
		return tablero;
	}
	
	public Casilla[][] generarTableroVacio() {
		Casilla[][] tableroVacio = crearTablero();
		return tableroVacio;
	}
	
	public Casilla[][] generarTableroAliado() {
		Casilla[][] tableroAliado = crearTablero();
		tableroAliado = colocarFlota(crearFlotaAliada(), tableroAliado);
		return tableroAliado;
	}
	
	public Casilla[][] generarTableroEnemigo() {
		Casilla[][] tableroEnemigo = crearTablero();
		tableroEnemigo = colocarFlota(crearFlotaEnemiga(), tableroEnemigo);
		return tableroEnemigo;
	}
	
	public void pintarBarcoAliado(Casilla[][] tablero, int fila, int columna) {
		StdDraw.setPenColor(tablero[fila][columna].barco.color);
		StdDraw.filledSquare(100 + Constants.MEDIDA_CASILLA * columna, 
				             650 - Constants.MEDIDA_CASILLA * fila, 
				             Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(100 + Constants.MEDIDA_CASILLA * columna, 
				       650 - Constants.MEDIDA_CASILLA * fila, 
				       Constants.MEDIDA_CASILLA / 2);
	}
	
	public void pintarCasillaTableroAliado(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(100 + Constants.MEDIDA_CASILLA * columna, 
					   650 - Constants.MEDIDA_CASILLA * fila, 
					   Constants.MEDIDA_CASILLA / 2);
	}
	
	public void pintarNumerosTableroAliado(int fila, int columna) {
		StdDraw.text(50 + Constants.MEDIDA_CASILLA * columna, 
				     650 - Constants.MEDIDA_CASILLA * fila, 
				     String.valueOf(fila + 1));
	}
	
	public void pintarLetrasTableroAliado(int fila, int columna, char ascii) {
		StdDraw.text(100 + Constants.MEDIDA_CASILLA * columna, 
				     Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * fila, 
				     "" + ascii);
	}
	
	public void escribirNombreTableroAliado() {
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_IZQUIERDO, 
				     Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, 
				     "FLOTA ALIADA");
	}

	public void pintarTableroAliado(Casilla[][] tableroAliado) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroAliado[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					pintarBarcoAliado(tableroAliado, i, j);
				} else {
					pintarCasillaTableroAliado(i, j);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					pintarNumerosTableroAliado(i, j);
				}
				if (i==0) { 
					pintarLetrasTableroAliado(i, j, ascii);
					ascii++;
				}			
			}
		}
		escribirNombreTableroAliado();
	}
	
	public void pintarBarcoEnemigo(Casilla[][] tablero, int fila, int columna) {
		StdDraw.setPenColor(tablero[fila][columna].barco.color);
		StdDraw.filledSquare(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
		                     650 - Constants.MEDIDA_CASILLA * fila, 
		                     Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
                       650 - Constants.MEDIDA_CASILLA * fila, 
                       Constants.MEDIDA_CASILLA / 2);
	}
	
	public void pintarCasillaTableroEnemigo(int fila, int columna) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
			           650 - Constants.MEDIDA_CASILLA * fila, 
			           Constants.MEDIDA_CASILLA / 2);
	}
	
	public void pintarNumerosTableroEnemigo(int fila, int columna) {
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 120 + Constants.MEDIDA_CASILLA * columna, 
			     650 - Constants.MEDIDA_CASILLA * fila, 
			     String.valueOf(fila + 1));
	}
	
	public void pintarLetrasTableroEnemigo(int fila, int columna, char ascii) {
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
			         Constants.COORDENADA_Y_PARA_LETRAS - Constants.MEDIDA_CASILLA * fila, 
			         "" + ascii);
	}
	
	public void escribirNombreTableroEnemigo() {
		StdDraw.text(Constants.COORDENADA_CENTRAL_X_TABLERO_DERECHO, 
				     Constants.COORDENADA_Y_PARA_NOMBRE_TABLEROS, 
				     "FLOTA ENEMIGA");
	}
	
	public void pintarTableroEnemigo(Casilla[][] tableroEnemigo) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroEnemigo[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					pintarBarcoEnemigo(tableroEnemigo, i, j);
				} else {
					pintarCasillaTableroEnemigo(i, j);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					pintarNumerosTableroEnemigo(i, j);
				}
				if (i==0) { 
					pintarLetrasTableroEnemigo(i, j, ascii);
					ascii++;
				}			
			}
		}
		escribirNombreTableroEnemigo();
	}
}
