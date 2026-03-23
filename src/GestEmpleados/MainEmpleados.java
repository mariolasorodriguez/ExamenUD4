package GestEmpleados;

import java.util.Scanner;

public class MainEmpleados {
	
	Scanner reader = new Scanner(System.in);
	ListaEmpleados lista = new ListaEmpleados();
	
	public static void main(String[] args) {
		MainEmpleados mainEmpleados = new MainEmpleados();
		int opcionIntroducida = 0;
		
		do {
			opcionIntroducida = mainEmpleados.listarMenu();
			mainEmpleados.menuGestion(opcionIntroducida);
		} while (opcionIntroducida != 9);
	}
	
	/**
	 * Metodo para mostrar las opciones del menu
	 * @return opcion introducida por el usuario
	 */
	int listarMenu() {
		System.out.println("== BIENVENIDO AL GESTOR DE EMPLEADOS ==");
		System.out.println("MENU DE OPCIONES: ");
		System.out.println("1. Añadir un empleado");
		System.out.println("2. Listar empleados");
		System.out.println("3. Buscar empleado por dni");
		System.out.println("4. Modificar horas extra");
		System.out.println("5. Modificar bonificación");
		System.out.println("6. Modificar precio hora extra");
		System.out.println("7. Eliminar empleado");
		System.out.println("8. Ver estadisticas");
		System.out.println("9. Salir");
		
		System.out.println("Introduce una opcion (1-9): ");
		int opcionIntroducida;
		opcionIntroducida = reader.nextInt();
		return opcionIntroducida;
	}
	
	/**
	 * Metodo para elegir que opcion del menu usar
	 * @param opcionIntroducida del usuario
	 */
	void menuGestion(int opcionIntroducida) {
		switch(opcionIntroducida) {
		case 1:
			añadirEmpleado();
			break;
		case 2:
			listarEmpleados();
			break;
		case 3:
			buscarPorDni();
			break;
		case 4:
			modificarHorasExtra();
			break;
		case 5:
			modificarBonificacion();
			break;
		case 6:
			modificarPrecioHorasExtra();
			break;
		case 7:
			eliminarEmpleado();
			break;
		case 8:
			mostrarEstadisticas();
			break;
		case 9:
			salida();
			break;
		default:
			System.out.println("Opcion no valida, intente de nuevo con opciones del (1 al 9)");
			break;
		}
	}
	
	/**
	 * Metodo para añadir nuevos empleados
	 */
	void añadirEmpleado() {
		System.out.println("Introduce DNI: ");
		String dni = reader.next();
		reader.nextLine();
		
		System.out.println("Introduce nombre y apellidos: ");
		String nombre = reader.nextLine();
		
		System.out.println("Introduce salario base: ");
		double salarioBase = reader.nextDouble();
		
		System.out.println("Introduce porcentaje de bonificacion: ");
		double porcentajeBonificacion = reader.nextDouble();
		
		reader.nextLine();
		
		Empleado empleado = new Empleado(dni, nombre, salarioBase, porcentajeBonificacion);
		boolean resultado = lista.añadirEmpleado(empleado);
		
		if (resultado) {
			System.out.println("Empleado añadido correctamente.");
		} else {
			System.out.println("ERROR: Ya existe un empleado con ese DNI");
		}
	}
	
	/**
	 * Metodo para listar los empleados existentes
	 */
	void listarEmpleados() {
		lista.listarTodos();
	}
	
	/**
	 * Metodo para buscar un empleado introduciendo su DNI
	 */
	void buscarPorDni() {
		String dni;
		System.out.println("Introduce el DNI del empleado a buscar: ");
		dni = reader.next();
		reader.nextLine();
		
		Empleado encontrado = lista.buscarPorDni(dni);
		
		if (encontrado != null) {
			System.out.println(encontrado);
		} else {
			System.out.println("No se ha encontrado el empleado con el dni " + dni + ".");
		}
	}
	
	/**
	 * Metodo para modificar horas extra de un empleado
	 */
	void modificarHorasExtra() {
		String dni;
		int horasExtra;
		
		System.out.println("Introduce el DNI del empleado: ");
		dni = reader.next();
		reader.nextLine();
		
		System.out.println("Introduce las nuevas horas extra realizadas: ");
		horasExtra = reader.nextInt();
		
		Empleado encontrado = lista.buscarPorDni(dni);
		
		if (encontrado != null) {
			encontrado.setHorasExtra(horasExtra);
			System.out.println("Horas extra modificadas.");
		} else {
			System.out.println("No se encontró el empleado con dni " + dni + ".");
		}
	}
	
	/**
	 * Metodo para modificar bonificacion de un empleado
	 */
	void modificarBonificacion() {
		String dni;
		double porcentajeBonificacion;
		
		System.out.println("Introduce el DNI del empleado: ");
		dni = reader.next();
		reader.nextLine();
		
		System.out.println("Introduce el nuevo porcentaje de bonificacion: ");
		porcentajeBonificacion = reader.nextDouble();
		
		Empleado encontrado = lista.buscarPorDni(dni);
		
		if (porcentajeBonificacion >= 0 && porcentajeBonificacion <=30) {
			encontrado.setPorcentajeBonificacion(porcentajeBonificacion);
			System.out.println("Porcentaje modificado");
		} else {
			System.out.println("ERROR: Porcentaje invalido,  debe ser (0-30)");
		}
	}
	
	/**
	 * Metodo para modificar el precio generalizado a las horas extra
	 */
	void modificarPrecioHorasExtra() {
		double valorExtrasHora;
		
		System.out.println("NOTA: Esto afecta a todos los empleados.");
		System.out.println("Introduce el nuevo precio de horas extra: ");
		valorExtrasHora = reader.nextDouble();
		
		Empleado.setValorHorasExtra(valorExtrasHora);
		System.out.println("Valor de horas extra modificado correctamente.");
	}
	
	/**
	 * Metodo que elimina un empleado introduciendo su DNI
	 */
	void eliminarEmpleado() {
		String dni;
        System.out.println("Introduce el DNI: ");
        dni = reader.next();
        reader.nextLine();
        System.out.println("¿Está segur@ de eliminar el empleado?");

        Empleado encontrado = lista.buscarPorDni(dni);
        if (encontrado != null) {
            System.out.println("¿Esta segur@ de eliminar este empleado? s/n");
            System.out.println(encontrado);
            String confirmacion = reader.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {
                lista.eliminarPorDni(dni);
                System.out.println("El empleado ha sido eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else {
            System.out.println("No se encontro el empleado");
        }
	}
	
	/**
	 * Metodo para mostrar las estadisticas
	 */
	void mostrarEstadisticas() {
		System.out.println("Total de bonificaciones: ");
		System.out.println(lista.calcularGastoBonificaciones() + "€");
		System.out.println("Lista de empleados con alto desempeño: ");
		lista.listarEmpleadosAltoDesempenio();
	}
	
	void salida() {
		System.out.println("Gracias por usarme, nos vemos pronto (o eso espero)");
	}
	
	
	
	
	
}
