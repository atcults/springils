package org.sanelib.ils.auth.domain;

public class UserDTO {

	private Integer libraryId;
	private String patronId;
	private Integer patronCategoryId;
	private Integer libraryPatronId;
	private Character patronType;
	private String firstName;
	private String middleName;
	private String lastName;
	private String loginId;


	public UserDTO(){}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public Integer getPatronCategoryId() {
		return patronCategoryId;
	}

	public void setPatronCategoryId(Integer patronCategoryId) {
		this.patronCategoryId = patronCategoryId;
	}

	public Integer getLibraryPatronId() {
		return libraryPatronId;
	}

	public void setLibraryPatronId(Integer libraryPatronId) {
		this.libraryPatronId = libraryPatronId;
	}

	public Character getPatronType() {
		return patronType;
	}

	public void setPatronType(Character patronType) {
		this.patronType = patronType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}
