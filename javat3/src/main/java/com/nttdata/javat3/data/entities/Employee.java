package com.nttdata.javat3.data.entities;

import utils.Utils;

/**
 * Clase que representa a un empleado
 * 
 * @author adri
 *
 */
public class Employee extends Person {
	/**
	 * Categoria del empleado
	 */
	private String category;
	/**
	 * Proyecto asignado al empleado
	 */
	private String project;

	/**
	 * Constructor con parametros
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param category
	 * @param project
	 */
	public Employee(String dni, String nombre, String apellidos, String category, String project) {
		super(dni, nombre, apellidos);
		this.category = category;
		this.project = project;
	}

	/**
	 * Constructor vacio
	 */
	public Employee() {

	}

//Getters y setters
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Metodo para mostrar todos los datos de un empleado.
	 */
	@Override
	public void showDetails() {
		System.out.printf("DNI: %s, Nombre: %s, Apellidos: %s, Categor�a: %s, Proyecto: %s%n", dni, nombre, apellidos,
				category, project);
	}

	/**
	 * Metodo para actualizar los datos de un empleado.
	 */
	@Override
	public void updateData() {
		this.setDni(Utils.readString("Introduce el dni"));
		this.setNombre(Utils.readString("Introduce el nombre"));
		this.setApellidos(Utils.readString("Introduce los apellidos"));
		this.setCategory(Utils.readString("Introduce la categor�a"));
		this.setProject(Utils.readString("Introduce el proyecto"));
	}

}
