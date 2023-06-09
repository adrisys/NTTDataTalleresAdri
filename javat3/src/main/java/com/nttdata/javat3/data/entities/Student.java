package com.nttdata.javat3.data.entities;

import utils.Utils;

/**
 * Clase que representa a un estudiante
 * 
 * author adri
 *
 */
public class Student extends Person {
	/**
	 * Centro educativo en el que estudia el estudiante.
	 */
	private String center;

	/**
	 * Tipos de curso
	 * 
	 * @author adri
	 *
	 */
	public enum Course {
		/**
		 * Desarrollo de aplicaciones multiplataforma
		 */
		DAM,
		/**
		 * Desarrollo de aplicaciones web
		 */
		DAW
	}

	/**
	 * Curso en el que esta matriculado el alumno
	 */
	private Course course;

	/**
	 * Constructor con parametros
	 * 
	 * @param dni       el DNI del estudiante
	 * @param nombre    el nombre del estudiante
	 * @param apellidos los apellidos del estudiante
	 * @param center    el centro educativo en el que estudia el estudiante
	 * @param course    el curso en el que está matriculado el estudiante
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
	 * Getter del atributo center
	 * 
	 * @return el centro educativo en el que estudia el estudiante
	 */
	public String getCenter() {
		return center;
	}

	/**
	 * Setter del atributo center
	 * 
	 * @param center el nuevo centro educativo en el que estudia el estudiante
	 */
	public void setCenter(String center) {
		this.center = center;
	}

	/**
	 * Getter del atributo course
	 * 
	 * @return el curso en el que está matriculado el estudiante
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Setter del atributo course
	 * 
	 * @param course el nuevo curso en el que está matriculado el estudiante
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	 * Metodo para actualizar los datos del estudiante.
	 */
	@Override
	public void updateData() {
		this.setDni(Utils.readString("Introduce el DNI"));
		this.setNombre(Utils.readString("Introduce el nombre"));
		this.setApellidos(Utils.readString("Introduce los apellidos"));
		this.setCenter(Utils.readString("Introduce el centro educativo"));
		this.setCourse(Utils.readCourse());
	}

}
