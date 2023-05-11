package modelo;

import java.awt.Color;

public class Barco {
	public String nombre;
	public int numeroCasillas;
	public Color color;
	public int fila;
	public int columna;
	public boolean colocado = false;
	public enum TipoDeBarco {
		PORTAAVIONES,
		ACORAZADO,
		DESTRUCTOR,
		SUBMARINO
	}
	public TipoDeBarco tipoDeBarco;
	public enum EstadoDeLasCasillasDelBarco{
		OK,
		TOCADO
	}
	public EstadoDeLasCasillasDelBarco[] estadoDeLasPartesDelBarco;
	public enum EstadoDelBarco {
		OK,
		TOCADO,
		HUNDIDO
	}
	public enum Orientacion {
		VERTICAL,
		HORIZONTAL
	}
	public Orientacion orientacion;
	
	public Barco(String nombre, int numeroCasillas, Color color, boolean colocado) {
		super();
		this.nombre = nombre;
		this.numeroCasillas = numeroCasillas;
		this.color = color;
		this.colocado = colocado;
		this.estadoDeLasPartesDelBarco = new EstadoDeLasCasillasDelBarco[numeroCasillas];
		for (int i = 0; i < estadoDeLasPartesDelBarco.length; i++) {
			estadoDeLasPartesDelBarco[i] = Barco.EstadoDeLasCasillasDelBarco.OK;
		}
	}	
	
	public boolean estaHundido() {		
		for (int i = 0; i < estadoDeLasPartesDelBarco.length; i++) {
			if (estadoDeLasPartesDelBarco[i] == Barco.EstadoDeLasCasillasDelBarco.OK) {
				return false;
			}
		}
		return true;
	}
}
