package com.nttdata.javat3.presentation;

import java.util.Scanner;

import com.nttdata.javat3.business.ManagementServiceImpl;
import com.nttdata.javat3.data.entities.Employee;
import com.nttdata.javat3.data.entities.Student;

import utils.Utils;

/**
 * Clase que contiene la funcionalidad principal de la aplicacion
 * 
 * @author adri
 *
 */
public class T3Mainadl {
	/**
	 * Constante del texto para introducir un empleado
	 */
	private static final String EMP_DNI_IN = "Introduce el dni del empleado";
	/**
	 * Constante del texto para opcion invalida
	 */
	private static final String INVALID_OPT = "Opcion invalida. Por favor, selecciona una opcion valida del menu.";
	/**
	 * Constante del texto para introducir el dni del estudiante
	 */
	private static final String DNI_IN = "Introduce el dni del estudiante";
	/**
	 * Atributo estático que mantiene constancia de las operaciones con empleados
	 */
	private static ManagementServiceImpl<Employee> employeeManagementService = new ManagementServiceImpl<>();
	/**
	 * Atributo estático que mantiene constancia de las operaciones con estudiantes
	 */
	private static ManagementServiceImpl<Student> studentManagementService = new ManagementServiceImpl<>();

	/**
	 * Constructor privado para que no se instancie la clase
	 */
	private T3Mainadl() {

	}

	/**
	 * Método principal que inicializa la aplicacion
	 * 
	 * @param args comandos en la consola
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		while (!salir) {
			Menus.showMainMenu();
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				employeeManagement(scanner);
				break;
			case 2:
				studentManagement(scanner);
				break;
			case 3:
				salir = true;
				System.out.println("�Hasta luego!");
				break;
			default:
				System.out.println(INVALID_OPT);
				break;
			}
		}

	}

	/**
	 * Metodo que contiene la logica del menu de empleados
	 * 
	 * @param scanner Scanner para leer datos
	 */
	private static void employeeManagement(Scanner scanner) {

		int opcion;
		boolean goBack = false;
		Employee emp;

		while (!goBack) {
			Menus.showEmployeeMenu();
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				emp = new Employee();
				emp.updateData();
				employeeManagementService.personReg(emp);
				break;
			case 2:
				employeeManagementService.deletePerson(Utils.readString(EMP_DNI_IN));
				break;
			case 3:
				employeeManagementService.updatePerson(Utils.readString(EMP_DNI_IN));
				break;
			case 4:
				emp = employeeManagementService.searchPerson(Utils.readString(EMP_DNI_IN));
				if (emp != null)
					emp.showDetails();
				break;
			case 5:
				employeeManagementService.showPersons();
				break;
			case 6:
				goBack = true;
				break;
			default:
				System.out.println(INVALID_OPT);
				break;
			}
		}

	}

	/**
	 * Metodo que contiene la logica del menu de estudiantes
	 * 
	 * @param scanner Scanner para leer datos
	 */
	private static void studentManagement(Scanner scanner) {

		int opcion;
		boolean goBack = false;
		Student st;

		while (!goBack) {
			Menus.showStudentMenu();
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				st = new Student();
				st.updateData();
				studentManagementService.personReg(st);
				break;
			case 2:
				studentManagementService.deletePerson(Utils.readString(DNI_IN));
				break;
			case 3:
				studentManagementService.updatePerson(Utils.readString(DNI_IN));
				break;
			case 4:
				st = studentManagementService.searchPerson(Utils.readString(DNI_IN));
				if (st != null)
					st.showDetails();
				break;
			case 5:
				studentManagementService.showPersons();
				break;
			case 6:
				goBack = true;
				break;
			default:
				System.out.println(INVALID_OPT);
				break;
			}
		}

	}

}
