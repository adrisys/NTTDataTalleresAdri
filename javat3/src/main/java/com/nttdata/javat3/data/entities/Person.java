package com.nttdata.javat3.data.entities;

/**
 * Clase abstracta que recoge la informacion y procesos comunes a todas las
 * personas
 * 
 * @author adri
 *
 */
public abstract class Person {
	/**
	 * Dni de la persona
	 */
	protected String dni;
	/**
	 * Nombre de la persona
	 */
	protected String nombre;
	/**
	 * Apellidos de la persona
	 */
	protected String apellidos;

	/**
	 * Constructor con parametros
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 */
	protected Person(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Constructor vac�o
	 */
	protected Person() {

	}

	/**
	 * Metodo para mostrar los datos de una persona
	 */
	public abstract void showDetails();

	/**
	 * Metodo para actualizar los datos de una persona
	 */
	public abstract void updateData();

//Setters y getters 
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
