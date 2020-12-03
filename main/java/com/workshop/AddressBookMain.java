package com.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome To Address Book Program");

		Scanner obj = new Scanner(System.in);
		AddressBookDict address = new AddressBookDict();
		ContactPerson contactPerson = new ContactPerson();
		boolean flag = true;
		while (flag == true) {
			System.out.println("Enter 1 to add addressbook");
			System.out.println("Enter 2 to add contact");
			System.out.println("Enter 3 to view details");
			System.out.println("Enter 4 to modify details");
			System.out.println("Enter 5 to delete contact details");
			System.out.println("Enter 6 to get persons of same city or state");
			System.out.println("Enter 7 to get count of person belonging to same city or state");
			System.out.println("Enter 8 to get sorted list of contacts by person name");
			System.out.println("Enter 9 to get sorted list by city,state or zip");
			System.out.println("Enter 10 to view all address book details");
			System.out.println("Enter 11 to display person across address book on basis of city");
			System.out.println("Enter 12 to display person across address book on basis of state");
			System.out.println("Enter 0 to exit");
			System.out.println("Enter any number for further proceed");
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
		}
		obj.close();
	}
}