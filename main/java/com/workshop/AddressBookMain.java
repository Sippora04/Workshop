package com.workshop;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");

		Scanner obj = new Scanner(System.in);
		AddressBookDict address = new AddressBookDict();
		while (true) {
			System.out.println("Enter 1 to add addressbook");
			System.out.println("Enter 0 to exit");
			int ch1 = obj.nextInt();
			if (ch1 == 1) {
				System.out.println("Enter the Address Book Name");
				String add_book_name = obj.next();
				ContactPerson contactPerson = new ContactPerson();
				address.addAddressBook(add_book_name, contactPerson);
				while (true) {
					System.out.println("Enter 1 to add details");
					System.out.println("Enter 2 for viewing all contact details");
					System.out.println("Enter 3 to edit details");
					System.out.println("Enter 4 to delete details of a person");
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
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		obj.close();
	}
}
