package com.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactPerson {
	Scanner obj = new Scanner(System.in);
	// Array list to store contact person details
	private ArrayList<Contacts> person = new ArrayList<Contacts>();

	public void setPerson(ArrayList<Contacts> person) {
		this.person = person;
	}

	public ArrayList<Contacts> getPerson() {
		return person;
	}

	// Method to add contact person details
	public void addPerson(Contacts pobj) {
		person.add(pobj);
	}

	// Method to check if list is empty
	public boolean isEmpty() {
		return person.isEmpty();
	}

	// Method to check all contacts available
	public ArrayList<Contacts> viewAllContacts() {
		return person;
	}
}