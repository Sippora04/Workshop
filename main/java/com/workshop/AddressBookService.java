package com.workshop;

import java.util.List;

public class AddressBookService {

	private List<Contacts> contactList;
	private AddressBookDBService addressBookDBService;

	public AddressBookService(List<Contacts> contactList) {
		this();
		this.contactList = contactList;
	}

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public List<Contacts> readContactData() {
		this.contactList = addressBookDBService.readData();
		return contactList;
	}
}