package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.JPA;
import at.ac.tuwien.big.we14.lab2.api.User;

@Entity
public class SimpleUser implements User {

	public static enum Gender {
		MALE, FEMALE
	};

	@Id
	private long id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private Gender gender;
	private String username;
	private String password;	// TODO: hash
	

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
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
	
	
}
