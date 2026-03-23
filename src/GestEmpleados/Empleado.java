package GestEmpleados;

import java.util.Objects;

public class Empleado {
	
	private String dni;
	private String nombre;
	private double salarioBase;
	private double porcentajeBonificacion;
	private static double valorHorasExtra;
	private int horasExtra;
	
	public Empleado(String dni, String nombre, double salarioBase, double porcentajeBonificacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
	}

	public String getDni() {
		return dni;
	}

	public void setPorcentajeBonificacion(double porcentajeBonificacion) {
		this.porcentajeBonificacion = porcentajeBonificacion;
	}

	public static void setValorHorasExtra(double valorHorasExtra) {
		Empleado.valorHorasExtra = valorHorasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}
	
	/**
	 * Método que devuelve el importe de la bonificación
	 * @return (salario base × porcentaje bonificación / 100)
	 */
	double bonificacion() {
		double bonificacionCalculada;
		bonificacionCalculada = this.salarioBase * this.porcentajeBonificacion /100;
		return bonificacionCalculada;
	}
	
	/**
	 * Métodos que devuelve lo ganado con horas extra
	 * @return horas extra × precio hora extra
	 */
	double calcularHorasExtra() {
		double totalHorasExtra;
		totalHorasExtra = this.horasExtra * Empleado.valorHorasExtra;
		return totalHorasExtra;
	}
	
	/**
	 * Método que devuelve el salario bruto
	 * @return salario base+bonificación+complemento horas extra
	 */
	double salarioBruto() {
		double salarioBruto;
		salarioBruto = this.salarioBase + this.bonificacion() + this.calcularHorasExtra();
		return salarioBruto;
		
	}
	
	/**
	 * Método que retorna true si bonificación > 15%
	 * @return true/false si es > 15 o no
	 */
	boolean esAltoDesempenio() {
		boolean tieneBonificacionPremium = false;
		if (this.porcentajeBonificacion > 15) {
			tieneBonificacionPremium = true;
		}
		return tieneBonificacionPremium;
	}

	/**
	 * Metodo toString para mostrar con formato personalizado
	 */
	@Override
	public String toString() {
		return this.dni + " - " + this.nombre + "\n" +
				"Salario Base: " + this.salarioBase + " | " + "Bonificacion: " + this.bonificacion() + " (" + this.porcentajeBonificacion + "%) \n"
				+ "Horas Extra: " + this.horasExtra + " | " + "Total Bruto: " + this.salarioBruto();
	}

	
	/** 
	 * Metodo equals para que se cumpla que dos empleados son iguales si tienen el mismo DNI
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
