package com.example.projectDM.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectDM.entity.Login;
import com.example.projectDM.repository.LoginRepository;
import com.example.projectDM.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginRepository loginRepository;
	
	private String hashPassword(String actualPassword) {
		return BCrypt.hashpw(actualPassword, BCrypt.gensalt());
	}
	
	private boolean checkPassword(String actualPassword, String hashedPassword) {
		return BCrypt.checkpw(actualPassword, hashedPassword);
	}
	
	@Override
	public boolean validate(Login login) {
		Optional<Login> storedLogin = loginRepository.findByEmail(login.getEmail());
		if(storedLogin.isPresent() && login.getReceivedPassword() != null 
				&& login.getEmail() != null 
				&& checkPassword(login.getReceivedPassword(), storedLogin.get().getPassword())) {
			return true;
		} 
		return false;
	}
	
	@Override
	public Login retreiveLoginById(long id) {
		
		List<Login> allUsers = (List<Login>) loginRepository.findAll();
		for (Login user : allUsers) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(Login login) {
		login.setPassword(hashPassword(login.getReceivedPassword()));
		loginRepository.save(login);
	}

	

}
