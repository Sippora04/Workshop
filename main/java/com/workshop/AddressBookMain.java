package com.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(AddressBookMain.class.getName());

		log.info("Welcome To Address Book Program");

		ArrayList<Contacts> addPerson = new ArrayList<>();
		Scanner obj = new Scanner(System.in);
		AddressBookDict address = new AddressBookDict();
		ContactPerson contactPerson = new ContactPerson(addPerson);
		boolean flag = true;
		do {
			log.info("Enter 1 to add addressbook");
			log.info("Enter 2 to add contact");
			log.info("Enter 3 to view details");
			log.info("Enter 4 to modify details");
			log.info("Enter 5 to delete contact details");
			log.info("Enter 6 to get persons of same city or state");
			log.info("Enter 7 to get count of person belonging to same city or state");
			log.info("Enter 8 to get sorted list of contacts by person name");
			log.info("Enter 9 to get sorted list by city,state or zip");
			log.info("Enter 10 to view all address book details");
			log.info("Enter 11 to display person across address book on basis of city");
			log.info("Enter 12 to display person across address book on basis of state");
			log.info("Enter 0 to exit");
			log.info("Enter any number for further proceed");
			int ch1 = obj.nextInt();
			if (ch1 == 1) {
				contactPerson.createAddressBook(address);
				flag = true;
			}
			if (ch1 == 2) {
				contactPerson.createConatct(address);
				flag = true;
			}
			if (ch1 == 3) {
				contactPerson.viewAllContacts(address);
				flag = true;
			}
			if (ch1 == 4) {
				contactPerson.modify(address);
				flag = true;
			}
			if (ch1 == 5) {
				contactPerson.remove(address);
				flag = true;
			}
			if (ch1 == 6) {
				contactPerson.getPersonByCityNameStateName(address);
				flag = true;
			}
			if (ch1 == 7) {
				contactPerson.getCountByCityByState(address);
				flag = true;
			}
			if (ch1 == 8) {
				contactPerson.sortByName(address);
				flag = true;
			}
			if (ch1 == 9) {
				contactPerson.sortByCityStateOrZip(address);
				flag = true;
			}
			if (ch1 == 10) {
				address.viewAddressBook();
				flag = true;
			}
			if (ch1 == 11) {
				address.searchAddressBookByCity();
				flag = true;
			}
			if (ch1 == 12) {
				address.searchAddressBookByState();
				flag = true;
			}
			if (ch1 == 0) {
				flag = false;
			}
		} while (flag != false);
		obj.close();
	}
}