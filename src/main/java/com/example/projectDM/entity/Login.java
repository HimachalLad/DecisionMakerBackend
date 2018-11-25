package com.example.projectDM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="login_details")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "name", length = 50, nullable = false)
    private String name;
    
	@Column(name = "email", length = 50, nullable = false, unique=true)
    private String email;
    
    @Column(name = "password", length = 512, nullable = false)
    @JsonIgnore
    private String password;
    
    @Transient
    private String receivedPassword;
	
	public Login() {
		super();
	}

	public Login(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
    public String getReceivedPassword() {
		return receivedPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", email=" + email + "]";
	}
    
}
