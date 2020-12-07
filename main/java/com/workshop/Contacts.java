package com.workshop;

import java.time.LocalDate;
import java.util.Objects;

public class Contacts {

	public String first_name;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone_no;
	public String email;
	public String addressBookName;
	public String addressBookType;
	public LocalDate date;
	public int id;

	public Contacts(String first_name, String last_name, String address, String city, String state, String zip,
			String phone_no, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_no = phone_no;
		this.email = email;
	}

	public Contacts(String first_name, String last_name, String address, String city, String state, String zip,
			String phone_no, String email, String addressBookName, String addressBookType) {
		this(first_name, last_name, address, city, state, zip, phone_no, email);
		this.addressBookName = addressBookName;
		this.addressBookType = addressBookType;
	}

	public Contacts(String first_name, String last_name, String address, String city, String state, String zip,
			String phone_no, String email, String addressBookName, String addressBookType, LocalDate date) {
		this(first_name, last_name, address, city, state, zip, phone_no, email, addressBookName, addressBookType);
		this.date = date;
	}

	public Contacts(int id, String first_name, String last_name, String address, String city, String state, String zip,
			String phone_no, String email, String addressBookName, String addressBookType, LocalDate date) {
		this(first_name, last_name, address, city, state, zip, phone_no, email, addressBookName, addressBookType);
		this.date = date;
		this.id = id;
	}

	public Contacts() {
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhno() {
		return phone_no;
	}

	public void setPhno(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "First Name: " + this.first_name + " Last Name: " + this.last_name + " Address: " + this.address
				+ " City: " + this.city + " State: " + this.state + " Zip: " + this.zip + " Phone Number: "
				+ this.phone_no + " Email: " + this.email + " Address book name" + this.addressBookName + " type"
				+ addressBookType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first_name, last_name, address, city, state, zip, phone_no, email, addressBookName, date);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Contacts that = (Contacts) o;
		return first_name.equals(that.first_name) && address.equals(that.address);
	}
}