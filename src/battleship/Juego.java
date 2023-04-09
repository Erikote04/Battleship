package battleship;

import java.awt.event.KeyEvent;

import modelo.Casilla;
import modelo.Tablero;
import utilidades.StdDraw;

public class Juego {
	
	public void gameLoop() {
		System.out.println("Game started");
		Tablero tablero = new Tablero(10,10);
		Casilla[][] casillas = tablero.generarTablero();		
		StdDraw.enableDoubleBuffering();
		for(;;) {
			StdDraw.clear();
			tablero.pintarTablero(casillas);
			StdDraw.show();
			StdDraw.pause(100);
			if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				break;
			}
			while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE));
		}
	}
}
