package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int Id;
	public String firstname;
	public String lastname;
	public String email;
	public int ph;
	public String roll;
	public UserModel() {
		super();
	}
		public UserModel(int Id, String firstname, String lastname, String email, int ph, String roll) {
		super();
		this.Id = Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ph = ph;
		this.roll = roll;
	}
		public int getId() {
			return Id;
		}
		public void setId(int Id) {
			this.Id = Id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", ph=" + ph + ", roll="
				+ roll + "]";
	}
    

}
