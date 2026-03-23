package GestEmpleados;

import java.util.ArrayList;

public class ListaEmpleados {
	
	private ArrayList<Empleado> empleados;

	public ListaEmpleados() {
		this.empleados = new ArrayList<>();
	}
	
	/**
	 * Metodo que añade empleados
	 * @param empleado
	 * @return true/false si lo consigue añadir o no
	 */
	boolean añadirEmpleado(Empleado empleado) {
        boolean añadido = false;
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            añadido = true;
        }
        return añadido;
	}
	
	/**
	 * Metodo que lista empleados
	 */
	void listarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
                System.out.println("----------");
            }
        }
    }
	
	/**
	 * Metodo que busca por dni
	 * @param dni
	 * @return devuelve el objeto encontrado, en su caso el empleado
	 */
	Empleado buscarPorDni(String dni) {
		Empleado encontrado = null;
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equalsIgnoreCase(dni)) {
                encontrado = empleado;
            }
        }
        return encontrado;
	}
	
	/**
	 * Metodo que modifica las horas extra
	 * @param dni a buscar
	 * @param horas a modificar
	 * @return true/false si lo modifica o no
	 */
	boolean modificarHorasExtra(String dni, int horas) {
        boolean modificado = false;
        Empleado encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            encontrado.setHorasExtra(horas);
            modificado = true;
        }
        return modificado;
    }
	
	/**
	 * Metodo que modifica la bonificacion
	 * @param dni a buscar
	 * @param porcentaje a modificar
	 * @return true/false si lo modifica o no
	 */
	boolean modificarBonificacion(String dni, double porcentaje) {
        boolean modificado = false;
        Empleado encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            encontrado.setPorcentajeBonificacion(porcentaje);
            modificado = true;
        }
        return modificado;
    }
	
	/**
	 * Metodo que elimina empleados de la lista
	 * @param dni a buscar para eliminar
	 * @return true/false si lo consigue eliminar o no
	 */
	boolean eliminarPorDni(String dni) {
		  boolean eliminado = false;
	        Empleado encontrado = buscarPorDni(dni);
	        if (encontrado != null) {
	            empleados.remove(encontrado);
	            eliminado = true;
	        }
	        return eliminado;
	    }

	/**
	 * Metodo que calcula el total de bonificaciones a empleados
	 * @return total de bonificaciones a empleados
	 */
	double calcularGastoBonificaciones() {
		double sumaTotalBonificaciones = 0;
		for (Empleado empleado : empleados) {
			sumaTotalBonificaciones += empleado.bonificacion();
		}
		
		return sumaTotalBonificaciones;
	}
	
	/**
	 * Metodo que lista los empleados de alto desempeño
	 */
	void listarEmpleadosAltoDesempenio() {
		boolean hayAltoDesempenio = false;
		for (Empleado empleado : empleados) {
			if (empleado.esAltoDesempenio()) {
				System.out.println("--------------");
				System.out.println(empleado);
				System.out.println("--------------");
				hayAltoDesempenio = true;
			}
		}
		if (!hayAltoDesempenio) {
			System.out.println("No hay empleados con alto desempeño, ponles las pilas.");
		}
	}
		
	
	
	
}
