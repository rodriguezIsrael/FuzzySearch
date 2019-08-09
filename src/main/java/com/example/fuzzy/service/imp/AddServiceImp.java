package com.example.fuzzy.service.imp;

import com.example.fuzzy.dto.User;
import com.example.fuzzy.service.AddService;
import com.example.fuzzy.utils.WriteReadFileUtil;

public class AddServiceImp implements AddService {

	public boolean add(User user) {
		return WriteReadFileUtil.write(user.getName());
	}

}
