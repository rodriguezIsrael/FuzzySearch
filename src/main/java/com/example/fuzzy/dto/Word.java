package com.example.fuzzy.dto;

/**
 * 
 * Clase para busquedas
 * 
 * @author Israel Rodriguez
 *
 */
public class Word {

	/**
	 * 
	 * @param search - Palabra de busqueda
	 */
	public Word(String search) {
		super();
		this.search = search;
	}

	public Word() {
		super();
		this.search = "";
	}

	/**
	 * Valor que se desea buscar
	 */
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserSearch [");
		if (search != null) {
			builder.append("search=");
			builder.append(search);
		}
		builder.append("]");
		return builder.toString();
	}

}
