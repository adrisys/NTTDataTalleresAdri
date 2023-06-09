package com.nttdata.javat3.data.entities;

import utils.Utils;

/**
 * Clase que representa a un estudiante
 * 
 * @author adri
 *
 */
public class Student extends Person {
	/**
	 * Centro educativo en el que estudia el estudiante.
	 */
	private String center;

	public enum Course {
		DAM, DAW
	}

	/**
	 * Curso en el que esta matriculado el alumno
	 */
	private Course course;

	/**
	 * Constructor con parametros
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param center
	 * @param course
	 */
	public Student(String dni, String nombre, String apellidos, String center, String course) {
		super(dni, nombre, apellidos);
		this.center = center;
		this.course = Course.valueOf(course);
	}

	/**
	 * Constructor vacio
	 */
	public Student() {

	}

	/**
	 * Metodo para mostrar los datos del estudiante.
	 */
	@Override
	public void showDetails() {
		System.out.printf("DNI: %s, Nombre: %s, Apellidos: %s, Centro Educativo: %s, Modalidad: %s%n", dni, nombre,
				apellidos, center, course.toString());
	}

	/**
	 * Metodo para actualizar los datos del estudiante
	 */
	@Override
	public void updateData() {
		this.setDni(Utils.readString("Introduce el dni"));
		this.setNombre(Utils.readString("Introduce el nombre"));
		this.setApellidos(Utils.readString("Introduce los apellidos"));
		this.setCenter(Utils.readString("Introduce el centro educativo"));
		this.setCourse(Utils.readCourse());
	}

//Getters y setters
	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
