package funcionalidades;


import java.util.Random;
import java.util.Set;
import battleship.Constants;
import modelo.Barco;
import modelo.Casilla;
import modelo.Disparo;
import utilidades.StdDraw;

public class Systems {
	
	public Disparo disparoCPU(Casilla[][] tablero, Set<Disparo> coordenadas) {
		Random fila = new Random();
		Random columna = new Random();
		Disparo disparo = new Disparo(fila.nextInt(0, tablero.length),columna.nextInt(0, tablero[0].length));
		while (!coordenadas.add(disparo)) {
			disparo = new Disparo(fila.nextInt(0, tablero.length),columna.nextInt(0, tablero[0].length));
		}
		return disparo;
	}
	
	public boolean comprobarDisparo(Disparo disparo, Casilla[][] tablero) {
		Casilla casilla = tablero[disparo.fila][disparo.columna];
		if (casilla.tipo == Casilla.TipoDeCelda.BARCO) {
			casilla.barco.estadoDeLasPartesDelBarco[casilla.indiceParteBarco] = Barco.EstadoDeLasCasillasDelBarco.TOCADO;
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
