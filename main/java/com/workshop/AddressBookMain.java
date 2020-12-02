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
		while (true) {
			System.out.println("Enter 1) add addressbook");
			System.out.println("Enter 2) display address book");
			System.out.println("Enter 3) view person contact by city");
			System.out.println("Enter 4) view person contact by state");
			System.out.println("Enter 0) exit");
			int ch1 = obj.nextInt();
			if (ch1 == 1) {
				System.out.println("Enter the Address Book Name");
				String add_book_name = obj.next();
				ContactPerson contactPerson = new ContactPerson();
				address.addAddressBook(add_book_name, contactPerson);
				while (true) {
					System.out.println("Enter 1 to add details");
					System.out.println("Enter 2 for viewing all contact details");
					System.out.println("Enter 3 to modify details");
					System.out.println("Enter 4 to delete details of a person");
					System.out.println("Enter 5 to get persons of same city");
					System.out.println("Enter 6 to get persons of same State");
					System.out.println("Enter 0 to exit");
					System.out.println("Enter any number for further proceed");
					int ch = obj.nextInt();
					if (ch == 1) {
						while (true) {
							System.out.println("Enter the name of person whose conatct you need to add");
							String name = obj.next();
							boolean flag = (contactPerson.getPerson()).stream()
									.noneMatch(person -> person.getFirst_name().equals(name));
							if (flag == false) {
								System.out.println("Contact with this name exist give another name");
								continue;
							} else {
								contactPerson.addPerson();
								break;
							}
						}
					} else if (ch == 2) {
						contactPerson.viewAllContacts();
					} else if (ch == 3) {
						System.out.println("Enter the name of person whose contact is to be edited");
						String name = obj.next();
						contactPerson.Modify(name);
					} else if (ch == 4) {
						System.out.println("Enter the name of person whose contact is to be deleted");
						String name = obj.next();
						contactPerson.remove(name);
					} else if (ch == 5) {
						System.out.println("Enter the city name: ");
						String cityName = obj.next();
						List<Contacts> personByCity = new ArrayList<Contacts>();
						personByCity = (contactPerson.getPerson()).stream().filter(c -> c.getCity().equals(cityName))
								.collect(Collectors.toList());
						for (Contacts contact : personByCity) {
							System.out.println(contact.getFirst_name());
						}
					} else if (ch == 6) {
						System.out.println("Enter the state name: ");
						String stateName = obj.next();
						List<Contacts> personByState = new ArrayList<Contacts>();
						personByState = (contactPerson.getPerson()).stream().filter(c -> c.getState().equals(stateName))
								.collect(Collectors.toList());
						for (Contacts contact : personByState) {
							System.out.println(contact.getFirst_name());
						}
					} else {
						break;
					}
				}
			} else if (ch1 == 2) {
				address.viewAddressBook();
			} else if (ch1 == 3) {
				address.searchAddressBookByCity();
			} else if (ch1 == 4) {
				address.searchAddressBookByState();
			} else {
				break;
			}
		}
		obj.close();
	}
}
