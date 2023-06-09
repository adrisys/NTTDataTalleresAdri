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
	 * @param dni       el DNI del empleado
	 * @param nombre    el nombre del empleado
	 * @param apellidos los apellidos del empleado
	 * @param category  la categoría del empleado
	 * @param project   el proyecto asignado al empleado
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

	/**
	 * Getter del atributo category
	 * 
	 * @return la categoría del empleado
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter del atributo category
	 * 
	 * @param category la nueva categoría del empleado
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Getter del atributo project
	 * 
	 * @return el proyecto asignado al empleado
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Setter del atributo project
	 * 
	 * @param project el nuevo proyecto asignado al empleado
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Metodo para mostrar todos los datos de un empleado.
	 */
	@Override
	public void showDetails() {
		System.out.printf("DNI: %s, Nombre: %s, Apellidos: %s, Categoría: %s, Proyecto: %s%n", dni, nombre, apellidos,
				category, project);
	}

	/**
	 * Metodo para actualizar los datos de un empleado.
	 */
	@Override
	public void updateData() {
		this.setDni(Utils.readString("Introduce el DNI"));
		this.setNombre(Utils.readString("Introduce el nombre"));
		this.setApellidos(Utils.readString("Introduce los apellidos"));
		this.setCategory(Utils.readString("Introduce la categoría"));
		this.setProject(Utils.readString("Introduce el proyecto"));
	}

}
