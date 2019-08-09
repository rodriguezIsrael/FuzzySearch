package com.example.fuzzy.exceptions;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class NotRequiredJsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383926549802995206L;

	private static final String MSG = "Se igreso un JSON donde no es requerido.";

	public NotRequiredJsonException() {
		super(MSG);
	}
}
