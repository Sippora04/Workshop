package com.workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookService {

	private List<Contacts> contactList;
	private AddressBookDBService addressBookDBService;
	private AddressBookDBServiceNew addressBookDBServiceNew;
	private Map<String, Integer> contactByCity;

	public AddressBookService(List<Contacts> contactList) {
		this();
		this.contactList = new ArrayList<>(contactList);
	}

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
		addressBookDBServiceNew = AddressBookDBServiceNew.getInstance();
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

	public void addContactToAddressBook(String firstName, String lastName, String address, String city, String state,
			String zip, String phoneNumber, String email, String addressBookName, String addressBookType,
			LocalDate date) {
		contactList.add(addressBookDBServiceNew.addContact(firstName, lastName, address, city, state, zip, phoneNumber,
				email, addressBookName, addressBookType, date));
	}

	public void addEmployeeToPayrollWithThreads(List<Contacts> contactList) {
		Map<Integer, Boolean> employeeAdditionStatus = new HashMap<>();
		contactList.forEach(contact -> {
			Runnable task = () -> {
				employeeAdditionStatus.put(contact.hashCode(), false);
				System.out.println("Contact being added : " + Thread.currentThread().getName());
				this.addContactToAddressBook(contact.first_name, contact.last_name, contact.address, contact.city,
						contact.state, contact.zip, contact.phone_no, contact.email, contact.addressBookName,
						contact.addressBookType, contact.date);
				employeeAdditionStatus.put(contact.hashCode(), true);
				System.out.println("Contact added: " + Thread.currentThread().getName());
			};
			Thread thread = new Thread(task, contact.first_name);
			thread.start();
		});
		while (employeeAdditionStatus.containsValue(false)) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("" + this.contactList);
	}

	public void addContactToAddressBook(Contacts personInfo) {
		// TODO Auto-generated method stub
		contactList.add(personInfo);
	}

	public long countEntries() {
		// TODO Auto-generated method stub
		return contactList.size();
	}
}