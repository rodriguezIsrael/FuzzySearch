package com.example.fuzzy.exceptions;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class CommandNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383926549802995206L;

	private static final String MSG = "Comando no encontrado.";

	public CommandNotFoundException() {
		super(MSG);
	}
}
