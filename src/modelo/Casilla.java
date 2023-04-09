package modelo;

import modelo.Barco.EstadoDeLasCasillasDelBarco;

public class Casilla {
	public int columna;
	public int fila;
	public enum TipoDeCelda {
		NIEBLA,
		AGUA,
		BARCO
	}
	public TipoDeCelda tipo;
	public EstadoDeLasCasillasDelBarco estadoCasillaBarco;
	
	public Casilla(int fila, int columna, TipoDeCelda tipo) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.tipo = tipo;
	}	
}
 