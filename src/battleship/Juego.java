package battleship;

import java.awt.Color;
import java.awt.event.KeyEvent;
import funcionalidades.Systems;
import modelo.Casilla;
import modelo.Disparo;
import modelo.Tablero;
import utilidades.StdDraw;

public class Juego {
	
	public void gameLoop() {
		Integer filaRaton, columnaRaton;
		boolean mostrarTableroEnemigo = false;
		Disparo disparo = new Disparo();
		Systems system = new Systems();
		Console consola = new Console();
		Tablero tablero = new Tablero(10,10);
		Casilla[][] tableroVacio = tablero.generarTableroVacio();	
		Casilla[][] tableroAliado = tablero.generarTableroAliado();	
		Casilla[][] tableroEnemigo = tablero.generarTableroEnemigo();
		StdDraw.enableDoubleBuffering();
		for(;;) {
			StdDraw.clear();
			
			consola.pintarConsola();
			tablero.pintarTableroAliado(tableroAliado);
			if (mostrarTableroEnemigo) {
				tablero.pintarTableroEnemigo(tableroEnemigo);
			} else {
				tablero.pintarTableroEnemigo(tableroVacio);
			}
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				break;
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
				mostrarTableroEnemigo = !mostrarTableroEnemigo; 
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				disparo = system.disparoCPU(tableroAliado);
				resaltarCasillaTableroAliado(disparo.fila, disparo.columna);
				if (system.comprobarDisparo(disparo, tableroAliado)) {
					System.out.println("tocado");
				} else {
					System.out.println("agua");
				}
			}
			filaRaton = system.detectarFila();
			columnaRaton = system.detectarColumna();
			if (filaRaton == null || columnaRaton == null) {
				System.out.println("fuera de tablero");
			} else {
				resaltarCasillaTableroEnemigo(filaRaton, columnaRaton);;
			}
			
			StdDraw.show();
			StdDraw.pause(10);
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
