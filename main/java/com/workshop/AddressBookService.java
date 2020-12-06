package com.workshop;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AddressBookService {

	private List<Contacts> contactList;
	private AddressBookDBService addressBookDBService;
	private Map<String, Integer> contactByCity;

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

	public void updateContactDetails(String name, String address) {
		int result = addressBookDBService.updateEmployeeData(name, address);
		if (result == 0)
			return;
		Contacts contact = this.getContactData(name);
		if (contact != null)
			contact.address = address;
	}

	private Contacts getContactData(String name) {
		return this.contactList.stream().filter(c -> c.first_name.equals(name)).findFirst().orElse(null);
	}

	public boolean checkConatctDetailsInSyncWithDB(String name) {
		List<Contacts> contactList = addressBookDBService.getcontactData(name);
		return contactList.get(0).equals(getContactData(name));
	}

	public List<Contacts> readContactDataForDateRange(LocalDate startDate, LocalDate endDate) {
		this.contactList = addressBookDBService.getContactForDateRange(startDate, endDate);
		return contactList;
	}

	public Map<String, Integer> readContactByCityOrState() {
		this.contactByCity = addressBookDBService.getContactByCity();
		return contactByCity;
	}
}