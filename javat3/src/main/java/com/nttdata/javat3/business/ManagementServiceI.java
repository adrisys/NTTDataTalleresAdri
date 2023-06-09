package com.nttdata.javat3.business;

import com.nttdata.javat3.data.entities.Person;

/**
 * Interfaz que recoge los metodos que debe implementar el servicio. Se utiliza
 * un parametro generico que puede ser cualquier clase que herede de Person, en
 * nuestro caso Employee o Student.
 * 
 * @author adri
 *
 * @param <T>
 */
public interface ManagementServiceI<T extends Person> {
	/**
	 * Metodo para registrar una persona en la aplicacion
	 * 
	 * @param person
	 */
	void personReg(T person);

	/**
	 * Metodo para mostrar todas las personas registradas de la misma clase
	 */
	void showPersons();

	/**
	 * Metodo para eliminar a una persona de la aplicacion
	 * 
	 * @param dni
	 */
	void deletePerson(String dni);

	/**
	 * Metodo para actualizar los datos de una persona.
	 * 
	 * @param dni
	 */
	void updatePerson(String dni);

	/**
	 * Metodo para buscar a una persona registrada
	 * 
	 * @param dni
	 * @return
	 */
	T searchPerson(String dni);

}
