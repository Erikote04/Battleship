package battleship;

import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class Juego {
	
	public void gameLoop() {
		StdDraw.enableDoubleBuffering();
		for(;;) {
			StdDraw.show();
			StdDraw.pause(0);
			StdDraw.clear();
			if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				break;
			}
		}
	}
}
