package com.workshop;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddressBookRestAssuredTest {

	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
	}

	public Contacts[] getContactList() {
		Response response = RestAssured.get("/contacts");
		System.out.println("Contacts entries in JSON Server :\n" + response.asString());
		Contacts[] arrayOfContacts = new Gson().fromJson(response.asString(), Contacts[].class);
		return arrayOfContacts;
	}

	public Response addContactToJsonServer(Contacts c) {
		String contactJson = new Gson().toJson(c);
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(contactJson);
		return request.post("/contacts");
	}

	@Test
	public void givenNewContact_WhenAdded__ShouldMatch() {
		AddressBookService addressBookService;
		Contacts[] arrayOfContacts = getContactList();
		addressBookService = new AddressBookService(Arrays.asList(arrayOfContacts));
		Contacts personInfo = null;
		personInfo = new Contacts("Anand", "Kumar", "JB Road", "Noida", "UP", "123123", "8989001087",
				"anand_kumar@gmail.com", "Dairy 2020", "Friend", LocalDate.now());
		Response response = addContactToJsonServer(personInfo);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
		personInfo = new Gson().fromJson(response.asString(), Contacts.class);
		addressBookService.addContactToAddressBook(personInfo);
		long entries = addressBookService.countEntries();
		Assert.assertEquals(2, entries);
	}
	
	@Test
	public void givenEmployeeDataInJSONServer_WhenRetrieved_ShouldMatchTheCount() {
		Contacts[] arrayOfContacts = getContactList();
		AddressBookService addressBookService;
		addressBookService = new AddressBookService(Arrays.asList(arrayOfContacts));
		long entries = addressBookService.countEntries();
		Assert.assertEquals(2, entries);
	}
}
