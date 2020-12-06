package com.workshop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Addressbook_DBTest {

	//UC16: Retrieve all entries from the Database
	@Test
	public void contactsWhenRetrievedFromDB_ShouldMatchCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
		Assert.assertEquals(1, contactList.size());
	}
}
