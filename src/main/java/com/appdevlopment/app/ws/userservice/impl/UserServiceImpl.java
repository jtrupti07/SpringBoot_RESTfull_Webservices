package com.appdevlopment.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdevlopment.app.ws.shared.Utils;
import com.appdevlopment.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdevlopment.app.ws.ui.model.responce.UserRest;
import com.appdevlopment.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	Map<String, UserRest> users;
	Utils utils;

	public UserServiceImpl() {}

	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setPassword(userDetails.getPassword());

		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);
		return returnValue;
	}

}
