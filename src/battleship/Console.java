package battleship;

import java.awt.Color;

import utilidades.StdDraw;

public class Console {
	
	public void pintarConsola() {
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		StdDraw.filledRectangle(Constants.MITAD_ANCHO_PANTALLA, 
				                Constants.COORDENADA_Y_CONSOLA, 
				                Constants.ANCHO_CONSOLA, 
				                Constants.ALTO_CONSOLA);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.rectangle(Constants.MITAD_ANCHO_PANTALLA, 
				          Constants.COORDENADA_Y_CONSOLA, 
				          Constants.ANCHO_CONSOLA, 
				          Constants.ALTO_CONSOLA);
	}
	
	public void mensajeTurnoHumano() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 110, "Turno del usuario, para disparar haga click sobre una celda libre del TABLERO ENEMIGO");
	}
	
	public void mensajeTurnoCPU() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 110, "Turno de la CPU, para disparar pulse la tecla espacio");
	}
	
	public void mensajeUltimoDisparoAgua() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 80, "Último disparo: ¡AGUA!");
	}
	
	public void mensajeUltimoDisparoTocado() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 80, "Último disparo: ¡TOCADO!");
	}
	
	public void mensajeUltimoDisparoHundido() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 80, "Último disparo: ¡HUNDIDO!");
	}
	
	public void mensajeGanadorUsuario(String tiempoPartida) {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 40, "!GANAS TÚ! Duración de la partida:" + tiempoPartida);
	}
	
	public void mensajeGanadorCPU(String tiempoPartida) {
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(Constants.MITAD_ANCHO_PANTALLA, 40, "!GANAS LA CPU! Duración de la partida:" + tiempoPartida);
	}
}
