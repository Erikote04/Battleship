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
		if (mouseX < Constants.COORDENADA_LATERAL_IZQUIERDO_TABLERO_ENEMIGO
			|| mouseX > Constants.COORDENADA_LATERAL_DERECHO_TABLERO_ENEMIGO
			|| mouseY > Constants.COORDENADA_TOP_TABLERO_ENEMIGO
			|| mouseY < Constants.COORDENADA_BOTTOM_TABLERO_ENEMIGO) {
			return null;
		}
		double columna = (mouseX - Constants.COORDENADA_LATERAL_IZQUIERDO_TABLERO_ENEMIGO) / Constants.MEDIDA_CASILLA;
		return (int) columna;
	}
	
	public Integer detectarFila() {
		double mouseX = StdDraw.mouseX();
		double mouseY = StdDraw.mouseY();
		if (mouseX < Constants.COORDENADA_LATERAL_IZQUIERDO_TABLERO_ENEMIGO
				|| mouseX > Constants.COORDENADA_LATERAL_DERECHO_TABLERO_ENEMIGO
				|| mouseY > Constants.COORDENADA_TOP_TABLERO_ENEMIGO
				|| mouseY < Constants.COORDENADA_BOTTOM_TABLERO_ENEMIGO) {
				return null;
			}
		double fila = -((mouseY - Constants.COORDENADA_TOP_TABLERO_ENEMIGO) / Constants.MEDIDA_CASILLA);
		return (int) fila;
	}

}
