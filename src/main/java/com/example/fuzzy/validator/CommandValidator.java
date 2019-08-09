package com.example.fuzzy.validator;

import com.example.fuzzy.enums.OperationEnum;
import com.example.fuzzy.exceptions.CommandNotFoundException;
import com.example.fuzzy.exceptions.InvalidAplicationException;

/**
 * 
 * @author Israel Rodriguez
 *
 */
public class CommandValidator {

	private static final String APPLICATION = "./application";
	private static final int APPLICATION_NAME_POSITION = 0;
	private static final int OPERATION_POSITION = 1;

	public void validateCommand(String command) throws CommandNotFoundException, InvalidAplicationException {

		String[] parts = command.split("-");

		if (!parts[APPLICATION_NAME_POSITION].equals(APPLICATION)) {
			throw new InvalidAplicationException();
		} else if (!parts[OPERATION_POSITION].equals(OperationEnum.valueOf(parts[OPERATION_POSITION]))) {
			throw new CommandNotFoundException();
		}
	}

}
