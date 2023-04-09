package battleship;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import utilidades.StdDraw;

public class InterfazUsuario {

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		int width = (int)screenWidth;
		int height = (int)screenHeight;
		
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		
		while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE));
		Juego battleship = new Juego();
		battleship.gameLoop();
	}
}
