package com.workshop;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AddressBookDict {

	Scanner obj = new Scanner(System.in);

	private TreeMap<String, ArrayList<Contacts>> addressBook = new TreeMap<String, ArrayList<Contacts>>();

	public TreeMap<String, ArrayList<Contacts>> getAddressBookDict() {
		return addressBook;
	}

	public void setAddressBookDict(TreeMap<String, ArrayList<Contacts>> addressBook) {
		this.addressBook = addressBook;
	}

	public void addAddressBook(String AddressBookName) {
		addressBook.put(AddressBookName, new ArrayList<Contacts>());
	}

	public void viewAddressBook() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		for (Entry<String, ArrayList<Contacts>> entry : addressBook.entrySet())
			System.out.println("[" + entry.getKey() + ", " + entry.getValue() + "]");
	}

	public void searchAddressBookByCity() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		System.out.println("Enter the city name");
		String cityName = obj.next();
		List<Contacts> personByCity = new ArrayList<Contacts>();
		for (Entry<String, ArrayList<Contacts>> entry : addressBook.entrySet()) {
			personByCity = (entry.getValue().stream().filter(Contacts -> Contacts.getCity().equals(cityName)))
					.collect(Collectors.toList());
			System.out.println(personByCity);
		}
	}

	public ArrayList<Contacts> getContactList(String addressBookName) {
		return addressBook.get(addressBookName);
	}

	public void searchAddressBookByState() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		System.out.println("Enter the state name");
		String stateName = obj.next();
		List<Contacts> personByState = new ArrayList<Contacts>();
		for (Entry<String, ArrayList<Contacts>> entry : addressBook.entrySet()) {
			personByState = (entry.getValue().stream().filter(Contacts -> Contacts.getState().equals(stateName)))
					.collect(Collectors.toList());
			System.out.println(personByState);
		}
	}

	public boolean addContact(String addressBookName, Contacts p) {
		if (addressBook.containsKey(addressBookName)) {
			Contacts check = addressBook.get(addressBookName).stream().filter(con -> p.equals(con)).findAny()
					.orElse(null);
			if (check == null) {
				addressBook.get(addressBookName).add(p);
				return true;
			} else {
				return false;
			}
		} else {
			addAddressBook(addressBookName);
			addressBook.get(addressBookName).add(p);
			return true;
		}
	}

	public Contacts getContactByName(String addressBookName, String name) {
		Contacts p = null;
		if (addressBook.containsKey(addressBookName)) {
			p = addressBook.get(addressBookName).stream().filter(con -> (con.getFirst_name()).equals(name)).findAny()
					.orElse(null);
		}
		return p;
	}

	public void removeContact(String addressBookName, Contacts p) {
		addressBook.get(addressBookName).remove(p);
	}
}