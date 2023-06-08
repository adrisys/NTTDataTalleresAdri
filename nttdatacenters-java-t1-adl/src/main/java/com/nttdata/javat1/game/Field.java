package com.nttdata.javat1.game;

/**
 * Clase que contiene la información del tablero por el que se va a move la bola
 * de pinball.
 * 
 * @author adri
 *
 */
public class Field {
	/**
	 * Atributo que contiene el valor la altura del tablero
	 */
	private int height;
	/**
	 * Atributo que contiene el valor del ancho del tablero
	 */
	private int width;
	/**
	 * Atributo que contiene el String con los caracteres que forman el tablero
	 */
	private String fieldString;

	/**
	 * Constructor que genera un tablero determinado, actualmente no se puede
	 * utilizar otro
	 */
	public Field() {
		this.height = 21;
		this.width = 29;
		StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+---------------------------+\n");
        stringBuilder.append("|                           |\n");
        stringBuilder.append("|  /                     \\  |\n");
        stringBuilder.append("| /                       \\ |\n");
        stringBuilder.append("|/                         \\|\n");
        stringBuilder.append("|         @@@@@@@        |  |\n");
        stringBuilder.append("|        @@@@@@@@@       |  |\n");
        stringBuilder.append("|       ★@@@@@@@@@@      |  |\n");
        stringBuilder.append("|        @@@@@@@@@       |  |\n");
        stringBuilder.append("|         @@@@@@@        |  |\n");
        stringBuilder.append("|       \\                |  |\n");
        stringBuilder.append("| O      \\               |  |\n");
        stringBuilder.append("|         \\              |  |\n");
        stringBuilder.append("|                        |  |\n"); //No quiero declarar una constante para corregir el error de sonar porque entonces no se vería visualmente como es el tablero.
        stringBuilder.append("|              O         |  |\n");
        stringBuilder.append("|                        |  |\n");
        stringBuilder.append("|                        |  |\n");
        stringBuilder.append("|        O               |  |\n");
        stringBuilder.append("|                        |  |\n");
        stringBuilder.append("|                        |  |\n");
        stringBuilder.append("+------------------------+--+\n");
		fieldString = stringBuilder.toString();
	}

//Getters y setters 
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getField() {
		return fieldString;
	}

	public void setField(String field) {
		this.fieldString = field;
	}

}
