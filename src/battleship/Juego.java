package battleship;

import java.awt.event.KeyEvent;

import modelo.Casilla;
import modelo.Tablero;
import utilidades.StdDraw;

public class Juego {
	
	public void gameLoop() {
		Console consola = new Console();
		Tablero tablero = new Tablero(10,10);
		Casilla[][] tableroAliado = tablero.generarTableroAliado();	
		Casilla[][] tableroEnemigo = tablero.generarTableroEnemigo();
		StdDraw.enableDoubleBuffering();
		for(;;) {
			StdDraw.clear();
			consola.pintarConsola();
			tablero.pintarTableroAliado(tableroAliado);
			tablero.pintarTableroEnemigo(tableroEnemigo);
			StdDraw.show();
			StdDraw.pause(100);
			if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				break;
			}
			while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE));
		}
	}
}
