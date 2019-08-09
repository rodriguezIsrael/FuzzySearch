package com.example.fuzzy.service;

import org.junit.Assert;
import org.junit.Test;

import com.example.fuzzy.dto.Operation;
import com.example.fuzzy.enums.OperationEnum;
import com.example.fuzzy.exceptions.CommandNotFoundException;
import com.example.fuzzy.exceptions.InvalidAplicationException;
import com.example.fuzzy.exceptions.InvalidJsonException;
import com.example.fuzzy.exceptions.NotRequiredJsonException;
import com.example.fuzzy.service.imp.ValidatorServiceImp;

public class ValidatorServiceTest {

	ValidatorService validatorService = new ValidatorServiceImp();

	@Test
	public void validatorAddValid() {

		Operation operation = null;
		Exception exceptio = null;
		try {
			operation = validatorService.commandValidator("./application add {\"name\":\"Juan Antonio Perez\"}");
			Assert.assertTrue(operation != null);
			Assert.assertTrue(operation.getOperationEnum().equals(OperationEnum.ADD));
			System.out.println(operation.toString());
		} catch (InvalidAplicationException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (CommandNotFoundException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (InvalidJsonException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (NotRequiredJsonException e) {
			exceptio = e;
			e.printStackTrace();
		}
		Assert.assertTrue(exceptio == null);

	}
	
	@Test
	public void validatorListValid() {

		Operation operation = null;
		Exception exceptio = null;
		try {
			operation = validatorService.commandValidator("./application list");
			Assert.assertTrue(operation != null);
			Assert.assertTrue(operation.getOperationEnum().equals(OperationEnum.LIST));
			System.out.println(operation.toString());
		} catch (InvalidAplicationException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (CommandNotFoundException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (InvalidJsonException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (NotRequiredJsonException e) {
			exceptio = e;
			e.printStackTrace();
		}
		Assert.assertTrue(exceptio == null);

	}
	
	@Test
	public void validatorSearchValid() {

		Operation operation = null;
		Exception exceptio = null;
		try {
			operation = validatorService.commandValidator("./application search {\"name\":\"Juan Antonio Perez\"}");
			Assert.assertTrue(operation != null);
			Assert.assertTrue(operation.getOperationEnum().equals(OperationEnum.SEARCH));
			System.out.println(operation.toString());
		} catch (InvalidAplicationException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (CommandNotFoundException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (InvalidJsonException e) {
			e.printStackTrace();
			exceptio = e;
		} catch (NotRequiredJsonException e) {
			exceptio = e;
			e.printStackTrace();
		}
		Assert.assertTrue(exceptio == null);

	}



}
