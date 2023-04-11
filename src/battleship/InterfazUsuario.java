package battleship;

import java.awt.event.KeyEvent;
import utilidades.StdDraw;

public class InterfazUsuario {

	public static void main(String[] args) {
		
		StdDraw.setCanvasSize(Constants.ANCHO_PANTALLA, Constants.ALTO_PANTALLA);
		StdDraw.setXscale(0, Constants.ANCHO_PANTALLA);
		StdDraw.setYscale(0, Constants.ALTO_PANTALLA);
		
		MenuPrincipal menu = new MenuPrincipal();
		menu.mostrarMenu();
		
		while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE));
		Juego battleship = new Juego();
		battleship.gameLoop();
	}
}
