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
				System.out.println("Enter the Address Book Name:");
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
						contactPerson.addPerson();
					} else if (ch == 2) {
						contactPerson.viewAllContacts();
					} else if (ch == 3) {
						System.out.println("Enter the name of person whose contact is to be edited");
						String name = obj.next();
						while (true) {
							System.out.println(
									"1. First name\n 2.Last name\n 3.Address\n 4. City\n 5. State\n 6. Zip\n 7. Phone number\n 8.Email\n 0. Exit");
							System.out.println("Enter the information to be edit");
							int info_name = obj.nextInt();
							contactPerson.Modify(name, info_name);
							if (info_name == 0) {
								break;
							}
						}
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