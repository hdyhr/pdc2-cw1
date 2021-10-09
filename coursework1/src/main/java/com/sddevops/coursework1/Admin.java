package com.sddevops.coursework1;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;

    public Admin() {
    	
    }
    public Admin(String username, String password) {
		// TODO Auto-generated constructor stub
	}

	public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
    
	

}
