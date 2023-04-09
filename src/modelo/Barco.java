package modelo;

import java.awt.Color;

public class Barco {
	public String nombre;
	public int numeroCasillas;
	public Color color;
	public Casilla[] localizacion;
	public enum TipoDeBarco {
		PORTAAVIONES,
		ACORAZADO,
		DESTRUCTOR,
		SUBMARINO
	}
	public enum EstadoDeLasCasillasDelBarco{
		OK,
		TOCADO
	}
	public enum EstadoDelBarco {
		OK,
		TOCADO,
		HUNDIDO
	}	
}
