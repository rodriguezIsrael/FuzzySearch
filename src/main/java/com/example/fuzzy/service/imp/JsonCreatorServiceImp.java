package com.example.fuzzy.service.imp;

import java.util.List;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.dto.Word;
import com.example.fuzzy.service.JsonCreatorService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonCreatorServiceImp implements JsonCreatorService {

	@Override
	public User createStringJsonToUser(String jsonString) {
		Gson gson = new Gson();
		User user = gson.fromJson(jsonString, User.class);
		if (user.getName() == null || user.getName().equals(""))
			return null;
		return user;
	}

	@Override
	public Word createStringJsonToSearch(String jsonString) {
		Word word = null;
		try {
			Gson gson = new Gson();
			word = gson.fromJson(jsonString, Word.class);
		} catch (JsonSyntaxException e) {
			System.out.println("Json invalido");
		}
		return word;
	}

	@Override
	public String createUserToJsonString(List<User> users) {
		Gson gson = new Gson();
		return gson.toJson(users);
	}

}
