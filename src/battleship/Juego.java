package battleship;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import funcionalidades.Systems;
import modelo.Barco;
import modelo.Casilla;
import modelo.Disparo;
import modelo.Tablero;
import utilidades.StdDraw;

public class Juego {
	
	public void gameLoop() {
		Integer filaRaton, columnaRaton, turno = 1;
		boolean mostrarTableroEnemigo = false;
		Disparo disparo = new Disparo();
		Systems system = new Systems();
		Console consola = new Console();
		Tablero tablero = new Tablero(10,10);
		Casilla[][] tableroVacio = tablero.generarTableroVacio();	
		Casilla[][] tableroAliado = tablero.generarTableroAliado();	
		Casilla[][] tableroEnemigo = tablero.generarTableroEnemigo();
		Set <Disparo> coordenadas = new HashSet <Disparo>();
		StdDraw.enableDoubleBuffering();
		for(;;) {
			StdDraw.clear();
			
			// Pintar tableros
			consola.pintarConsola();
			tablero.pintarTableroAliado(tableroAliado);
			if (mostrarTableroEnemigo) {
				tablero.pintarTableroEnemigo(tableroEnemigo);
			} else {
				tablero.pintarTableroVacio(tableroVacio);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
				mostrarTableroEnemigo = !mostrarTableroEnemigo; 
			}
			
			// Condición de salida
			if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				break;
			}
			
			if (turno == 1) { // Turno Usuario
				consola.mensajeTurnoHumano();
				filaRaton = system.detectarFila();
				columnaRaton = system.detectarColumna();
				if (filaRaton == null || columnaRaton == null) {
				} else {
					resaltarCasillaTableroEnemigo(filaRaton, columnaRaton);
					if (StdDraw.isMousePressed()) {
						Disparo miDisparo = new Disparo(filaRaton, columnaRaton);
						if (system.comprobarDisparo(miDisparo, tableroEnemigo)) {
							tableroVacio[miDisparo.fila][miDisparo.columna].tipo = Casilla.TipoDeCelda.BARCO;
							tableroVacio[miDisparo.fila][miDisparo.columna].barco = tableroEnemigo[miDisparo.fila][miDisparo.columna].barco;
							consola.mensajeUltimoDisparoTocado();
							turno = 2;
						} else {
							tableroVacio[miDisparo.fila][miDisparo.columna].tipo = Casilla.TipoDeCelda.AGUA;
							consola.mensajeUltimoDisparoAgua();
							turno = 2;
						}
					}
				}
			} else if (turno == 2) { // Turno CPU
				consola.mensajeTurnoCPU();
				if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
					disparo = system.disparoCPU(tableroAliado, coordenadas);
					resaltarCasillaTableroAliado(disparo.fila, disparo.columna);
					if (system.comprobarDisparo(disparo, tableroAliado)) {
						tableroAliado[disparo.fila][disparo.columna].barco.estadoDeLasPartesDelBarco[tableroAliado[disparo.fila][disparo.columna].indiceParteBarco] = Barco.EstadoDeLasCasillasDelBarco.TOCADO;
						consola.mensajeUltimoDisparoTocado();
						turno = 1;
					} else {
						tableroAliado[disparo.fila][disparo.columna].tipo = Casilla.TipoDeCelda.AGUA;
						consola.mensajeUltimoDisparoAgua();
						turno = 1;
					}
				}
			}

			// Fotograma
			StdDraw.show();
			StdDraw.pause(100);
		}
	}
	
	public void resaltarCasillaTableroAliado(Integer fila, Integer columna) {
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.setPenRadius(Constants.GROSOR_DISPARO);
		StdDraw.square(100 + Constants.MEDIDA_CASILLA * columna, 
				       650 - Constants.MEDIDA_CASILLA * fila, 
				       Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenRadius(Constants.GROSOR_POR_DEFECTO);
	}
	
	public void resaltarCasillaTableroEnemigo(Integer fila, Integer columna) {
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.setPenRadius(Constants.GROSOR_DISPARO);
		StdDraw.square(Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * columna, 
		               650 - Constants.MEDIDA_CASILLA * fila, 
		               Constants.MEDIDA_CASILLA / 2);
		StdDraw.setPenRadius(Constants.GROSOR_POR_DEFECTO);
	}
}
