package com.workshop;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.workshop.ContactPerson.IOService;

public class AddressBookTest {

	@Test
	public void givenAddressBookWhenWrittenToFileShouldMatchEnteries() throws IOException {
		ArrayList<Contacts> person = new ArrayList<>();
		person.add(new Contacts("Sippora", "Toppo", "Abc", "Ranchi", "Jhk", "101101", "9800112231",
				"sippora@gmail.com"));
		person.add(new Contacts("Sabnam", "Bano", "Civil Lines", "Allahabad", "UP", "123321", "9988001012",
				"farida@yahoo.com"));
		ContactPerson p = new ContactPerson(person);
		p.writeAddressBookData(IOService.FILE_IO);
	}

	@Test
	public void readingAddressBook() {
		ContactPerson contactPerson = new ContactPerson();
		List<Contacts> entries = ContactPerson.readPersonData(IOService.FILE_IO);
	}
}
