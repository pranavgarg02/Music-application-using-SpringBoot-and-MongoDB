package com.example.demo.credentials;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.annotation.Nonnull;

@Document(collection = "credentials")
public class UserCredentials {

	private String firstname;
	private String lastname;

	private String password;

	@Nonnull
	@Indexed(unique = true)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	@Id
	@Field(name = "contact")
	private Long contact;

	@Nonnull
	@Indexed(unique = true)
	private String email;

	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserCredentials(String firstname, String lastname, String password, @Nonnull String username, Long contact,
			String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
		this.contact = contact;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserCredentials [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", username=" + username + ", contact=" + contact + ", email=" + email + "]";
	}

}
