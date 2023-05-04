package modelo;

import java.util.Objects;

public class Disparo {
	public int fila;
	public int columna;
	
	public Disparo() {

	}
	
	public Disparo(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disparo other = (Disparo) obj;
		return columna == other.columna && fila == other.fila;
	}	
}
