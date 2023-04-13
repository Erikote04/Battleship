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
}
