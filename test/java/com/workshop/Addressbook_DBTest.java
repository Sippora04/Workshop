package com.workshop;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Addressbook_DBTest {

	// UC16: Retrieve all entries from the Database
	@Test
	public void contactsWhenRetrievedFromDB_ShouldMatchCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
		Assert.assertEquals(5, contactList.size());
	}

	@Test
	public void givenNewAddressOfContact_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
		addressBookService.updateContactDetails("Sippora", "Civil Lines");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("Sippora");
		Assert.assertTrue(result);
	}

	@Test
	public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate startDate = LocalDate.of(2018, 01, 01);
		LocalDate endDate = LocalDate.now();
		List<Contacts> contactList = addressBookService.readContactDataForDateRange(startDate, endDate);
		Assert.assertEquals(5, contactList.size());
	}

	@Test
	public void givenContacts_RetrieveNumberOfContacts_ByCityOrState() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		Map<String, Integer> contactByCityMap = addressBookService.readContactByCityOrState();
		Integer count = 1;
		Assert.assertEquals(count, contactByCityMap.get("Ranchi"));
	}

	@Test
	public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate date = LocalDate.now();
		addressBookService.addContactToAddressBook("Rishpa", "Toppo", "Jam Nagar", "Bokaro", "Jharkhand", "121004",
				"998810023", "rishpa123@gmail.com", "Office Book", "colleague", date);
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("Rishpa");
		Assert.assertTrue(result);
	}

	@Test
	public void givenAddressBookMultipleData_ShouldAddToAdddressBook() {
		Contacts[] arrayOfContacts = {
				new Contacts("Shivam", "Singh", "Ashok Nagar", "Allahabad", "UP", "120022", "901999215",
						"shivam123@gmail.com", "Contact Book", "Colleague", LocalDate.now()),
				new Contacts("Farida", "Bano", "Janakpuri", "Delhi", "Delhi", "100305", "619369212",
						"faridaBano@gmail.com", "Contact Book", "friend", LocalDate.now()) };
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		Instant start = Instant.now();
		addressBookService.addEmployeeToPayrollWithThreads(Arrays.asList(arrayOfContacts));
		Instant end = Instant.now();
		System.out.println("Duration with thread: " + Duration.between(start, end));
		List<Contacts> contactList = addressBookService.readContactData();
		Assert.assertEquals(5, contactList.size());
	}
}