package com.workshop;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");
		Scanner obj = new Scanner(System.in);

		ContactPerson add = new ContactPerson();
		int ch = 0;
		System.out.println("Enter 1 to enter into Address Book");
		int choose = obj.nextInt();
		while (choose==1) {
			System.out.println("1) Enter add details");
			System.out.println("2) Enter to edit details");
			if (ch == 1) {
				Contacts p = new Contacts();
				System.out.println("Enter First Name");
				p.setFirst_name(obj.next());
				System.out.println("Enter Last Name");
				p.setLast_name(obj.next());
				System.out.println("Enter Address");
				p.setAddress(obj.next());
				System.out.println("Enter City");
				p.setCity(obj.next());
				System.out.println("Enter State");
				p.setState(obj.next());
				System.out.println("Enter Zip Code");
				p.setZip(obj.next());
				System.out.println("Enter Phone Number");
				p.setPhno(obj.next());
				System.out.println("Enter Email");
				p.setEmail(obj.next());
				add.addPerson(p);
			}

			if (ch == 2) {

				System.out.println("Enter the name of person whose contact is to be modified");
				String name = obj.next();
				while (true) {
					System.out.println(
							"1. First name\n 2.Last name\n 3.Address\n 4. City\n 5. State\n 6. Zip\n 7. Phone number\n 8.Email\n 0. Exit");
					System.out.println("Enter the info to be modified");
					int info_name = obj.nextInt();
					add.Modify(name, info_name);
					if (info_name == 0) {
						break;
					}
				}
			}
			else {
				break;
			}
		}
	}
}