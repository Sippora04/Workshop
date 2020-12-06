package com.workshop;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Addressbook_DBTest {

	// UC16: Retrieve all entries from the Database
	@Test
	public void contactsWhenRetrievedFromDB_ShouldMatchCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
		Assert.assertEquals(1, contactList.size());
	}
<<<<<<< HEAD
	//UC17
=======

>>>>>>> UC18
	@Test
	public void givenNewSalaryForEmployee_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		List<Contacts> contactList = addressBookService.readContactData();
<<<<<<< HEAD
		addressBookService.updateContactDetails("Sippora", "ByWay");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("Sippora");
		Assert.assertTrue(result);
	}
=======
		addressBookService.updateContactDetails("Sippora", "St Diago Road");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("ByWay");
		Assert.assertTrue(result);
	}

	@Test
	public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate startDate = LocalDate.of(2018, 01, 01);
		LocalDate endDate = LocalDate.now();
		List<Contacts> contactList = addressBookService.readContactDataForDateRange(startDate, endDate);
		Assert.assertEquals(1, contactList.size());
	}
>>>>>>> UC18
}
