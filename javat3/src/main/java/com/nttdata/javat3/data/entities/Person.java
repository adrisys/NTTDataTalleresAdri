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
	 * @param dni       el DNI de la persona
	 * @param nombre    el nombre de la persona
	 * @param apellidos los apellidos de la persona
	 */
	protected Person(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Constructor vacio
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

	/**
	 * Getter del atributo dni
	 * 
	 * @return el dni de la persona
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter del atributo dni
	 * 
	 * @param dni el nuevo dni de la persona
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Getter del atributo nombre
	 * 
	 * @return el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del atributo nombre
	 * 
	 * @param nombre el nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del atributo apellidos
	 * 
	 * @return los apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setter del atributo apellidos
	 * 
	 * @param apellidos los nuevos apellidos de la persona
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
