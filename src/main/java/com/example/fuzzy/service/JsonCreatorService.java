package com.example.fuzzy.service;

import java.util.List;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.dto.Word;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public interface JsonCreatorService {

	public User createStringJsonToUser(String jsonString);

	public String createUserToJsonString(List<User> users);

	public Word createStringJsonToSearch(String jsonString);

}
