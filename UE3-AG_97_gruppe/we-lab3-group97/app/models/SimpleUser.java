package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import at.ac.tuwien.big.we14.lab2.api.User;

@Entity
public class SimpleUser implements User {

	public static enum Gender {
		MALE, FEMALE
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private Gender gender;
	@MinLength(value = 4)
	@MaxLength(value = 8)
	@Required
	@Column(unique = true)
	private String username;
	@MinLength(value = 4)
	@MaxLength(value = 8)
	@Required
	private String password; // TODO: hash

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


	public static SimpleUser authenticateUser(String userName, String password) {
		// return user if username and password is matching, null otherwise
		Query query = JPA
				.em()
				.createQuery(
						"SELECT u FROM SimpleUser u WHERE u.username = :username AND u.password = :password");
		query.setParameter("username", userName);
		query.setParameter("password", password);
		query.setMaxResults(1);
		List<SimpleUser> users = query.getResultList();
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}

	}

}
