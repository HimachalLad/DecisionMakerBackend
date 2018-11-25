package com.example.projectDM.service;

import com.example.projectDM.entity.Login;

public interface LoginService {
	
	public boolean validate(Login login);
	
	public Object retreiveLoginById(long id);

	public void saveUser(Login login);
}
