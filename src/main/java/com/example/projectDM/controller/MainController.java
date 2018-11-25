package com.example.projectDM.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectDM.entity.User;
import com.example.projectDM.repository.UserRepository;

@RestController
public class MainController {
	@Autowired
	public UserRepository userRepository;
	
	private static final String[] NAMES = new String[] { "Tom", "Jerry", "Donald" };
	 
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += "</ul>";
        return html;
    }
    
    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {
        int random = new Random().nextInt(3);
        User user = new User(NAMES[random]);     
        user.setPassword("pass");
        this.userRepository.save(user);
        return "Inserted: " + user;
    }
    
    
    @ResponseBody
    @RequestMapping("/showAllEmployee")
    public List<User> showAllEmployee() {
 
        List<User> users = (List<User>) this.userRepository.findAll();
        return users;
    }
}
