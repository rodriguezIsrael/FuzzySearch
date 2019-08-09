package com.example.fuzzy.dto;

/**
 * 
 * Usuario.
 * 
 * @author Israel Rodriguez
 *
 */
public class User {

	/**
	 * Nombre de usuario
	 */
	private String name;

	public User() {
		super();
		this.name = "";
	}

	/**
	 * 
	 * @param name - Nombre del usuario
	 */
	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
		}
		builder.append("]");
		return builder.toString();
	}

}
