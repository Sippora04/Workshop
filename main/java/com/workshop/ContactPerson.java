package com.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContactPerson {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	Logger log = Logger.getLogger(ContactPerson.class.getName());
	Scanner obj = new Scanner(System.in);
	private ArrayList<Contacts> person;

	public ContactPerson() {
	}

	public ContactPerson(ArrayList<Contacts> person) {
		this.person = person;
	}

	public void setPerson(ArrayList<Contacts> person) {
		this.person = person;
	}

	public ArrayList<Contacts> getPerson() {
		return person;
	}

	public void createAddressBook(AddressBookDict addressBook) {
		log.info("Enter the Address Book Name: ");
		String add_book_name = obj.next();
		addressBook.addAddressBook(add_book_name);
		log.info("Address book is created");
	}

	public void createConatct(AddressBookDict addressBook) {
		log.info("Enter the address book name which you want to add this contact");
		String addressBookName = obj.next();
		Contacts p = new Contacts();
		Contacts p1 = addPerson(p);
		boolean createContact = addressBook.addContact(addressBookName, p1);
		if (createContact == false) {
			log.info("Contact can't be created. Try with another name");
		} else {
			log.info("Contact Added");
		}
	}

	public Contacts addPerson(Contacts p) {
		log.info("Enter First Name: ");
		String fname = obj.next();
		log.info("Enter Last Name: ");
		String lname = obj.next();
		log.info("Enter Address: ");
		String address = obj.next();
		log.info("Enter City: ");
		String city = obj.next();
		log.info("Enter State: ");
		String state = obj.next();
		log.info("Enter the 6 digit zip code: ");
		String zipCode = obj.next();
		String pattern3 = "^[1-9]{1}[0-9]{5}$";
		Pattern zip_pattern = Pattern.compile(pattern3);
		Matcher m3 = zip_pattern.matcher(zipCode);
		if (m3.matches() == false) {
			log.info("zip code not in format enter again");
			zipCode = obj.next();
		}
		log.info("Enter the 10 digit Phone Number: ");
		String phoneNo = obj.next();
		String pattern1 = "^[1-9]{1}[0-9]{9}$";
		Pattern mobile_pattern = Pattern.compile(pattern1);
		Matcher m1 = mobile_pattern.matcher(phoneNo);
		if (m1.matches() == false) {
			log.info("phone number not in format enter again");
			phoneNo = obj.next();
		}
		log.info("Enter Email: ");
		String email = obj.next();
		String pattern2 = "^[a-zA-Z0-9]+((\\.[0-9]+)|(\\+[0-9]+)|(\\-[0-9]+)|([0-9]))*@*+[a-zA-Z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern email_sample = Pattern.compile(pattern2);
		Matcher m2 = email_sample.matcher(email);
		if (m2.matches() == false) {
			log.info("email not in format enter again");
			email = obj.next();
		}
		p = new Contacts(fname, lname, address, city, state, zipCode, phoneNo, email);
		return p;
	}

	public void writeAddressBookData(IOService ioService) throws IOException {
		if (ioService.equals(IOService.CONSOLE_IO))
			log.info("Contact Person Data " + person);
		else if (ioService.equals(IOService.FILE_IO)) {
			new AddressBookFileIO().writeDataFileIO(person);
		}
	}

	public boolean isEmpty() {
		return person.isEmpty();
	}

	public void viewAllContacts(AddressBookDict addressBook) {
		log.info("Enter the address book name of whose contact list you want to see");
		String addressBookName = obj.next();
		List<Contacts> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			log.info("List is empty");
		} else {
			log.info("Contacts in address book " + addressBookName + "are :");
			ContactList.stream().forEach((System.out::println));
			log.info("\n");
		}
	}

	public void modify(AddressBookDict addressBook) {
		log.info("Enter the address book name whose contact you want to edit");
		String addressBookName = obj.next();
		log.info("Enter the name whose contact you want to edit");
		String name = obj.next();
		Contacts p = addressBook.getContactByName(addressBookName, name);
		if (p == null) {
			log.info("No such contact exists");
		} else {
			while (true) {
				log.info(
						"1. First name\n 2.Last name\n 3.Address\n 4. City\n 5. State\n 6. Zip\n 7. Phone number\n 8.Email\n 0. Exit");
				log.info("Enter the information to be modified");
				int info_name = obj.nextInt();
				switch (info_name) {
				case 1:
					log.info("Enter new First Name: ");
					p.setFirst_name(obj.next());
					break;
				case 2:
					log.info("Enter new Last Name: ");
					p.setLast_name(obj.next());
					break;
				case 3:
					log.info("Enter new Address: ");
					p.setAddress(obj.next());
					break;
				case 4:
					log.info("Enter new City: ");
					p.setCity(obj.next());
					break;
				case 5:
					log.info("Enter new State: ");
					p.setState(obj.next());
					break;
				case 6:
					log.info("Enter new Zip Code: ");
					p.setZip(obj.next());
					break;
				case 7:
					log.info("Enter new Phone Number: ");
					p.setPhno(obj.next());
					break;
				case 8:
					log.info("Enter new Email: ");
					p.setEmail(obj.next());
					break;
				}
				if (info_name == 0) {
					break;
				}
			}
		}
	}

	public void remove(AddressBookDict addressBook) {
		log.info("Enter the address book name from where you want to delete the contact");
		String addressBookName = obj.next();
		log.info("Enter the person name whose contact you want to delete");
		String name = obj.next();
		Contacts p = addressBook.getContactByName(addressBookName, name);
		if (p == null) {
			log.info("No such contact exists");
		} else {
			addressBook.removeContact(addressBookName, p);
			log.info("Details of " + name + " removed");
		}
	}

	public void getPersonByCityNameStateName(AddressBookDict addressBook) {
		log.info("Enter the address book name whose contacts you want to see by city name");
		String addressBookName = obj.next();
		List<Contacts> ContactList = addressBook.getContactList(addressBookName);
		log.info("Choice \n 1. get person by city name 2. get person by state name");
		int choice = obj.nextInt();
		Map<String, List<Contacts>> personList = new HashMap<String, List<Contacts>>();
		if (choice == 1) {
			personList = (ContactList.stream().collect(Collectors.groupingBy(Contacts::getCity, Collectors.toList())));
			personList.entrySet().forEach(entry -> log.info(entry.getKey() + " " + entry.getValue()));
		}
		if (choice == 2) {
			personList = (ContactList.stream().collect(Collectors.groupingBy(Contacts::getState, Collectors.toList())));
			personList.entrySet().forEach(entry -> log.info(entry.getKey() + " " + entry.getValue()));
		}
		if (personList.isEmpty()) {
			log.info("Add contacts to get person by cities");
		}
	}

	public void sortByName(AddressBookDict addressBook) {
		log.info("Enter the address book name whose contacts you want to see in sorted order by name");
		String addressBookName = obj.next();
		List<Contacts> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			log.info("Empty list");
		}
		List<Contacts> sortedByName = new ArrayList<Contacts>();
		ContactList.stream().sorted((con1, con2) -> (con1.getFirst_name() + con1.getLast_name())
				.compareTo(con2.getFirst_name() + con2.getLast_name())).forEach(con -> sortedByName.add(con));
		for (Contacts p : sortedByName) {
			System.out.println(p);
		}
	}

	public void sortByCityStateOrZip(AddressBookDict addressBook) {
		log.info("Enter the address book name whose contacts you want to see in sorted order by city or state or zip");
		String addressBookName = obj.next();
		List<Contacts> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			log.info("Empty list");
		}
		log.info("choice \n 1. sort by city \n 2. sort by state \n 3. sort by zip");
		int choice = obj.nextInt();
		List<Contacts> sortedList = new ArrayList<Contacts>();
		if (choice == 1) {
			ContactList.stream().sorted((con1, con2) -> (con1.getCity().compareTo(con2.getCity())))
					.forEach(con -> sortedList.add(con));
		}
		if (choice == 2) {
			ContactList.stream().sorted((con1, con2) -> (con1.getState().compareTo(con2.getState())))
					.forEach(con -> sortedList.add(con));
		}
		if (choice == 3) {
			ContactList.stream().sorted((con1, con2) -> (con1.getZip().compareTo(con2.getZip())))
					.forEach(con -> sortedList.add(con));
		}
		for (Contacts p : sortedList) {
			System.out.println(p);
		}
	}

	public void getCountByCityByState(AddressBookDict addressBook) {
		log.info("Enter the address book name whose contacts you want to see in sorted order  by zip code");
		String addressBookName = obj.next();
		List<Contacts> ContactList = addressBook.getContactList(addressBookName);
		log.info("Enter the city name");
		String cityName = obj.next();
		Long personByCity = ContactList.stream().filter(PersonInfo -> PersonInfo.getCity().equals(cityName)).count();
		log.info("No of person in same city : " + personByCity);
		log.info("Enter the state name");
		String stateName = obj.next();
		Long personByState = ContactList.stream().filter(PersonInfo -> PersonInfo.getState().equals(stateName)).count();
		log.info("No of person in same state : " + personByState);
	}

	public static List<Contacts> readPersonData(IOService fileIo) {
		List<Contacts> contact = null;
		if (fileIo.equals(IOService.FILE_IO))
			contact = (List<Contacts>) new AddressBookFileIO().readData();
		return contact;
	}
}