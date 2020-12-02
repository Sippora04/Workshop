package com.workshop;

public class Contacts {
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone_no;
	private String email;

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

	@Override
	public String toString() {
		return ("First Name : " + first_name + " Last Name " + last_name + "\t" + "Address : " + address + "\t"
				+ "City : " + city + "\t" + "State : " + state + "\t" + "Zip : " + zip + "\t" + "Phone Number : "
				+ phone_no + "\t" + "Email : " + email);
	}
}