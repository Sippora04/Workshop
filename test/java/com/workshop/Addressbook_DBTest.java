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
	//UC17
	@Test
	public void givenNewSalaryForEmployee_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
		addressBookService.updateContactDetails("Sippora", "ByWay");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("Sippora");
		Assert.assertTrue(result);
	}
}
