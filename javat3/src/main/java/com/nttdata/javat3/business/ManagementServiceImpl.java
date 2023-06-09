package com.nttdata.javat3.business;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.javat3.data.entities.Person;

/**
 * Clase que contiene la implementacion de los procesos que maneja el servicio
 * principal que gestiona la funcionalidad de la aplicacion
 * 
 * @author adri
 *
 * @param <T> Clase que hereda de Person
 */
public class ManagementServiceImpl<T extends Person> implements ManagementServiceI<T> {
	/**
	 * Lista que contiene a las persoans de una misma clase
	 */
	private List<T> list;

	/**
	 * Constructor unico que inicializa la lista
	 */
	public ManagementServiceImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void personReg(T persona) {
		list.add(persona);
	}

	@Override
	public void showPersons() {
		for (T persona : list) {
			persona.showDetails();
			System.out.println();
		}
	}

	@Override
	public void deletePerson(String dni) {
		T personToRemove = null;
		for (T person : list) {
			if (person.getDni().equals(dni)) {
				personToRemove = person;
				break;
			}
		}
		if (personToRemove != null)
			list.remove(personToRemove);
	}

	@Override
	public void updatePerson(String dni) {
		T person = searchPerson(dni);
		if (person != null)
			person.updateData();
	}

	@Override
	public T searchPerson(String dni) {
		for (T person : list) {
			if (person.getDni().equals(dni))
				return person;
		}
		return null;
	}

}
