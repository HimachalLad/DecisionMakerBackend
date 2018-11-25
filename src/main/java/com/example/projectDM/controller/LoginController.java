package com.example.projectDM.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.projectDM.entity.Login;
import com.example.projectDM.repository.LoginRepository;
import com.example.projectDM.serviceImpl.LoginServiceImpl;
	
@RestController
public class LoginController {
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@GetMapping("/getAllUsers")
	public List<Login> getAllDetails() {	
		List<Login> details = (List<Login>) loginRepository.findAll();
		return details;
	}
	
	@GetMapping("/getUser/{id}")
	public Login getLoginDetailsForId(@PathVariable int id) {
		return loginService.retreiveLoginById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Login login) {
		if(loginService.validate(login)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	@PostMapping("/addNewUser")
	public ResponseEntity<String> addNewUser(@RequestBody Login login) {
		loginService.saveUser(login);
        return ResponseEntity.status(HttpStatus.CREATED).build();       
    }
}
