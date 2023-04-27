package funcionalidades;

import java.util.Random;
import modelo.Casilla;
import modelo.Disparo;

public class Systems {
	
	public Disparo disparoCPU(Casilla[][] tablero) {
		Random fila = new Random();
		Random columna = new Random();
		return new Disparo(fila.nextInt(0, tablero.length),columna.nextInt(0, tablero[0].length));
	}
}
