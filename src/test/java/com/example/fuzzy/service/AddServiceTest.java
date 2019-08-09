package com.example.fuzzy.service;

import org.junit.Assert;
import org.junit.Test;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.service.imp.AddServiceImp;

public class AddServiceTest {

	AddService addService = new AddServiceImp();
	
	@Test
	public void addOK() {
	
		User userOne = new User();
		userOne.setName("Israel Ivan Rodriguez Espinoza");
		User userTwo = new User();
		userTwo.setName("Sandra Alejo Antonio");
		User userThree = new User();
		userThree.setName("Veronica Sanchez Bautista");
		User userFour = new User();
		userFour.setName("Diego Rodriguez Sanchez");
		Assert.assertTrue(addService.add(userOne));
		Assert.assertTrue(addService.add(userTwo));
		Assert.assertTrue(addService.add(userThree));
		Assert.assertTrue(addService.add(userFour));
		
	}
}
