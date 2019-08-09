package com.example.fuzzy.exceptions;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class InvalidAplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249708666656724925L;
	private static final String MSG = "Aplicación invalida.";

	public InvalidAplicationException() {
		super(MSG);
	}
}
