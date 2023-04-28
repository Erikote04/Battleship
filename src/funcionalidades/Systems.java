package funcionalidades;

import java.util.Random;
import battleship.Constants;
import modelo.Barco;
import modelo.Casilla;
import modelo.Disparo;
import utilidades.StdDraw;

public class Systems {
	
	public Disparo disparoCPU(Casilla[][] tablero) {
		Random fila = new Random();
		Random columna = new Random();
		return new Disparo(fila.nextInt(0, tablero.length),columna.nextInt(0, tablero[0].length));
	}
	
	public boolean comprobarDisparo(Disparo disparo, Casilla[][] tablero) {
		if (tablero[disparo.fila][disparo.columna].tipo == Casilla.TipoDeCelda.BARCO) {
			tablero[disparo.fila][disparo.columna].estadoCasillaBarco = Barco.EstadoDeLasCasillasDelBarco.TOCADO;
			return true;
		}
		return false;
	}
	
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
