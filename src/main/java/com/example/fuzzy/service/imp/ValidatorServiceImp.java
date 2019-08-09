package com.example.fuzzy.service.imp;

import java.lang.reflect.InvocationTargetException;

import com.example.fuzzy.dto.Operation;
import com.example.fuzzy.enums.OperationEnum;
import com.example.fuzzy.exceptions.CommandNotFoundException;
import com.example.fuzzy.exceptions.InvalidAplicationException;
import com.example.fuzzy.exceptions.InvalidJsonException;
import com.example.fuzzy.exceptions.NotRequiredJsonException;
import com.example.fuzzy.service.ValidatorService;

/**
 * 
 * @author Israel Ivan Rodriguez
 *
 */
public class ValidatorServiceImp implements ValidatorService {

	private static final String APPLICATION = "./application";
	private static final int APPLICATION_NAME_POSITION = 0;
	private static final int OPERATION_POSITION = 1;

	/**
	 * Validar comando.
	 */
	public Operation commandValidator(String command) throws InvalidAplicationException, CommandNotFoundException,
			InvalidJsonException, NotRequiredJsonException {
		Operation operation = new Operation();
		String[] parts = command.toUpperCase().split(" ");
		try {
			if (!parts[APPLICATION_NAME_POSITION].equals(APPLICATION.toUpperCase())) {
				throw new InvalidAplicationException();
			} else if (!parts[OPERATION_POSITION].equals(OperationEnum.valueOf(parts[OPERATION_POSITION]).toString())) {
				throw new CommandNotFoundException();
			}
			
		}catch(ArrayIndexOutOfBoundsException ex) {
			throw new CommandNotFoundException();
		}catch(IllegalArgumentException e){
			throw new CommandNotFoundException();
		}
		

		operation.setOperationEnum(OperationEnum.valueOf(parts[OPERATION_POSITION]));
		operation.setJson(getJson(OperationEnum.valueOf(parts[OPERATION_POSITION]), command));

		return operation;
	}

	/**
	 * Obtenemos el json en caso de que sea requerido para el comando a ejecutar
	 *
	 */
	private String getJson(OperationEnum operation, String command)
			throws InvalidJsonException, NotRequiredJsonException {
		if (isJsonRequired(operation)) {
			String json = jsonValidator(command, false);
			throwExceptionJsonNull(json);
			throwExceptionInvalidKeywordInJson(operation, command);
			return json;
		} else {
			throwExceptionNotRequeridJson(command);
			return null;

		}
	}

	/**
	 * 
	 * Validamos si se requiere lanzar excepcion cuando un json es null
	 * 
	 */
	private void throwExceptionJsonNull(String json) throws InvalidJsonException {
		if (json == null) {
			throw new InvalidJsonException();
		}
	}

	/**
	 * 
	 * Validamos si se requiere lanzar excepcion cuando se ingresa un json, y no es
	 * requerido.
	 * 
	 */
	private void throwExceptionNotRequeridJson(String command) throws NotRequiredJsonException {
		String json = jsonValidator(command, false);
		if (json != null) {
			throw new NotRequiredJsonException();
		}
	}

	/**
	 * Confirmamos si es requerido el JSON
	 * 
	 */
	private boolean isJsonRequired(OperationEnum operationEnum) {
		if (operationEnum.equals(OperationEnum.ADD)) {
			return true;
		} else if (operationEnum.equals(OperationEnum.SEARCH)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * Validamos si se requiere lanzar la excepcion de palabra invalida
	 *
	 */
	public void throwExceptionInvalidKeywordInJson(OperationEnum operation, String json) throws InvalidJsonException {
		boolean result = json.toUpperCase().contains(operation.toString());
		if (!result) {
			throw new InvalidJsonException("El json ingresado, no tiene la palabra clave " + operation);
		}

	}

	public String jsonValidator(String command, boolean showError) {
		String json = null;
		try {
			int init = command.indexOf("{");
			int end = command.indexOf("}");

			json = command.substring(init, end + 1);
		} catch (StringIndexOutOfBoundsException e) {
			if (showError)
//				e.printStackTrace();
			return null;
		} catch (Exception e) {
			if (showError)
//				e.printStackTrace();
			return null;
		}

		return json;

	}

}
