package funcionalidades;

import battleship.Constants;
import utilidades.StdDraw;

public class Raton {
	
	public Integer detectarColumna() {
		double mouseX = StdDraw.mouseX();
		double mouseY = StdDraw.mouseY();
		if (mouseX < Constants.MITAD_ANCHO_PANTALLA + 170
			|| mouseX > Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * 9
			|| mouseY > 650
			|| mouseY < 650 - Constants.MEDIDA_CASILLA * 9) {
			return null;
		}
		double columna = (mouseX - (Constants.MITAD_ANCHO_PANTALLA + 170)) / Constants.MEDIDA_CASILLA;
		return (int) columna;
	}
	
	public Integer detectarFila() {
		double mouseX = StdDraw.mouseX();
		double mouseY = StdDraw.mouseY();
		if (mouseX < Constants.MITAD_ANCHO_PANTALLA + 170
			|| mouseX > Constants.MITAD_ANCHO_PANTALLA + 170 + Constants.MEDIDA_CASILLA * 9
			|| mouseY > 650
			|| mouseY < 650 - Constants.MEDIDA_CASILLA * 9) {
			return null;
		}
		double fila = (mouseY - 650) / Constants.MEDIDA_CASILLA;
		return (int) fila;
	}
}
