package com.example.fuzzy.exceptions;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class InvalidJsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249708666656724925L;
	private static final String MSG = "[Json invalido.]";

	public InvalidJsonException() {
		super(MSG);
	}

	public InvalidJsonException(String msg) {
		super(MSG + msg);
	}
}
