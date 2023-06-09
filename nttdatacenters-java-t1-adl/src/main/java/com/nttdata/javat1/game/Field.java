package com.nttdata.javat1.game;

/**
 * Clase que contiene la informacion del tablero por el que se va a mover la
 * bola de pinball.
 * 
 * author adri
 *
 */
public class Field {
	/**
	 * Atributo que contiene el valor de la altura del tablero
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
		stringBuilder.append("|                        |  |\n"); // No quiero declarar una constante para corregir el
																	// error de SonarQube porque entonces no se veria
																	// visualmente como es el tablero.
		stringBuilder.append("|              O         |  |\n");
		stringBuilder.append("|                        |  |\n");
		stringBuilder.append("|                        |  |\n");
		stringBuilder.append("|        O               |  |\n");
		stringBuilder.append("|                        |  |\n");
		stringBuilder.append("|                        |  |\n");
		stringBuilder.append("+------------------------+--+\n");
		fieldString = stringBuilder.toString();
	}

	/**
	 * Getter del atributo height
	 * 
	 * @return la altura del tablero
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter del atributo height
	 * 
	 * @param height la nueva altura del tablero
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter del atributo width
	 * 
	 * @return el ancho del tablero
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter del atributo width
	 * 
	 * @param width el nuevo ancho del tablero
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Getter del atributo fieldString
	 * 
	 * @return el String con los caracteres que forman el tablero
	 */
	public String getField() {
		return fieldString;
	}

	/**
	 * Setter del atributo fieldString
	 * 
	 * @param field el nuevo String con los caracteres que forman el tablero
	 */
	public void setField(String field) {
		this.fieldString = field;
	}

}
