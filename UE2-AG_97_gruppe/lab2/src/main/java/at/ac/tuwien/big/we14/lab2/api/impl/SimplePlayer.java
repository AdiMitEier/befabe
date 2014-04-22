package at.ac.tuwien.big.we14.lab2.api.impl;

import at.ac.tuwien.big.we14.lab2.api.Player;

public class SimplePlayer implements Player {
	
	private String firstname;
	private String lastname;
	
	public SimplePlayer(){
		this.firstname="";
		this.lastname="";
	}
	
	public SimplePlayer(String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
