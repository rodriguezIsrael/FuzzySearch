package com.example.fuzzy.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.service.imp.ListServiceImp;

public class ListServiceTest {

	ListService listService = new ListServiceImp();

	@Test
	public void listOk() {

		List<User> users = listService.list();

		Assert.assertTrue(users.size() > 0);
	}
}
