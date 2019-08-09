package com.example.fuzzy.facade;

import java.util.List;

import com.example.fuzzy.dto.Operation;
import com.example.fuzzy.dto.User;
import com.example.fuzzy.dto.Word;
import com.example.fuzzy.exceptions.CommandNotFoundException;
import com.example.fuzzy.exceptions.InvalidAplicationException;
import com.example.fuzzy.exceptions.InvalidJsonException;
import com.example.fuzzy.exceptions.NotRequiredJsonException;
import com.example.fuzzy.service.AddService;
import com.example.fuzzy.service.JsonCreatorService;
import com.example.fuzzy.service.ListService;
import com.example.fuzzy.service.SearchService;
import com.example.fuzzy.service.ValidatorService;
import com.example.fuzzy.service.imp.AddServiceImp;
import com.example.fuzzy.service.imp.JsonCreatorServiceImp;
import com.example.fuzzy.service.imp.ListServiceImp;
import com.example.fuzzy.service.imp.SearchServiceImp;
import com.example.fuzzy.service.imp.ValidatorServiceImp;

/**
 * 
 * @author Israel Ivan Rodriguez
 *
 */
public class CMDFacade {

	private AddService addService = new AddServiceImp();
	private ListService listService = new ListServiceImp();
	private SearchService searchService = new SearchServiceImp();
	private ValidatorService validatorService = new ValidatorServiceImp();
	private JsonCreatorService jsonCreatorService = new JsonCreatorServiceImp();

	/**
	 * 
	 * Se ejecuta comando
	 * 
	 */
	public void exec(String command) {

		try {
			Operation operation = validatorService.commandValidator(command);
			selector(operation);
		} catch (InvalidAplicationException e) {
			System.out.println(e.getMessage());
		} catch (CommandNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidJsonException e) {
			System.out.println(e.getMessage());
		} catch (NotRequiredJsonException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Seleccionar tipo de comando (Se podria utilizar polimorfismo)
	 * 
	 */
	private void selector(Operation operation) {
		switch (operation.getOperationEnum()) {
		case ADD:
			User user = jsonCreatorService.createStringJsonToUser(operation.getJson());
			if (user != null) {
				boolean result = addService.add(user);
				showInfoAdd(result);
			}else {
				System.out.println("Información invalida, Intenta de nuevo");
			}

			break;
		case LIST:
			List<User> users = listService.list();
			String usersJson = jsonCreatorService.createUserToJsonString(users);
			System.out.println(usersJson);
			break;
		case SEARCH:
			Word word = jsonCreatorService.createStringJsonToSearch(operation.getJson());
			if (word != null) {
				List<User> usersFound = searchService.search(word);
				String usersFoundJson = jsonCreatorService.createUserToJsonString(usersFound);
				System.out.println(usersFoundJson);
			}

			break;

		default:
			break;
		}
	}

	private void showInfoAdd(boolean result) {
		if (result) {
			System.out.println("Usuario agregado");
		} else {
			System.out.println("A ocurrido un error.");
		}
	}

}
