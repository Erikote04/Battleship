package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import funcionalidades.Pantalla;
import utilidades.StdDraw;

public class Tablero {
	public int filas;
	public int columnas;
	private ArrayList<Barco> flotaAliada;
	private ArrayList<Barco> flotaEnemiga;
	

	public Tablero(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public ArrayList<Barco> getFlotaAliada() {
		return flotaAliada;
	}

	public void setFlotaAliada(ArrayList<Barco> flotaAliada) {
		this.flotaAliada = flotaAliada;
	}

	public ArrayList<Barco> getFlotaEnemiga() {
		return flotaEnemiga;
	}

	public void setFlotaEnemiga(ArrayList<Barco> flotaEnemiga) {
		this.flotaEnemiga = flotaEnemiga;
	}

	public Casilla[][] crearTablero() {
		Casilla[][] tablero = new Casilla[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Casilla(i, j, Casilla.TipoDeCelda.NIEBLA);
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
	
	public boolean estaFlotaHundida(ArrayList<Barco> flota) {
		if (flota == null) {
			return false;
		}
		for (Barco barco : flota) {
			if (!barco.estaHundido()) {
				return false;
			}
		}
		return true;
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
		if (barco.columna > 0) {
			for (int i = 0; i < barco.numeroCasillas; i++) {
				if (tablero[barco.fila + i][barco.columna - 1] == null) {
					return false;
				}
				if (tablero[barco.fila + i][barco.columna - 1].tipo == Casilla.TipoDeCelda.BARCO) {
					return false;
				}
			}
		}
		for (int i = -1; i < barco.numeroCasillas + 2; i++) {
			if (barco.fila + i < 0 || barco.fila + i > 9) {
				continue;
			}
			if (tablero[barco.fila + i][barco.columna] == null) {
				return false;
			}
			if (tablero[barco.fila + i][barco.columna].tipo == Casilla.TipoDeCelda.BARCO) {
				return false;
			}
		}
		if (barco.columna < 9) {
			for (int i = 0; i < barco.numeroCasillas; i++) {
				if (tablero[barco.fila + i][barco.columna + 1] == null) {
					return false;
				}
				if (tablero[barco.fila + i][barco.columna + 1].tipo == Casilla.TipoDeCelda.BARCO) {
					return false;
				}
			}
		}
		return true;
	} 
	
	public boolean comprobarCasillasHorizontales(Barco barco, Casilla[][] tablero) {
		if (barco.fila > 0) {
			for (int i = 0; i < barco.numeroCasillas; i++) {
				if (tablero[barco.fila - 1][barco.columna + i] == null) {
					return false;
				}
				if (tablero[barco.fila - 1][barco.columna + i].tipo == Casilla.TipoDeCelda.BARCO) {
					return false;
				}
			}
		}
		for (int i = -1; i < barco.numeroCasillas + 2; i++) {
			if (barco.columna + i < 0 || barco.columna + i > 9) {
				continue;
			}
			if (tablero[barco.fila][barco.columna + i] == null) {
				return false;
			}
			if (tablero[barco.fila][barco.columna + i].tipo == Casilla.TipoDeCelda.BARCO) {
				return false;
			}
		}
		if (barco.fila < 9) {
			for (int i = 0; i < barco.numeroCasillas; i++) {
				if (tablero[barco.fila + 1][barco.columna + i] == null) {
					return false;
				}
				if (tablero[barco.fila + 1][barco.columna + i].tipo == Casilla.TipoDeCelda.BARCO) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Barco colocarBarcoVertical(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			Casilla c = tablero[barco.fila + i][barco.columna];
			c.tipo = Casilla.TipoDeCelda.BARCO;
			c.barco = barco;
			c.indiceParteBarco = i;
		}
		return barco;
	}
	
	public Barco colocarBarcoHorizontal(Barco barco, Casilla[][] tablero) {
		for (int i = 0; i < barco.numeroCasillas; i++) {
			Casilla c = tablero[barco.fila][barco.columna + i];
			c.tipo = Casilla.TipoDeCelda.BARCO;
			c.barco = barco;
			c.indiceParteBarco = i;
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
		flotaAliada = crearFlotaAliada();
		tableroAliado = colocarFlota(flotaAliada, tableroAliado);
		return tableroAliado;
	}
	
	public Casilla[][] generarTableroEnemigo() {
		Casilla[][] tableroEnemigo = crearTablero();
		flotaEnemiga = crearFlotaEnemiga();
		tableroEnemigo = colocarFlota(flotaEnemiga, tableroEnemigo);
		return tableroEnemigo;
	}

	public void pintarTableroAliado(Casilla[][] tableroAliado) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroAliado[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					Pantalla.pintarBarcoAliado(tableroAliado, i, j);
					if (tableroAliado[i][j].barco.estadoDeLasPartesDelBarco[tableroAliado[i][j].indiceParteBarco] == Barco.EstadoDeLasCasillasDelBarco.TOCADO) {
						Pantalla.pintarCasillaTocadoAliado(tableroAliado, i, j);
					}
				} else {
					Pantalla.pintarCasillaTableroAliado(i, j);
					if (tableroAliado[i][j].tipo == Casilla.TipoDeCelda.AGUA) {
						Pantalla.pintarCasillaAguaAliado(i, j);;
					}
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					Pantalla.pintarNumerosTableroAliado(i, j);
				}
				if (i==0) { 
					Pantalla.pintarLetrasTableroAliado(i, j, ascii);
					ascii++;
				}			
			}
		}
		Pantalla.escribirNombreTableroAliado();
	}
	
	public void pintarTableroEnemigo(Casilla[][] tableroEnemigo) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tableroEnemigo[i][j].tipo == Casilla.TipoDeCelda.BARCO) {
					Pantalla.pintarBarcoEnemigo(tableroEnemigo, i, j);
				} else {
					Pantalla.pintarCasillaTableroEnemigo(i, j);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					Pantalla.pintarNumerosTableroEnemigo(i, j);
				}
				if (i==0) { 
					Pantalla.pintarLetrasTableroEnemigo(i, j, ascii);
					ascii++;
				}			
			}
		}
		Pantalla.escribirNombreTableroEnemigo();
	}
	
	public void pintarTableroVacio(Casilla[][] tableroEnemigo) {
		char ascii = 65;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Casilla casilla = tableroEnemigo[i][j];
				if (casilla.tipo == Casilla.TipoDeCelda.BARCO) {
					if (casilla.barco.estaHundido()) {
						Pantalla.pintarBarcoEnemigo(tableroEnemigo, i, j);
					} 
					Pantalla.pintarCasillaTocadoEnemigo(tableroEnemigo, i, j);
				}
				if (casilla.tipo == Casilla.TipoDeCelda.AGUA){
					Pantalla.pintarCasillaAguaEnemigo(i, j);
				}
				if (casilla.tipo == Casilla.TipoDeCelda.NIEBLA){
					Pantalla.pintarCasillaTableroEnemigo(i, j);
				}
				StdDraw.setPenColor(Color.BLACK);
				if (j==0) { 
					Pantalla.pintarNumerosTableroEnemigo(i, j);
				}
				if (i==0) { 
					Pantalla.pintarLetrasTableroEnemigo(i, j, ascii);
					ascii++;
				}			
			}
		}
		Pantalla.escribirNombreTableroEnemigo();
	}
}
