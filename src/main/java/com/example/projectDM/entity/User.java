package com.example.projectDM.entity;

import javax.persistence.*;
 
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;
    
    @Column(name = "PASSWORD", length = 50, nullable = false)
    private String password;
    
    public User() {
		super();
	}

	public User(String email) {
		super();
		this.email = email;
	}
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
}