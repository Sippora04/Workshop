package com.workshop;

import java.util.TreeMap;

public class AddressBookDict {

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
}