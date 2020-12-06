package com.example.demo.models;

import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class PersonalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] imageContent;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	@NotBlank
	private String firstname;

	@NotBlank
	private String lastname;

	public byte[] getImageContent() {
		return imageContent;
	}

	public String getImageBase64() {
		return Base64.getEncoder().encodeToString(imageContent);
	}

	public void setImage(MultipartFile image) throws IOException {
		this.imageContent = image.getBytes();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return String.format("%s %s", this.firstname, this.lastname);
	}
}
