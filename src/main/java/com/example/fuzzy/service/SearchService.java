package com.example.fuzzy.service;

import java.util.List;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.dto.Word;

public interface SearchService {


	public List<User> search(Word wordsToSearch);
}
