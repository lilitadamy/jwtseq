package com.demo.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class JwtRequest implements Serializable {

	private String username;
	private String password;
	
	public JwtRequest() {}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
