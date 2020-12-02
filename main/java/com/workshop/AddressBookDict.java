package com.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AddressBookDict {
	Scanner obj = new Scanner(System.in);

	private TreeMap<String, ContactPerson> addressBook = new TreeMap<String, ContactPerson>();

	public TreeMap<String, ContactPerson> getAddressBookDict() {
		return addressBook;
	}

	public void setAddressBookDict(TreeMap<String, ContactPerson> addressBook) {
		this.addressBook = addressBook;
	}

	public void addAddressBook(String AddressBookName, ContactPerson obj) {
		addressBook.put(AddressBookName, obj);
	}

	public void viewAddressBook() {
		if (addressBook.isEmpty()) {
			System.out.println("addressbook is empty");
		}
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet())
			System.out.println("[" + entry.getKey() + ", " + entry.getValue().viewAllContacts() + "]");
	}

	public void searchAddressBookByCity() {
		if (addressBook.isEmpty()) {
			System.out.println("addressbook is empty");
		}
		System.out.println("Enter the city name: ");
		String cityName = obj.next();
		List<Contacts> personByCity = new ArrayList<Contacts>();
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			personByCity = (entry.getValue().getPerson().stream().filter(c -> c.getCity().equals(cityName)))
					.collect(Collectors.toList());
			System.out.println(personByCity);
		}
	}

	public void searchAddressBookByState() {
		if (addressBook.isEmpty()) {
			System.out.println("addressbook is empty");
		}
		System.out.println("Enter the state name: ");
		String stateName = obj.next();
		List<Contacts> personByState = new ArrayList<Contacts>();
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			personByState = (entry.getValue().getPerson().stream().filter(c -> c.getState().equals(stateName)))
					.collect(Collectors.toList());
			System.out.println(personByState);
		}
	}

}