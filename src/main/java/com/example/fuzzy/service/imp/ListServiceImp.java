package com.example.fuzzy.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.service.ListService;
import com.example.fuzzy.utils.WriteReadFileUtil;

public class ListServiceImp implements ListService {

	public List<User> list() {
		List<String> names = WriteReadFileUtil.read();
		List<User> users = new ArrayList<>();
		for (String tmp : names) {
			if (!tmp.equals("") || !tmp.equals("\r\n")) {
				users.add(new User(tmp));
			}
		}

		return users;
	}

}
