package modelo;

public class Casilla {
	public int columna;
	public int fila;
	public enum TipoDeCelda {
		NIEBLA,
		AGUA,
		BARCO
	}
	public TipoDeCelda tipo;
	public Barco barco;
	public int indiceParteBarco;
	
	public Casilla(int fila, int columna, TipoDeCelda tipo) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.tipo = tipo;
	}	
}
 