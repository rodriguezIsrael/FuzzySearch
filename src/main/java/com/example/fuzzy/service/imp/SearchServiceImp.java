package com.example.fuzzy.service.imp;

import static org.simmetrics.builders.StringDistanceBuilder.with;

import java.util.ArrayList;
import java.util.List;

import org.simmetrics.StringDistance;
import org.simmetrics.metrics.EuclideanDistance;
import org.simmetrics.tokenizers.Tokenizers;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.dto.Word;
import com.example.fuzzy.service.ListService;
import com.example.fuzzy.service.SearchService;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class SearchServiceImp implements SearchService {

	/**
	 * Minima distancia de exactitud para tomar en cuenta un usuario en la busqueda
	 */
	private static final Double MIN_DISTANCE = .5D;
	/**
	 * Minima distancia de exactitud para tomar en cuenta un usuario en la busqueda
	 */
	private static final Double MAX_DISTANCE = 3D;

	/**
	 * Se inicia busqueda
	 */
	public List<User> search(Word wordToSearch) {
		System.out.println("Palabras con las que buscare: " + wordToSearch.getSearch());
		List<User> usersFound = seachUser(getAll(), wordToSearch);
		return usersFound;
	}

	/**
	 * 
	 * Se buscan coincidencias en los usuarios acorde a las palabras a buscar
	 */
	private List<User> seachUser(List<User> allUsers, Word wordToSearch) {
		List<User> usersFound = new ArrayList<>();
		for (User user : allUsers) {
			if (getUserFound(wordToSearch, user.getName()) != null) {
				usersFound.add(user);
			}

		}
		return usersFound;
	}

	/**
	 * 
	 * Obtenemos los usuarios que tienen coincidencias, se separan para poder
	 * realizar una busqueda por partes.
	 */
	private String getUserFound(Word wordToSearch, String user) {

		String[] partsUser = user.split(" ");
		String[] partsSearch = wordToSearch.getSearch().split(" ");

		for (int i = 0; i < partsSearch.length; i++) {
			double metric = iterate(partsUser, partsSearch[i]);
			if (metric < MAX_DISTANCE) {
				return user;
			}
		}

		return null;

	}

	/**
	 * Realizamos una busqueda uno a uno, para encontrar coincidencias en los
	 * usuarios.
	 */
	private double iterate(String[] parts, String search) {
		double distance = 0D;
		if (!search.equals(" ")) {
			StringDistance metric = with(new EuclideanDistance<String>()).tokenize(Tokenizers.whitespace())
					.tokenize(Tokenizers.qGram(2)).build();

			for (int i = 0; i < parts.length; i++) {
				double size = parts[i].length();
				size = (search.length() < size) ? MAX_DISTANCE : MIN_DISTANCE;
				distance = metric.distance(parts[i], search);
				if (distance <= size && parts[i].toUpperCase().contains(search.toUpperCase())) {
					return distance;
				}

			}
		}
		return MAX_DISTANCE;
	}

	private List<User> getAll() {
		ListService listService = new ListServiceImp();
		return listService.list();
	}

}
