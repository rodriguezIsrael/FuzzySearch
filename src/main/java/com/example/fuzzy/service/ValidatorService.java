package com.example.fuzzy.service;

import com.example.fuzzy.dto.Operation;
import com.example.fuzzy.exceptions.CommandNotFoundException;
import com.example.fuzzy.exceptions.InvalidAplicationException;
import com.example.fuzzy.exceptions.InvalidJsonException;
import com.example.fuzzy.exceptions.NotRequiredJsonException;

public interface ValidatorService {

	public Operation commandValidator(String command)
			throws InvalidAplicationException, CommandNotFoundException, InvalidJsonException, NotRequiredJsonException;
	

}
