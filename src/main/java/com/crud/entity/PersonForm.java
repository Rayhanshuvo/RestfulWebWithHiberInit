package com.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonForm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String firstname;
	String secondname;
	public PersonForm() {
	}
	public PersonForm(int id, String firstname, String secondname) {
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

}
