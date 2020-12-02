package com.workshop;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");
		Scanner obj = new Scanner(System.in);

		ContactPerson add = new ContactPerson();
		int ch = 0;

		System.out.println("Enter Contacts add details");

		Contacts p = new Contacts();
		System.out.println("Enter First Name");
		p.setFirst_name(obj.next());
		System.out.println("Enter Last Name");
		p.setLast_name(obj.next());
		System.out.println("Enter Address");
		p.setAddress(obj.next());
		System.out.println("Enter City");
		p.setCity(obj.next());
		System.out.println("Enter State");
		p.setState(obj.next());
		System.out.println("Enter Zip Code");
		p.setZip(obj.next());
		System.out.println("Enter Phone Number");
		p.setPhno(obj.next());
		System.out.println("Enter Email");
		p.setEmail(obj.next());
		add.addPerson(p);
	}
}
