package com.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactPerson {
	Scanner obj = new Scanner(System.in);
	
	private ArrayList<Contacts> person = new ArrayList<Contacts>();

	public void setPerson(ArrayList<Contacts> person) {
		this.person = person;
	}

	public ArrayList<Contacts> getPerson() {
		return person;
	}

	public void addPerson(Contacts pobj) {
		person.add(pobj);
	}

	public boolean isEmpty() {
		return person.isEmpty();
	}

	public ArrayList<Contacts> viewAllContacts() {
		return person;
	}

	public void Modify(String name, int info_name) {
		for (int i = 0; i < person.size(); i++) {
			Contacts p = (Contacts) person.get(i);
			if (name.equals(p.getFirst_name())) {
				System.out.println("Edit Details");
				switch (info_name) {
				case 1:
					System.out.println("Enter new First Name");
					p.setFirst_name(obj.next());
					break;
				case 2:
					System.out.println("Enter new Last Name");
					p.setLast_name(obj.next());
					break;
				case 3:
					System.out.println("Enter new Address");
					p.setAddress(obj.next());
					break;
				case 4:
					System.out.println("Enter new City");
					p.setCity(obj.next());
					break;
				case 5:
					System.out.println("Enter new State");
					p.setState(obj.next());
					break;
				case 6:
					System.out.println("Enter new Zip Code");
					p.setZip(obj.next());
					break;
				case 7:
					System.out.println("Enter new Phone Number");
					p.setPhno(obj.next());
					break;
				case 8:
					System.out.println("Enter new Email");
					p.setEmail(obj.next());
					break;
				}
			}
		}
	}

	public void remove(String name) {
		for (int i = 0; i < person.size(); i++) {
			Contacts p = (Contacts) person.get(i);
			if (name.equals(p.getFirst_name())) {
				person.remove(i);
				System.out.println("Details of " + name + " removed");
			}
		}
	}

}