package com.nttdata.javat3.presentation;

/**
 * Clase que contiene los metodos para imprimir el texto de los menus de la
 * aplicacion
 * 
 * @author adri
 *
 */
public class Menus {
	/**
	 * Constante del texto para seleccionar una opcion
	 */
	private static final String SEL_OPC = "Selecciona una opci�n: ";

	/**
	 * Se hace privado el constructor para que no se instancie la clase.
	 */
	private Menus() {

	}

	/**
	 * Metodo que muestra el menu principal
	 */
	static void showMainMenu() {
		System.out.println("----- MEN� PRINCIPAL -----");
		System.out.println("1. Gesti�n Empleados");
		System.out.println("2. Gesti�n Alumnos");
		System.out.println("3. Salir");
		System.out.print(SEL_OPC);
	}

	/**
	 * Metodo que muestra el menu de empleados
	 */
	static void showEmployeeMenu() {
		System.out.println("\n----- SUBMEN� EMPLEADOS -----");
		System.out.println("1.1. Nuevo Empleado");
		System.out.println("1.2. Eliminar Empleado");
		System.out.println("1.3. Actualizar datos de un Empleado");
		System.out.println("1.4. Buscar y mostrar los datos de un Empleado");
		System.out.println("5. Volver al men� principal");
		System.out.print(SEL_OPC);
	}

	/**
	 * Metodo que muestra el menu de estudiantes
	 */
	static void showStudentMenu() {
		System.out.println("\n----- SUBMEN� ESTUDIANTES -----");
		System.out.println("2.1. Nuevo Estudiante");
		System.out.println("2.2. Eliminar Estudiante");
		System.out.println("2.3. Actualizar datos de un Estudiante");
		System.out.println("2.4. Buscar y mostrar los datos de un Estudiante");
		System.out.println("5. Volver al men� principal");
		System.out.print(SEL_OPC);
	}
}
